package com.dolien;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dolien.mapper.BookMapper;
import com.dolien.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestMapper {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        List<Book> list = bookMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    void testGetById(){
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        int i = bookMapper.insert(book);
        System.out.println(i);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(52);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookMapper.updateById(book);
    }

    @Test
    void testPage(){
        Page<Book> page = new Page<>(2, 5);
        bookMapper.selectPage(page, null);
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testQuery(){
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Book::getType, "市场营销");

        List<Book> list = bookMapper.selectList(wrapper);
        System.out.println(list);
    }

}
