package com.bookStore.controller;

import com.bookStore.dto.BookDTO;
import com.bookStore.dto.MyBookListDTO;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.repo.MyBookRepository;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

       @GetMapping(
            path = "/"
    )
    public String home() {
        return "home";
    }

    @GetMapping(
            path = "/book_register"
    )
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping(
            path = "/available_books"
    )
    public ModelAndView getAllBook() {
        List<BookDTO> bookDTOS = bookService.getAllBooks();
        return new ModelAndView("bookList", "book", bookDTOS);
    }

//    @GetMapping(
//            path = "/available_books"
//    )
//    public List<BookDTO> getAllBooks(){
//        List<BookDTO> bookDTOS = bookService.getAllBooks();
//        return bookDTOS;
//    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBookList>list=myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @GetMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=bookService.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }


  }