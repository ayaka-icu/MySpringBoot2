package com.ganga.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class AnnexMail {

    @Autowired
    private JavaMailSender javaMailSender;

    //测试数据
    private String from = "xxxxx@qq.com"+"(小可爱)"; //发件人
    private String to = "xxxxx@qq.com"; //收件人
    private String subject = "文件标题^_^subject"; //文件标题
    private String text = "发送文件正文 -- 测试"; //文件正文
    //支持html格式的解析
    private String html0 = "<br> <h3> SpringBoot整合SpringMail 测试内容 </h3><br>";
    private String html1 = "<a href=\"https://gitee.com/embarrassing-sauce/my-code/raw/master/img/Ximg/imgs.jpg\">这就尴尬了呢 [超链接]</a> <br>";
    private String html2 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/REfJuE.jpg\"/> <br>";
    private String html3 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/93tUB4.jpg\"/> <br>";
    private String html4 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/y6uQ59.jpg\"/> <br>";
    private String html5 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/kqE3pF.jpg\"/> <br>";
    private String html6 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/7Q46sj.jpg\"/> <br>";
    private String html7 = "<img src=\"https://www.17imoe.com/wp-content/uploads/2021/04/fGZX14.jpg\"/> <br>";
    private String html8 = "<a href=\"https://www.17imoe.com/98115.html\">点开有福利哦,[尴尬 胡桃坏笑]</a> <br><br><br>";
    //还支持附件文件
    private File file1 = new File("D:\\桌面文件\\弥豆子.png");
    private File file2 = new File("D:\\桌面文件\\壁纸\\手机动漫壁纸.zip");
    private File file3 = new File("D:\\桌面文件\\源码.png");

    /**
     * 发送文件 并测试
     */
    public void sendMail(){

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setFrom(this.from);
            helper.setTo(this.to);
            helper.setSubject(this.subject);
            helper.setText(this.text + this.html0 + this.html1 +this.html2 +this.html3 +this.html4 +this.html5 +this.html6 +this.html7 +this.html8,
                          true);//看源码 重载一个 true 识别html
            //发送附件
            helper.addAttachment("可爱的弥豆子.png",file1);//第一参数是文件名 要带是后缀啊！
            helper.addAttachment(file2.getName(),file2);//直接获取源文件名 自带后缀
            helper.addAttachment(file3.getName(),file3);

            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
