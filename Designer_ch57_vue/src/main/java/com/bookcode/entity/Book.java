package com.bookcode.entity;

import javax.persistence.*;

@Entity
@Table(name="crud_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;
    @Column(length = 100)
    private String bookname;
    @Column(length = 50)
    private String bookauthor;

    public Book(){}

    public Book(String bookName,String author){
        this.bookname=bookName;
        this.bookauthor=author;
    }


    public Integer getId() {
        return bookid;
    }

    public void setId(Integer id) {
        this.bookid = id;
    }

    public String getName() {
        return bookname;
    }

    public void setName(String name) {
        this.bookname = name;
    }

    public String getAuthor() {
        return bookauthor;
    }

    public void setAuthor(String author) {
        this.bookauthor = author;
    }
}
