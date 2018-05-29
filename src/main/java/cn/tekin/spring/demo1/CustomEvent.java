package cn.tekin.spring.demo1;

import org.springframework.context.ApplicationEvent;
/**
 * @author Tekin
 */
public class CustomEvent extends ApplicationEvent{
    public CustomEvent(Object source) {
        super(source);
    }
    @Override
    public String toString(){
        return "My Custom Event";
    }
}