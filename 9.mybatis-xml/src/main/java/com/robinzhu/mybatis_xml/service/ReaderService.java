package com.robinzhu.mybatis_xml.service;

import com.robinzhu.mybatis_xml.entity.ReaderDo;

import java.util.List;

public interface ReaderService {
    List<ReaderDo> findAll();
    Integer insert(ReaderDo readerDo);
}
