package com.dolien.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dolien.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
