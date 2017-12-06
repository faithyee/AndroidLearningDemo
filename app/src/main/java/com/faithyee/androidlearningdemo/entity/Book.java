package com.faithyee.androidlearningdemo.entity;

import java.io.Serializable;

/**
 * Author：yewmf on 2017/12/6 10:08
 * E-mail：faith_yee@163.com
 */
public class Book implements Serializable{

    private int id;
    private String name;
    private Float price;
    private int pages;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                '}';
    }
}
