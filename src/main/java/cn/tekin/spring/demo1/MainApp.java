package cn.tekin.spring.demo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示
 * @author Tekin
 */
public class MainApp {
    public static void main(String[] args) {
        //ApplicationContext 方式
        // ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");

       ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");

       TextEditor te= (TextEditor) context.getBean("textEditor");
      te.spellCheck();

       /* 注册一个在 AbstractApplicationContext 类中声明的关闭 hook 的 registerShutdownHook() 方法。它将确保正常关闭，并且调用相关的 destroy 方法。 */


    }
}
