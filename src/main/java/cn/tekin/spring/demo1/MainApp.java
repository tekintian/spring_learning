package cn.tekin.spring.demo1;

/**
 * 演示
 * @author Tekin
 */
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CustomEventPublisher cep= (CustomEventPublisher) context.getBean("customEventPublisher");
        cep.publish();
        cep.publish();
    }
}