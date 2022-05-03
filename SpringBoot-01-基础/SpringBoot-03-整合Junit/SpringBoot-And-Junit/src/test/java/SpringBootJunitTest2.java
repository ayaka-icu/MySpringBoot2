import com.ganga.SpringBootAndJunitApplication;
import com.ganga.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * SpringBoot~整合Junit
 *
 * 如果目录不是和 SpringBoot引导类所在包及子包下 不设置 classes属性
 *      就会找不到 引导配置类
 *      java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
 *
 * 解决方法:
 *      1. 在@SpringBootTest() 添加属性 classes = SpringBootAndJunitApplication.class
 *      2. 添加注解并指定配置了 @ContextConfiguration(classes = SpringBootAndJunitApplication.class)
 *
 *      以后都用方法1.
 *
 */
//第一步: 注解@SpringBootTest 指定classes配置引导类
@SpringBootTest(classes = SpringBootAndJunitApplication.class)
//@ContextConfiguration(classes = SpringBootAndJunitApplication.class)
class SpringBootJunitTest2 {

    //第二步: 注入需要测试的类对象
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        userDao.save();
    }

}
