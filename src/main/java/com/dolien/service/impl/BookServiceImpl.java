package com.dolien.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dolien.mapper.BookMapper;
import com.dolien.pojo.Book;
import com.dolien.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book queryBook) {
        IPage<Book> page = new Page<>(currentPage, pageSize);

        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        if(queryBook.getName() != null && !queryBook.getName().equals("")){
            wrapper.like(Book::getName, queryBook.getName());
        }
        if(queryBook.getType() != null && !queryBook.getType().equals("")){
            wrapper.like(Book::getType, queryBook.getType());
        }

        if(queryBook.getDescription() != null && !queryBook.getDescription().equals("")){
            wrapper.like(Book::getDescription, queryBook.getDescription());
        }

        bookMapper.selectPage(page, wrapper);
        return page;
    }
}
