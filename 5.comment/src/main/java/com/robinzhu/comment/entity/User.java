package com.robinzhu.comment.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component // @Component最普通的组件，可以被注入到spring容器进行管理
/**
 * @Repository 作用于持久层
 * @Service 作用于业务逻辑层，和@Repository一样都是继承自@Component
 * 通常一些类无法确定是使用@Service还是@Component时，注释使用@Component，比如redis的配置类等
 *
 * @ModelAttribute 主要是绑定请求参数到指定对象上，此注释可被用于方法、参数上
 *      .运用在参数上，会将客户端传递过来的参数按照名称注入到指定对象上，并且会将这个对象自动加入ModelMap中，便于View层使用；
 *      .运用在方法上，会在每一个@RequestMapping标注的方法前执行，如果有返回值，则自动将该返回值加入到ModelMap中
 *
 * @Autowired 是根据类型进行自动装配的。如果当Spring上下文中存在不止一个UserDao类型的bean时，就会抛出BeanCreationException异常；如果Spring上下文不存在UserDao类型的bean，也会抛出BeanCreationException异常。我们可以使用@Qualifier配合@Autowired来解决这些问题
 *      1.可能存在多个UserDao实例，例如：
 *          @Autowired
 *          @Qualifier("userServiceImpl")
 *          public IUserService userService;
 *
 *          或者
 *          @Autowried
 *          public void setUserDao(@Qualifier("userDao") UserDao userDao) {
 *              this.userDao = userDao;
 *          }
 *        这样Spring会找到id为userServiceImpl和userDao的bean进行装配
 *
 *      2.可能不存在UserDao实例
 *          @Autowired(required = false)
 *          public IUserService userService;
 */
public class User {
    private String id;
    private String userName;
    private String password;

    public User() {}

    public User(String id, String userName, String password) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
