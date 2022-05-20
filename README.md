# 1、概念解释
为了方便理解，先做一些名词的解释。  
这里我用白话解释，更加通俗易懂，感兴趣的可以去官网看看解释。  
**IOC**：将原本在程序中手动创建对象的控制权，交由一个容器、框架来管理的解耦设计思想。
**AOP**:不同于oop，将代码进行横向的切入到原本的代码中，保持原有代码不变。  
**BeanFactory**：存放bean对象的工厂，可以理解为一个容器，一个map。  
**FactoryBean**：spring提出的，用于创建复杂bean的一种方式。  
**BeanDefinition**：bean的定义信息，用于存放创建bean之前bean的描述信息，如是否单例，是否懒加载等。  
**ApplicationContext**：可以理解为包含了spring组件的集合体，spring所有的组件的逻辑都会在这个应用上下文中处理（其中包含了BeanFactory、env等等对象）。  

上述bean可以理解为一个对象。

# 2、源码走起
需要的自己下下来，maven编译一下即可。  
预览：
[![Ob4c2q.png](https://s1.ax1x.com/2022/05/19/Ob4c2q.png)](https://imgtu.com/i/Ob4c2q)


懒的可以直接看图，图上的解释没源码仔细。  
流程图：  
[![Ob4XqO.png](https://s1.ax1x.com/2022/05/19/Ob4XqO.png)](https://imgtu.com/i/Ob4XqO)
源地址：https://www.processon.com/view/link/628613cfe401fd55ba341e20  
失效了可以联系我。


整理出以下boot相关核心类：
- SpringApplication
- AnnotationConfigServletWebServerApplicationContext
- ConfigFileApplicationListener

spring framwork 核心类：  
- AnnotatedBeanDefinitionReader
- AbstractApplicationContext
- ConfigurationClassPostProcessor
- AutowiredAnnotationBeanPostProcessor
- CommonAnnotationBeanPostProcessor
- AbstractAutoProxyCreator(aop相关)

