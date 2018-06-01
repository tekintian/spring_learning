# Spring 框架学习Demo项目

## 工具
- IDEA  编辑器
高频使用快捷键
1. alt+insert 组合键
2. alt+enter 代码优化的建议
3. shift+F6 重命名你的类、方法、变量等等
4. alt+F7 找到你的函数或者变量或者类的所有引用到的地方
5. ctrl+n 查找类
6. 双击shift  在项目的所有目录查找，就是你想看到你不想看到的和你没想过你能看到的都给你找出来
7. ctrl+f 当前文件查找特定内容
8. ctrl+shift+f 当前项目查找包含特定内容的文件
9. ctrl+alt+L  自动格式化代码

- gradle  用来管理项目依赖的构建工具

## Spring IoC 容器
### Spring BeanFactory 容器
它是最简单的容器，给 DI 提供了基本的支持，它用 org.springframework.beans.factory.BeanFactory 接口来定义。BeanFactory 或者相关的接口，如 BeanFactoryAware，InitializingBean，DisposableBean，在 Spring 中仍然存在具有大量的与 Spring 整合的第三方框架的反向兼容性的目的。
- XmlBeanFactory() 在新版本的spring中已经被弃用 [查看解决方法](docs/XmlBeanFactory_deprecated.md)

### Spring ApplicationContext 容器
该容器添加了更多的企业特定的功能，例如从一个属性文件中解析文本信息的能力，发布应用程序事件给感兴趣的事件监听器的能力。该容器是由 org.springframework.context.ApplicationContext 接口定义。

ApplicationContext 容器包括 BeanFactory 容器的所有功能，所以通常建议超过 BeanFactory。BeanFactory 仍然可以用于轻量级的应用程序，如移动设备或基于 applet 的应用程序，其中它的数据量和速度是显著。

#### 常用 ApplicationContext 接口实现：

- FileSystemXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径。

- ClassPathXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。

- WebXmlApplicationContext：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。

## Spring Bean 定义

### bean定义的属性列表

属性  |	描述
--- | ---
class |		这个属性是强制性的，并且指定用来创建bean的bean类。
name |		这个属性指定唯一的bean标识符。在基于XML的配置元数据中，你可以使用ID和/或name属性来指定bean标识符。
scope |		这个属性指定由特定的bean定义创建的对象的作用域。
constructor-arg |		它是用来注入依赖关系的。
properties |		它是用来注入依赖关系的。
autowiring mode |		它是用来注入依赖关系的。
lazy-initialization mode |		延迟初始化的bean告诉IoC容器在它第一次被请求时，而不是在启动时去创建一个bean实例。
initialization method	 |	在bean的所有必需的属性被容器设置之后，调用回调方法。
destruction method	 |	当包含该bean的容器被销毁时，使用回调方法。

### Spring配置元数据

Spring IoC容器完全由实际编写的配置元数据的格式解耦。有下面三个重要的方法把配置元数据提供给Spring容器：

- 基于XML的配置文件

- 基于注解的配置

- 基于Java的配置

  以下为一个基于XML配置文件的例子，这个配置文件中有不同的bean定义，包括延迟初始化，初始化方法和销毁方法的：
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd">
  
    <!-- 一个简单的bean定义 -->
    <bean id = "..." class = "...">
        <!-- 在这里配置这个bean的协作者 -->
    </bean>

    <!-- 一个具有延迟初始化设置的bean定义 -->
    <bean id = "..." class = "..." lazy-init = "true">
        <!-- 在这里配置这个bean的协作者 -->
    </bean>

    <!-- 一个具有初始化方法的bean定义 -->
    <bean id = "..." class = "..." init-method = "...">
        <!-- 在这里配置这个bean的协作者 -->
    </bean>

    <!-- 一个具有销毁方法的bean定义 -->
    <bean id = "..." class = "..." destroy-method = "...">
        <!-- 在这里配置这个bean的协作者 -->
    </bean>

    <!-- 在这里定义更多的bean -->
  
</beans>
```

[演示](https://github.com/tekintian/spring_learning/tree/v0.1.0)

## Spring Bean 作用域
Bean 的作用域

当在 Spring 中定义一个 bean 时，你必须声明该 bean 的作用域的选项。例如，为了强制 Spring 在每次需要时都产生一个新的 bean 实例，你应该声明 bean 的作用域的属性为 prototype。同理，如果你想让 Spring 在每次需要时都返回同一个bean实例，你应该声明 bean 的作用域的属性为 singleton。
Spring 框架支持以下五个作用域:

作用域  | 	描述
--- | ---
singleton	 |  在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，默认值
prototype	 | 每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
request | 	每次HTTP请求都会创建一个新的Bean，该作用域仅适用于WebApplicationContext环境
session	 | 同一个HTTP Session共享一个Bean，不同Session使用不同的Bean，仅适用于WebApplicationContext环境
global-session	 | 一般用于Portlet应用环境，改作用于仅适用于WebApplicationContext环境


- singleton 作用域：

当一个bean的作用域为Singleton，那么Spring IoC容器中只会存在一个共享的bean实例，并且所有对bean的请求，只要id与该bean定义相匹配，则只会返回bean的同一实例。

Singleton是单例类型，就是在创建起容器时就同时自动创建了一个bean的对象，不管你是否使用，他都存在了，每次获取到的对象都是同一个对象。注意，Singleton作用域是Spring中的缺省作用域。你可以在 bean 的配置文件中设置作用域的属性为 

singleton，如下所示：

```xml
<!-- A bean definition with singleton scope -->
<bean id="..." class="..." scope="singleton">
    <!-- collaborators and configuration for this bean go here -->
