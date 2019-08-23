package com.robinzhu.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 什么是JWT
 *   Json web token（JWT），是为了在网络应用环境间传递声明而执行的一种基于JSON的开放标准。定义了一种简洁的，自包含的方法用于通信双方之间以JSON对象的形式安全的传递信息。因为数字签名的存在，这些信息是可信的，JWT可以使用HMAC算法或者RSA的公钥秘钥对进行签名
 *
 * JWT请求流程
 *   1.POST /user/login with username and password
 *   2.Create a JWT with a secret
 *   3.Return the JWT to the Browser or device
 *   4.Sends the JWT on the Authorization Header
 *   5.Check JWT signature get user information from the JWT
 *   6.Sends response to the client
 *
 * JWT的主要应用场景
 *   身份认证在这种场景下，一旦用户完成了登录，在接下来的每个请求中包含JWT，可以用来验证用户身份以及对路由、服务和资源的访问权限进行验证。由于它的开销非常小，可以轻松的在不同域名的系统中传递，所有目前在单点登录（SSO)中比较广泛的使用该技术。信息交换在通信的双方之间使用JWT对数据进行编码是一种非常安全的方式，由于它的信息是经过签名的，可以确保发送者发送的信息是没有经过伪造的
 *
 * JWT的优点
 *   1.简洁（Compact）：可以通过URL，POST参数或者在HTTP header发送，因为数据量小，传输速度也很快
 *   2.自包含（Self-contained）：负载中包含了所有用户所需要的信息，避免了多次查询数据库
 *   3.因为Token是以JSON加密的形式保存在客户端的，所以JWT是跨语言的，原则上任何Web形式都支持
 *   4.不需要在服务端保存回话信息，特别适用于分布式微服务
 *
 * JWT的结构
 *   JWT是由三段信息构成的，将这三段信息文本用.连接一起就构成了JWT字符串。
 *   JWT包含了三部分：
 *      Header头部（标题包含了令牌的元数据，并且包含签名或加密算法的类型）
 *      Payload负载（类似于飞机上承载的物品）
 *      Signature签名/签证
 *
 *   Header
 *      JWT的头部承载两个部分信息：token类型和采用的加密算法。如：{ "alg": "HS256", "typ": "JWT" }，声明类型：这里是jwt；声明加密的算法：通常直接使用HMAC SHA256。
 *      加密算法是单向函数散列算法，常用的有MD5、SHA、HMAC。
 *          MD5(message-digest algorithm 5)（信息摘要算法）缩写，广泛用于加密和解密技术，常用于文件校验。不管文件多大，经过MD5加密后生成唯一的MD5值
 *          SHA（Secure Hash Algorithm, 安全散列算法），数字签名等密码学应用中重要的工具，安全性高于MD5
 *          HMAC（Hash Message Authentication Code），散列消息鉴别码，基于密钥的Hash算法的认证协议。用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。常用语接口签名验证
 *
 *   Payload
 *       载荷就是存放有效信息的地方
 *       有效信息包含三个部分：
 *       1.标准中注册的声明 2.公开的声明 3.私有的声明
 *       标准中注册的声明（建议但不强制使用）：
 *          iis：jwt签发者
 *          sub：面向的用户（jwt所面向的用户）
 *          aud：接收jwt的一方
 *          exp：过期时间戳（jwt的过期时间，这个过期时间必须大于签发时间）
 *          nbp：定义在什么时间之前，该jwt都是不可用的
 *          iat：jwt的签发时间
 *          jti：jwt的唯一身份标识，主要用来作为一次性token，从而回避重放攻击
 *       公共的声明
 *          公共的声明可以添加任何的信息，一般添加用户的相关信息或其他业务需要的必要信息。但不建议添加敏感信息，因为该部分在客户端可解密
 *       私有的声明
 *          私有声明是提供者和消费者所共同定义的声明，一般不建议存放敏感信息，因为base64是对称解密的，意味着该部分信息可以归类为明文信息
 *
 *   Signature
 *       jwt的第三部分是一个签证信息，这个签证信息由三部分组成：header(base64后的) payload(base64后的) secret
 *       这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加验secret组合加密，然后就构成了jwt的第三部分
 *       密钥secret是保存在服务端的，服务端会根据这个密钥进行生成token和进行验证，所以要保护好
 * 详情见：https://www.jianshu.com/p/e88d3f8151db
 */
@SpringBootApplication
public class TokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class, args);
    }

}
