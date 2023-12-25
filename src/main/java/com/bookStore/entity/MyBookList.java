package com.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


@Table(name = "MyBooks")
public class MyBookList {
    @Id
    @Column(name = "book_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name", length = 100, nullable = false)
    private String name;

    @Column(name = "author", length = 100, nullable = false)
    private String author;

    @Column(name = "price", length = 100, nullable = false)
    private String price;
}
