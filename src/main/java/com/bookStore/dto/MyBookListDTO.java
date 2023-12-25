package com.bookStore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MyBookListDTO {

    private int id;
    private String name;
    private String author;
    private String price;
}