</bean>
```

- prototype 作用域
  
    当一个bean的作用域为Prototype，表示一个bean定义对应多个对象实例。Prototype作用域的bean会导致在每次对该bean请求（将其注入到另一个bean中，或者以程序的方式调用容器的getBean()方法）时都会创建一个新的bean实例。

    Prototype是原型类型，它在我们创建容器的时候并没有实例化，而是当我们获取bean的时候才会去创建一个对象，而且我们每次获取到的对象都不是同一个对象。根据经验，对有状态的bean应该使用prototype作用域，而对无状态的bean则应该使用singleton作用域。
[演示](https://github.com/tekintian/spring_learning/tree/v0.1.1)

## Spring Bean 生命周期
理解 Spring bean 的生命周期很容易。当一个 bean 被实例化时，它可能需要执行一些初始化使它转换成可用状态。同样，当 bean 不再需要，并且从容器中移除时，可能需要做一些清除工作。
为了定义安装和拆卸一个 bean，我们只要声明带有 init-method 和/或 destroy-method 参数的 。init-method 属性指定一个方法，在实例化 bean 时，立即调用该方法。同样，destroy-method 指定一个方法，只有从容器中移除 bean 之后，才能调用该方法。

[演示](https://github.com/tekintian/spring_learning/tree/v0.1.2)

## Spring Bean 后置处理器

- BeanPostProcessor 接口定义回调方法，你可以实现该方法来提供自己的实例化逻辑，依赖解析逻辑等。你也可以在 Spring 容器通过插入一个或多个 BeanPostProcessor 的实现来完成实例化，配置和初始化一个bean之后实现一些自定义逻辑回调方法。
你可以配置多个 BeanPostProcesso r接口，通过设置 BeanPostProcessor 实现的 Ordered 接口提供的 order 属性来控制这些 BeanPostProcessor 接口的执行顺序。
- BeanPostProcessor 可以对 bean（或对象）实例进行操作，这意味着 Spring IoC 容器实例化一个 bean 实例，然后 BeanPostProcessor 接口进行它们的工作。
- ApplicationContext 会自动检测由 BeanPostProcessor 接口的实现定义的 bean，注册这些 bean 为后置处理器，然后通过在容器中创建 bean，在适当的时候调用它。


[Spring Bean 后置处理器示例代码](https://github.com/tekintian/spring_learning/tree/v0.1.3)



## Spring 基于构造函数的依赖注入
当容器调用带有一组参数的类构造函数时，基于构造函数的 DI 就完成了，其中每个参数代表一个对其他类的依赖。

[源码演示](https://github.com/tekintian/spring_learning/tree/v0.2.0)

---

## Spring JDBC CRUD 操作示例

```sql
CREATE TABLE `student` (
`id` INT ( 11 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR ( 255 ) DEFAULT NULL,
`age` INT ( 5 ) DEFAULT NULL,
PRIMARY KEY ( `id` ) 
) ENGINE = MyISAM AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
```

[JDBC CRUD 操作示例演示](https://github.com/tekintian/spring_learning/tree/v0.4.0)


## Spring 中 SQL 的存储过程
SimpleJdbcCall 类可以被用于调用一个包含 IN 和 OUT 参数的存储过程。你可以在处理任何一个 RDBMS 时使用这个方法，就像 Apache Derby， DB2， MySQL， Microsoft SQL Server， Oracle，和 Sybase。

```sql
DELIMITER$$
DROP PROCEDURE IF EXISTS `java_demo`.`getRecord` $$

CREATE PROCEDURE `java_demo`.`getRecord`(
IN in_id INTEGER,
OUT out_name VARCHAR(200),
OUT out_age INTEGER
)

BEGIN
	SELECT name,age
	INTO out_name, out_age
	FROM student WHERE id=in_id;
END $$

DELIMITER;
```

[Spring 中 SQL 的存储过程操作示例演示](https://github.com/tekintian/spring_learning/tree/v0.5.0)


## Spring 编程式事务管理
我们直接使用 PlatformTransactionManager 来实现编程式方法从而实现事务。

- queryForInt 在新版本中已经被弃用，

    String SQL2 = "select max(id) from Student";
    int sid = JdbcTemplate.queryForInt( SQL2 );

- 需要替换为 queryForObject，方法如下

    String SQL2 = "select max(id) from Student";
    JdbcTemplate.queryForObject(SQL2, Integer.class);


## Spring 声明式事务管理


## spring Web Mvc

### Spring MVC Hello World Demo
[Spring MVC Hello World Demo原码](https://github.com/tekintian/spring_learning/tree/v0.6.0)

## MySQL Connector/J 8.x 连接参数

MySQL Connector/J 8.0.11   JDBC Type 4 driver for MySQL

最新版的 className相对5.x 版本也有所改变

    5.x版本
    com.mysql.jdbc.Driver
    8.x版本改为
    com.mysql.cj.jdbc.Driver

```xml
jdbc:mysql://localhost:3306/java_demo?useSSL=false&amp;characterEncoding=utf-8&amp;
useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=Hongkong
```



