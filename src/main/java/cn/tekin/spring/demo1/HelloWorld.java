package cn.tekin.spring.demo1;

/**
 * Hello world
 * @author Tekin
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}