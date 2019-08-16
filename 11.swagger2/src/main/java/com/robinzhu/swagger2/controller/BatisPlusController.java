package com.robinzhu.swagger2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.robinzhu.swagger2.entity.Author;
import com.robinzhu.swagger2.entity.CommonException;
import com.robinzhu.swagger2.entity.Result;
import com.robinzhu.swagger2.mapper.AuthorMapper;
import com.robinzhu.swagger2.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-13 23:26
 */
@RestController
@RequestMapping("/batisPlus")
@Api(tags = "mybatis plus API")
public class BatisPlusController {
    @Autowired
    AuthorMapper authorMapper;

    @PostMapping("/insert")
    @ApiOperation(value = "新增")
    // 正常业务时，需要在类里进行事务控制，控制层一般不进行业务控制
    @Transactional(rollbackFor = Exception.class)
    public Result insert(@Valid @RequestBody Author author) {
        authorMapper.insert(author);
        return ResultUtil.success();
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表获取")
    public Result list() {
        List<Author> authors = authorMapper.selectList(null);
        return ResultUtil.success(authors);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@Valid @RequestBody Author author) {
        if (author.getId() == null || "".equals(author.getId())) {
            throw new CommonException(1005, "更新时id不能为空", null);
        }
        Author author1 = new Author();
        author1.setName(author.getName());
        author1.setAge(author.getAge());
        author1.setEmail(author.getEmail());
        author1.setId(author.getId());
        author1.setCreateTime(author.getCreateTime());
        authorMapper.updateById(author1);
        return ResultUtil.success();
    }

    /**
     * @ApiImplicitParams: 用在请求的方法上，表示一组参数说明
     *   @ApiImplicitParam: 常用在@ApiImplicitParams注解中或单独使用，指定一个请求参数的各方面
     *      name：参数名
     *      required：参数的汉字说明、解释
     *      paramType：参数放在什么地方
     *          header --> 请求参数的获取：@RequestHeader
     *          query  --> 请求参数的获取：@RequestParam
     *          path(用于restful接口) --> 请求参数的获取：@PathVariable
     *          body(不常用)
     *          form(不常用)
     *      dataType：参数类型，默认String，其他值如dataType="Integer"
     *      defaultValue: 参数的默认值
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageIndex", value = "页数", required = true),
        @ApiImplicitParam(name = "pageSize", value = "每页数据数", required = true)
    })
    public Result page(int pageIndex, int pageSize){
        // 分页
        Page<Author> page = new Page<>(pageIndex, pageSize);
        return ResultUtil.success(authorMapper.selectPage(page, null));
    }

}
