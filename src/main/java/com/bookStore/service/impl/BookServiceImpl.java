package com.bookStore.service.impl;

import com.bookStore.dto.BookDTO;
import com.bookStore.entity.Book;
import com.bookStore.repo.BookRepo;
import com.bookStore.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveBook(BookDTO bookDTO) {

        Book book = modelMapper.map(bookDTO, Book.class);
        if (!bookRepo.existsById(book.getId())) {
            bookRepo.save(book);
            return bookDTO.getId() + "Saved Successfully !";
        } else {
            throw new RuntimeException("Already Added:");
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepo.findAll();
        if (bookList.size() > 0) {
            List<BookDTO> bookDTOS = modelMapper.map(bookList, new TypeToken<List<BookDTO>>() {
            }.getType());
            return bookDTOS;
        } else {
            throw new RuntimeException("Book List Empty !");
        }

    }

    public Book getBookById(int id){
        return bookRepo.findById(id).get();
    }

    public void save(Book b) {
        bookRepo.save(b);
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }
}
