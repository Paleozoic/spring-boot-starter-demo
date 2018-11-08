# 写在前面
We can just use two spring boot starters to build easily a project with shiro RBAC configuration and multi-datasources(also multi-dialects) configuration.
What we should do is to implemente the interface `com.maxplus1.access.starter.config.shiro.rbac.service` and to edit the file `application.yml`.
But the starters is limited,they depend on `Druid`,`Shiro` and `MyBatis`.
- [spring-boot-starter-demo](https://github.com/Paleozoic/spring-boot-starter-demo)
- [mybatis-spring-boot-starter](https://github.com/Paleozoic/mybatis-spring-boot-starter)
- [shiro-spring-boot-starter](https://github.com/Paleozoic/shiro-spring-boot-starter)


# Spring Bean装载过程
## Spring装配Bean的过程
1. 实例化;
2. 设置属性值;
3. 如果实现了BeanNameAware接口,调用setBeanName设置Bean的ID或者Name;
4. 如果实现BeanFactoryAware接口,调用setBeanFactory 设置BeanFactory;
5. 如果实现ApplicationContextAware,调用setApplicationContext设置ApplicationContext
6. 调用BeanPostProcessor的预先初始化方法;
7. 调用InitializingBean的afterPropertiesSet()方法;
8. 调用定制init-method方法；
9. 调用BeanPostProcessor的后初始化方法;


## Spring容器关闭过程
1. 调用DisposableBean的destroy();
2. 调用定制的destroy-method方法;



[引用自](https://www.cnblogs.com/fanguangdexiaoyuer/p/5886050.html)

# BeanPostProcessor
- BeanPostProcessor包含了InitializingBean的前后拦截器

# Spring的监听器
https://www.cnblogs.com/senlinyang/p/8496099.html


# flyway
数据库迁移工具：flyway支持。flyway企业版才支持Oracle 11。
可以尝试回退到4.2.0版本。flayway的思路是最新版本免费支持最新的Oracle~
在使用oracle的时候，如果报莫名错误，尝试如下sql：
```sql
truncate table "schema_version";
commit;
```

# 整合问题
我调试的过程和此文类似，就是为了搞清楚`BeanPostProcessor`的调用顺序。
[详情点击](https://blog.csdn.net/m0_37962779/article/details/78605478)
于是我在内部类`DruidDataSourceConfiguration.DruidDataSourceBeanPostProcessor`中，让DruidDataSourceBeanPostProcessor实现了`PriorityOrdered`接口，
让数据源可以优先处理。
否则，在整合我的2个自定义starter，Shiro和MyBatis造成冲突。（复杂的依赖关系）
```xml
<dependency>
    <groupId>com.maxplus1</groupId>
    <artifactId>shiro-spring-boot-starter</artifactId>
    <version>1.0.4</version>
</dependency>
<dependency>
    <groupId>com.maxplus1</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.0.3</version>
</dependency>
```
报错如下：
```log
2018-11-07 16:38:50,128:INFO main (DefaultLazyPropertyFilter.java:31) - Property Filter custom Bean not found with name 'encryptablePropertyFilter'. Initializing Default Property Filter
2018-11-07 16:38:53,291:INFO main (PostProcessorRegistrationDelegate.java:328) - Bean 'org.springframework.boot.context.properties.ConversionServiceDeducer$Factory' of type [org.springframework.boot.context.properties.ConversionServiceDeducer$Factory] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-11-07 16:38:54,310:INFO main (DefaultLazyPropertyResolver.java:31) - Property Resolver custom Bean not found with name 'encryptablePropertyResolver'. Initializing Default Property Resolver
2018-11-07 16:38:54,400:INFO main (DefaultLazyPropertyDetector.java:30) - Property Detector custom Bean not found with name 'encryptablePropertyDetector'. Initializing Default Property Detector
2018-11-07 16:38:55,551:INFO main (PostProcessorRegistrationDelegate.java:328) - Bean 'spring.maxplus1.shiro-com.maxplus1.access.starter.config.shiro.ShiroProperties' of type [com.maxplus1.access.starter.config.shiro.ShiroProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-11-07 16:38:55,662:INFO main (PostProcessorRegistrationDelegate.java:328) - Bean 'com.maxplus1.access.starter.config.shiro.ShiroAutoConfiguration' of type [com.maxplus1.access.starter.config.shiro.ShiroAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-11-07 16:39:41,540:ERROR main (DruidDataSource.java:910) - {dataSource-1} init error
java.lang.NullPointerException: null
	at oracle.jdbc.driver.OracleDriver.connect(OracleDriver.java:420) ~[ojdbc6-11.2.0.4.jar:11.2.0.4.0]
	at com.alibaba.druid.pool.DruidAbstractDataSource.createPhysicalConnection(DruidAbstractDataSource.java:1558) ~[druid-1.1.10.jar:1.1.10]
	at com.alibaba.druid.pool.DruidAbstractDataSource.createPhysicalConnection(DruidAbstractDataSource.java:1623) ~[druid-1.1.10.jar:1.1.10]
	at com.alibaba.druid.pool.DruidDataSource.init(DruidDataSource.java:861) ~[druid-1.1.10.jar:1.1.10]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.8.0_131]
```
调试也可以发现，没有进入DruidDataSourceBeanPostProcessor，Spring的自动装配顺序有点让人意外。
其中到底是Shiro Starter的哪个依赖影响了DruidDataSourceBeanPostProcessor，我已无法理清……（头晕眼花的debug= =||，偷个懒，不调试了……）
