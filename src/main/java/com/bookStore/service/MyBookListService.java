package com.bookStore.service;

import com.bookStore.dto.MyBookListDTO;
import com.bookStore.entity.MyBookList;

import java.util.List;

public interface MyBookListService {
    void save(MyBookList bookList);

    void saveMyBooks(MyBookList mb);

    void deleteById(int id);

    List<MyBookList> getAllMyBooks();
}
