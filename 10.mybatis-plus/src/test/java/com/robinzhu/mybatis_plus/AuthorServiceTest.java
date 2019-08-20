package com.robinzhu.mybatis_plus;

import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthorServiceTest {
    @Autowired
    AuthorService authorService;

    @Test
    public void saveTest() {
        Author author = new Author();
        author.setName("朱德");
        author.setAge(26);
        author.setEmail("zhude@163.com");
        author.setCreateTime(LocalDateTime.now());
        Boolean res = authorService.save(author);
        if (res.equals(true)) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
    }
}
