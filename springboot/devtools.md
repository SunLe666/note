添加DevTools依赖jar
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<!--optional=true 依赖不会传递，该项目依赖devtools
	之后依赖该项目的项目如果想要使用devtools，需要重新导入-->
	<optional>true</optional>
</dependency>

手动指定排除热部署的文件
spring:
  devtools:
    restart:
    #热部署生效
    enabled: true
    #设置重启的目录
    additional-paths: resources/**,static/**,templates/**
    #该目录下的内容修改不重启
    exclude: data/**
