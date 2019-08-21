package com.robinzhu.send_mail;

import com.robinzhu.send_mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.UUID;

/**
 * Create by zhudapeng
 * 2019-08-21 22:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMailTest() { // 发送普通文本邮件
        mailService.sendSimpleMail("zhudapeng1985@126.com", "这是第一封Spring boot邮件", "这是我的第一封Spring boot mail邮件");
    }

    @Test
    public void sendHTMLMailTest() throws MessagingException { // 发送HTML邮件
        String content = "<div class=\"m-article\">\n" +
                "\t\t\t\t<h2 id=\"article_title\">\n" +
                "广州南沙审议通过干部任命，谢明任副区长</h2>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<h3 id=\"article_subtitle\">\n" +
                "\t\t\t\t  \n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<div class=\"m-abstract\" style=\"display: none\" id=\"abstract\"></div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<div class=\"meta\">\n" +
                "\t\t            <div class=\"fl\">\n" +
                "\t                <span class=\"pub_time\" id=\"pubtime_baidu\">2019-07-06 08:00</span>\n" +
                "                    <span id=\"source_baidu\">来源：南方网</span>\n" +
                "<span id=\"author_baidu\"></span>\n" +
                "\t              </div>\n" +
                "\t\t            <div class=\"font_change fr\">\n" +
                "\t\t                <a class=\"font_down js-font font_down_disable\" data-action=\"fontDown\" href=\"#\">字号减小</a>\n" +
                "\t\t                <a class=\"font_up js-font\" data-action=\"fontUp\" href=\"#\">字号增大</a>\n" +
                "\t\t            </div>\n" +
                "\t\t        </div>\n" +
                "\t\t    \n" +
                "\t\t\t <div class=\"content\" id=\"content\">\n" +
                "\t\t          <!--enpproperty <articleid>188221793</articleid><date>2019-07-06 08:00:24.0</date><author></author><title>广州南沙审议通过干部任命，谢明任副区长</title><keyword></keyword><subtitle></subtitle><introtitle></introtitle><siteid>4</siteid><nodeid>287452</nodeid><nodename>广州新闻</nodename><nodesearchname></nodesearchname><picurl></picurl>/enpproperty--><!--enpcontent--><!--enpcontent--><p>　　7月2日，南沙区三届人大第36次常委会议举行。本次会议书面传达学习省人大常委有关文件精神，审议区政府有关工作人员职务任免的议案及常委会委员职务变动有关事项。南沙区人大常委会主任张谭均，副主任吴小慧、胡抗利、孙宝忠、苏士路、王军等参加会议。副区长阮晓红代表区政府在会上做提请干部任免的报告。</p>\n" +
                "\n" +
                "<p>　　会议审议通过任命谢明为区人民政府副区长的职务任命报告。会议审议通过任命欧阳刘兵为区政府办公室主任的职务任命报告，同意免去江效民的区政府办公室主任职务。会议接受高飞辞去广州市南沙区第三届人大常委会委员职务。会议结束后，谢明、欧阳刘兵向宪法宣誓，正式就职。</p>\n" +
                "\n" +
                "<p>　　【记者】柳时强</p>\n" +
                "\n" +
                "<p>　　【通讯员】罗瑞娴</p>\n" +
                "\n" +
                "<p>　　【校对】梁飞飞</p>\n" +
                "<!--/enpcontent--><!--/enpcontent-->\n" +
                "\t\t        </div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<div class=\"m-editor\">编辑：\n" +
                "\t\t\t\t  林双英\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t<div class=\"m-pager\"></div>\n" +
                "\t\t\t</div>";
        mailService.sendHTMLMail("zhudapeng1985@126.com", "这是一封HTML邮件", content);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException { // 发送携带附件的邮件
        String filePath = "/Users/zhudapeng/Documents/spring.sql";
        mailService.sendAttachmentsMail("zhudapeng1985@126.com", "这是一封带附件的邮件", "这是一封带有附件（sql脚本）的邮件", filePath);
    }

    @Test
    public void sendInlineResourceMail() throws MessagingException { // 发送携带图片的邮件
        String imgPath = "/Users/zhudapeng/Documents/uploadATT00002.jpg";
        String rscId = "robin.zhu";
        String content = "<img src=\'cid:" + rscId+ "\'/>";
        mailService.sendInlineResourceMail("zhudapeng1985@126.com", "这是一个图片文件", content, imgPath, rscId);
    }

    @Test
    public void templateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id", UUID.randomUUID());
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHTMLMail("zhudapeng1985@126.com", "模板邮件", emailContent);
    }
}
