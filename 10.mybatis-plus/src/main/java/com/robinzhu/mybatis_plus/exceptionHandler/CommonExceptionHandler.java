package com.robinzhu.mybatis_plus.exceptionHandler;

/**
 * Create by zhudapeng
 * 2019-08-11 10:16
 */
import com.robinzhu.mybatis_plus.entity.CommonException;
import com.robinzhu.mybatis_plus.entity.Result;
import com.robinzhu.mybatis_plus.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建全局的统一异常处理类
 *    利用@ControllerAdvice和@ExceptionHandler定义一个统一异常处理类
 *    @ControllerAdvice： 控制器增强，使@ExceptionHandler、@InitBinder、@ModelAttribute注释的方法应用到所有的@RequestMapper注释的方法
 *    @ExceoptionHandler： 异常处理器，此注解的作用是当出现其定义的异常时进行处理的方法
 */

/**
 *  统一异常处理类
 * @author oKong
 *
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    /**
     * 拦截 CommonException 的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Result exceptionHandler(CommonException ex){
        log.info("CommonException：{}({})",ex.getMsg(), ex.getCode());
        return ResultUtil.error(ex.getCode(), ex.getMsg());
    }

    /**
     *  拦截Exception类的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception ex){
        log.info("Exception：{}({})",ex);
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return ResultUtil.error(500, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultUtil.error(1002, fieldError.getDefaultMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultUtil.error(1003, fieldError.getDefaultMessage());
    }
}