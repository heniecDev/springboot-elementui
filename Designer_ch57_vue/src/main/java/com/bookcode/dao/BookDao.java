package com.bookcode.dao;
import com.bookcode.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer>,JpaSpecificationExecutor<Book> {
    @Query(value = "select * from crud_book where crud_book.bookname like %?1% ",nativeQuery = true)
    public List<Book>findByName(String name);
    @Query(value = "select * from crud_book OEDER BY RAND() limit  ?1 ",nativeQuery = true)
    public  List<Book> randomList(Integer num);
    @Query(value = "select * from crud_book WHERE bookid = '<bookid>'",nativeQuery = true)
    public Book findBookById(Integer id);
    @Query(value = "insert into crud_book (bookid,bookname,bookauthor) values(?1,?2,?3)",nativeQuery = true)
    public Book add( Integer bookid,String bookname, String bookauthor);
    @Modifying
    @Transactional
    @Query(value = "insert into crud_book(bookid, bookname, bookauthor) values(:bookid, :bookname, :bookauthor)",nativeQuery = true)
    void saveBook(@Param("bookid") Integer bookid, @Param("bookname") String bookname, @Param("bookauthor") String bookauthor);
//    @Query(value = "update * from crud_book WHERE bookid = '<bookid>'",nativeQuery = true)
//    public Book update(Integer id,String author,String name);

}
