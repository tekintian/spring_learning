package cn.tekin.spring.demo1;

import org.springframework.context.ApplicationListener;

/**
 * @Author Tekin
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}
