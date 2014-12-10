##开始我们的SSH整合。


###一、SSH： 

Struts（表示层）+Spring（业务层）+Hibernate（持久层） 

Struts： Struts是一个表示层框架，主要作用是界面展示，接收请求，分发请求。在MVC框架中，Struts属于VC层次，负责界面表现，负

责MVC关系的分发。（View：沿用

JSP，HTTP，Form，Tag，Resourse ；Controller：ActionServlet，struts-config.xml，Action）

Hibernate： Hibernate是一个持久层框架，它只负责与关系数据库的操作。 

Spring： Spring是一个业务层框架，是一个整合的框架，能够很好地黏合表示层与持久层。 

① Web分层架构中业务层为什么都选择Spring？Service层需要处理业务逻辑和交叉业务逻辑，处理事务，日志，安全等，而这些与Spring

的IoC，AOP等不谋而合。 

② Web分层架构中，对于各层技术的采用应该遵循一个怎样的标准？ 

1、选择发展成熟的技术： A、经过了项目实践证实可行性良好 B、文档完善 C、技术一直处于可持续发展更新 

2、Web应用中对于技术的选择有赖于开发人员的技术掌握情况。


###二、开始整合

#####开发环境：

  IDE：eclipse Luna，
  
  SSH：spring4.12+struts2.3.16+hibernate4.3.7
  
  JDK：1.8
  
  
#####整合方法：

1. 首先是在外面的eclipse里面新建一个maven项目，这里我们需要选择war包类型，因为是一个web应用。
2. 当然，第一步首先是把自己能确认的jar包都导入进我们的项目，这个查看项目的[pom.xml](resourse/pom.xml)。大致有三大框架的jar包和mysql,servlet,log4j。
3. 接下来是写我们的spring配置文件，也就是[applicationcontext.xml](resourse/applicationContext.xml),里面大概的功能就是把hibernate和spring整合到了一起，还有把spring的自动扫面javabean功能配置，使用了spring来管理事务。值得说明一下的是，配置文件中，讲JDBC连接池的配置写在了外面的配置文件[db.pro](resourse/db.properties)中，当然之前的项目还忘记了说我们的日志管理是使用的log4j,配置文件中还有log4j的配置文件[log4j.properties](resourse/log4j.properties)
4. 接下来就该配置我们的struts和系统的web.xml啦，[web.xml](resourse/web.xml),[struts.xml](resourse/struts.xml)，在web.xml中配置了字符的过滤，防止中文乱码，还有对spring，struts的支持，值得一说的是其中配置的openSessionInViewFilter方法，解决了延迟加载带来的问题，里面对spring的支持，将所有的路径与action都拦截下来存到了spring的容器中。struts.xml的功能是配置了后面action需要在里面配置，这里先不多说。
5. 到了这一步，我们就该研究我们项目的表结构，这个就不细说，直接上表[creTbl_mysql.sql](resourse/creTbl_mysql.sql)。注意里面的ID都设置为了自增长哦

#####开始项目：

1. 第一步，首先在项目中，建出我们的包结构，大概所有的J2EE项目的包结构都类似，我们开始建entity实体包，dao层数据访问层包，service业务层包，web业务包，util工具包。
2. 接下来是开始对着我们的文档分析我们需要建立的实体，代码在项目的code目录下面，[详细代码](/code/index.md)
3. 然后是需要我们写的JSP页面，根据业务流程来确定有多少张页面，每张又是什么，当然，一样的是直接出文件[webapp](webapp/index.md)需要多说的一点是，项目前台使用了bootstrap框架来使页面更加的好看。
4. 接下就是运行我们的项目，我们使用的tomcat8.0版本，加入服务器，然后访问我们的页面，来检验代码功能的实现。



###三、常见问题


因为每次遇到的问题都不同，每个人也都不同，但是SSH整合出现的问题又比较多，所以，我们在网上摘取了大牛们的[SSH问题汇总](http://wenku.baidu.com/link?url=eXlNx93iv1YyMpeulp2jxQWFpY8fup1_0gKGZR9P1JGRAoMizzu_f0kqL1I2-yuAZG-QKoa4LeeehSmNoDLh47LJUCo-u12tuMaEx8EiAIa)。来源百度文库