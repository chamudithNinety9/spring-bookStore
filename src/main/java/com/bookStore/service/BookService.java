package com.bookStore.service;

import com.bookStore.dto.BookDTO;
import com.bookStore.entity.Book;

import java.util.List;

public interface BookService {

    String saveBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

    Book getBookById(int id);

    void save(Book b);

    void deleteById(int id);
}
