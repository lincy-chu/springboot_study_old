package com.robinzhu.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Create by zhudapeng
 * 2019-08-13 21:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthorTest {
    @Autowired
    private AuthorMapper userMapper;

    @Test
    public void insert() {
        Author user = new Author();
        user.setName("向3D");
        user.setAge(89);
        user.setEmail("xs@baomidou.com");
        user.setManagerId("c62d6a6488f9d60b60d7e48eeb80c704");
        user.setCreateTime(LocalDateTime.now());
        user.setRemark("向三维的备注");
        int rows = userMapper.insert(user); // 返回影响记录数
        log.info(String.valueOf(user));
        Assert.assertEquals(1, rows);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void deleteByMap() {
        /**
         * 根据map进行删除
         */
        Map<String, Object> map = new HashMap<>();
        map.put("author_name", "朱棣文"); // 多个字段时相当于同时满足条件
        Integer integer = userMapper.deleteByMap(map);
        if (integer.equals(1)) {
            System.out.println("根据map删除成功!");
        } else {
            System.out.println("根据map删除失败");
        }
    }

    @Test
    public void delete() {
        /**
         * 根据entity条件，删除记录
         * @params wrapper实体对象封装操作类，可以为null
         * @return 删除成功记录数
         */
        QueryWrapper<Author> authorWrapper = new QueryWrapper<>();
        authorWrapper.like("author_name", "朱祁钰").or().like("author_name", "朱祁镇");
        Integer integer = userMapper.delete(authorWrapper);
        if (integer.equals(2)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void selectByIdTest() {
        Author author = userMapper.selectById("132db284bdd2b6907624cfb9d82998c2");
        System.out.println(author);
    }

    @Test
    public void selectByIds() {
        /**
         * 根据id批量删除
         */
        List<String> list = Arrays.asList("6783fcbae1ec503a5e93d9725789ef5c", "c62d6a6488f9d60b60d7e48eeb80c704", "02f4545f737ff0ab58c9cbf8e7f5d843");
        List<Author> authors = userMapper.selectBatchIds(list); // selectBatchIds接收id数组
        authors.forEach(System.out::println);
    }

    @Test
    public void updateByIdTest() {
        /**
         * 根据id更新数据
         * @param entity实体对象
         * @return 修改记录数
         */
        Author author = new Author();
        String id = "070b4c7eabff758ed333cf63529d27b7";
        author.setId(id);
        author.setName("朱明");
        author.setEmail("zhuzhu123@qq.com");
        Integer integer = userMapper.updateById(author);
        if (integer.equals(1)) {
            System.out.println(userMapper.selectById(id));
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void updateTest() {
        /**
         * 根据whereEntity条件，更新记录
         * @param entity 实体对象（set条件值，可为null）
         * @param updateWrapper 实体对象封装操作类（可为null，里面的entity用于生成where语句）
         * @return 修改成功记录数
         */
        Author author = new Author();
        author.setName("老胡");
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.likeRight("author_name", "朱");
        Integer integer = userMapper.update(author, queryWrapper);
        System.out.println("更新条数" + integer);
    }

    @Test
    public void selectByMap() { // 通过map形成多条件并列查找
        /**
         * 通过多条件进行删除
         * map.put("name", "刘红雨")
         * map.put("age", 30)
         * = where name = "刘红雨" and age = 30
         */
        Map<String, Object> map = new HashMap<>();
        // map.put("author_name", "王天风");
        // map.put("age", 32); // 第一个参数是数据表中对应的列名（而不是实体类中的字段名）
        map.put("manager_id", "c62d6a6488f9d60b60d7e48eeb80c704");
        List<Author> author = userMapper.selectByMap(map);
        author.forEach(System.out::println);
    }

    @Test
    public void selectOne() {
        /**
         * 根据entity条件查找，查询一条
         * @param queryWrapper 实体对象
         * @return 实体
         */
        QueryWrapper<Author> wrapper = Wrappers.query();
        wrapper.eq("author_id", "070b4c7eabff758ed333cf63529d27b7"); // eq等于
        Author author = userMapper.selectOne(wrapper);
        System.out.println(author);
    }

    @Test
    public void selectCount() {
        /**
         * 根据wrapper条件，查询总记录数
         * @param queryWrapper 实例对象
         * @return 满足条件的记录条数
         */
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.likeRight("email", "123");
        Integer integer = userMapper.selectCount(queryWrapper);
        System.out.println(integer);
    }

    @Test
    public void selectObjs() {
        /**
         * 根据Wrapper条件，查询全部记录
         * 注意：只返回第一个字段的值，比如第一个字段为author_id，则只返回其值
         */
        Author author = userMapper.selectById("070b4c7eabff758ed333cf63529d27b7");
        List<Object> authors = userMapper.selectObjs(new QueryWrapper<Author>().eq("email", author.getEmail()));
        authors.forEach(System.out::println);
    }

    @Test
    public void selectPageTest() {
        /**
         * 根据entity条件，查询全部记录（并翻页）
         * @param page 分页查询条件（可为RowBounds.DEFAULT）
         * @param queryWrapper 实体对象封装造作类（可为null）
         * @return 实体分页对象
         */
        IPage<Author> page = new Page<>(1, 5);
        QueryWrapper wrapper = Wrappers.query();
        wrapper.like("author_name", "老胡");
        IPage<Author> authorIPage = userMapper.selectPage(page, wrapper);
        System.out.println(authorIPage);
    }

    @Test
    public void selectByWrapper() { // 通过条件构造器查找
        /**
         * 1.名字中包含雨并且年龄小于40
         * name like '%雨%' and age < 40
         */
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>(); // 创建条件构造器，方式1
        // QueryWrapper<Author> queryWrapper1 = Wrappers.query(); // 创建条件构造器，方式2
        queryWrapper.like("author_name", "雨").lt("age", 40); // column均为数据表中的列名
        List<Author> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper1() { // 通过自定义的条件构造器进行查找
        /**
         * 2.名字中包含雨并且年龄大于等于20且小于40并且email不为空
         * name like "%雨%" and age between 20 and 40 and email is not null
         */
        QueryWrapper<Author> query = Wrappers.query();
        query.like("author_name", "雨").between("age", 20, 40).isNotNull("email");
        List<Author> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper2() {
        /**
         * 3.名字为王姓或者年龄大于等于25，按年龄降序排列，年龄相同按照id剩余排列
         * name like '王%' or age >= 25 order by age desc, id asc
         */
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("author_name", "王") // likeRight表示只有右侧有通配符%
                .or() // 等价于或者
                .ge("age", 25) // ge大于等于
                .orderByDesc("age").orderByAsc("author_id");
        List<Author> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
