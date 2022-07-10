package com.dolien;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dolien.pojo.Book;
import com.dolien.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestService {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.update(book);
    }
    @Test
    void testDelete(){
        bookService.delete(52);
    }

    @Test
    void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(2, 5, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
