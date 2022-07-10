package com.dolien.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dolien.pojo.Book;
import com.dolien.service.BookService;
import com.dolien.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result getAll(){
        List<Book> list = bookService.getAll();
        return new Result(true, list);
    }

    @PostMapping
    public Result save(@RequestBody Book book){
        return new Result(bookService.save(book), null);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(bookService.update(book), null);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") int id){
        return new Result(bookService.delete(id), null);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable("id") int id){
//        System.out.println("热部署。。。。。");
//        System.out.println("热部署。。。。。");
//        System.out.println("热部署。。。。。");
        System.out.println("热部署。。。。。");
        System.out.println("热部署。。。。。");
        System.out.println("热部署。。。。。");
        return new Result(true, bookService.getById(id));
    }

    @GetMapping("{curPage}/{pageSize}")
    public Result getPage(@PathVariable("curPage") int cur, @PathVariable("pageSize") int size, Book book){
        IPage<Book> page = bookService.getPage(cur, size, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(cur > page.getPages()){
            page = bookService.getPage((int)page.getPages(), size, book);
        }
        return new Result(true, page);
    }
}
