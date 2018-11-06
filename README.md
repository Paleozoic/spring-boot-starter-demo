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