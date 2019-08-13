package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.ReaderDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReaderMapper {
    List<ReaderDo> findAll();
    ReaderDo get(String id);
    Integer insert(ReaderDo readerDo);
    void update(ReaderDo readerDo);
    void delete(String id);
}
