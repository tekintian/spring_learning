# XmlBeanFactory Deprecated 解决方法

##不推荐的用法 Deprecated
```java
Resource resource = new ClassPathResource("applicationContext.xml");            //装载配置文件  
BeanFactory factory = new XmlBeanFactory(resource);  

```

## 替换XmlBeanFactory的代码为：
```java
BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");  
```

