package com.robinzhu.mybatis_xml.serviceImpl;

import com.robinzhu.mybatis_xml.entity.ReaderDo;
import com.robinzhu.mybatis_xml.mapper.ReaderMapper;
import com.robinzhu.mybatis_xml.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public List<ReaderDo> findAll() {
        return readerMapper.findAll();
    }

    @Override
    public Integer insert(ReaderDo readerDo) {
        return readerMapper.insert(readerDo);
    }
}
