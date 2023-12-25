package com.bookStore.service.impl;

import com.bookStore.entity.MyBookList;
import com.bookStore.repo.MyBookRepository;
import com.bookStore.service.MyBookListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service

public class MyBookListServiceImpl implements MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(MyBookList bookList) {
        myBookRepository.save(bookList);
    }

    @PostMapping(
            path = "/save-my-books"
    )
    public void saveMyBooks(MyBookList bookList){
        myBookRepository.save(bookList);
    }


    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }

//    @Override
//    public MyBookListDTO getBookById(int id) {
//        MyBookList bookList = myBookRepository.findById(id).get();
//        if (myBookRepository.existsById(id)) {
//            MyBookListDTO myBookListDTO = modelMapper.map(bookList, MyBookListDTO.class);
//            return myBookListDTO;
//        } else {
//            throw new RuntimeException("No BookList");
//        }
//    }
}
