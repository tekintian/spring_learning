package cn.tekin.spring.demo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示
 * @author Tekin
 */
public class MainApp {
    public static void main(String[] args) {
        //ApplicationContext 方式
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld helloWorld= (HelloWorld) applicationContext.getBean("helloWorld");

       //BeanFactory
//        BeanFactory beanFactory=new ClassPathXmlApplicationContext("Beans.xml");
//        HelloWorld helloWorld=(HelloWorld) beanFactory.getBean("helloWorld");

       helloWorld.setMessage("Hi, I am Tekin");
       helloWorld.getMessage();

       ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

    }
}
