package com.bookStore.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


@Table(name = "book")

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

public class Book {

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
