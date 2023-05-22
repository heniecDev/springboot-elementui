package com.bookcode.controller;
import com.bookcode.dao.BookDao;
import com.bookcode.entity.Book;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

//图书控制器
@Controller
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDao bookDao;
    //查询所有图书
    @RequestMapping("/list")
    public List<Book> list(){
        return bookDao.findAll();
    }
    //添加图书
//    @RequestMapping(value="/add",method=RequestMethod.POST)
    // 这两种写法一样
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        System.out.println(book.getId());
        System.out.println(book.getName());
        System.out.println(book.getAuthor());
        bookDao.saveBook(book.getId(),book.getName(),book.getAuthor());
        return "forward:/book/list";
    }
    //根据id查询book实体
    @RequestMapping("/findById/{id}")
    public Optional<Book> findById(@PathVariable("id")Integer id){

        return bookDao.findById(id);

    }
    //删除图书
    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")Integer id){
        System.out.println(id);
        bookDao.deleteById(id);
        return true;
    }
//    @PostMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        BookDao.deleteById(id);
//        return  "forward:/book/list";
//    }

//    //修改图书
//    @PostMapping(value="/update"
// )
//    public String update(Book book){
//        bookDao.save(book);
//        return  "forward:/book/list";
//    }
    //修改图书put请求
    @PostMapping("/update")
    public boolean update(@RequestBody Book book){
//        bookDao.update(book.getId(),book.getAuthor(),book.getName());
        bookDao.save(book);
        return true;
    }

    //根据条件动态查询
    @RequestMapping("/list2")
    public ModelAndView list2(Book book){
        ModelAndView mav = new ModelAndView();
        List<Book> bookList = bookDao.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if(book!=null){
                    if(book.getName()!=null && !"".equals(book.getName())){
                        predicate.getExpressions().add(cb.like(root.get("name"), "%"+book.getName()+"%"));
                    }
                    if(book.getAuthor()!=null && !"".equals(book.getAuthor())){
                        predicate.getExpressions().add(cb.like(root.get("author"),"%"+book.getAuthor()+"%"));
                    }
                }
                return predicate;
            }
        });
        mav.addObject("book",book);
        mav.addObject("booklist",bookList);
        mav.setViewName("bookList");
        return mav;
    }
    //查询
    @ResponseBody
    @RequestMapping("/query")
    public List<Book> findByName(String name){
        return bookDao.findByName("水");
    }
    //随机显示
    @ResponseBody
    @RequestMapping("/randomlist")
    public List<Book> randomList(String name){
        return bookDao.randomList(2);
    }
}
