package com.example.entity;

import javax.persistence.*;

@Entity
@Table (name = "contract")
public class Contract {
    @Id
    @CheckId
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public Contract() {
    }

    public Contract(long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
