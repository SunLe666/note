###安装Docker环境
	yum install docker
	
###设置开机启动
	ervice docker start
	chkconfig docker on

	#此处采用了旧式的 sysv 语法，如采用CentOS 7中支持的新式 systemd 语法，如下：
	systemctl  start docker.service
	systemctl  enable docker.service
	
###使用Docker中国加速器
	vi  /etc/docker/daemon.json
	#添加后：
	{
		"registry-mirrors": ["https://registry.docker-cn.com"],
		"live-restore": true
	}

###重启Docker
	systemctl restart docker
	输入docker version 返回版本信息则安装正常。

###安装JDK
	yum -y install java-1.8.0-openjdk*
	配置环境变量 打开 vim /etc/profile 添加一下内容

	export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.el7_4.x86_64 
	export PATH=$PATH:$JAVA_HOME/bin 
	修改完成之后，使其生效

	source /etc/profile
	输入java -version 返回版本信息则安装正常。

###安装MAVEN
	下载：weget http://mirrors.shu.edu.cn/apache/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz

	## 解压
	tar vxf apache-maven-3.5.2-bin.tar.gz

	修改环境变量， 在/etc/profile中添加以下几行
	MAVEN_HOME=/usr/local/maven
	export MAVEN_HOME
	export PATH=${PATH}:${MAVEN_HOME}/bin
	记得执行source /etc/profile使环境变量生效。

	输入mvn -version 返回版本信息则安装正常。


###使用 Docker 部署 Spring Boot 项目
	将项目 spring-boot-docker 拷贝服务器中，进入项目路径下进行打包测试。
	#打包
	mvn package
	#启动
	java -jar target/spring-boot-docker-1.0.jar
	看到 Spring Boot 的启动日志后表明环境配置没有问题，接下来我们使用 DockerFile 构建镜像。

	mvn package docker:build

	使用docker images命令查看构建好的镜像：
	docker images
	REPOSITORY                      TAG                 IMAGE ID            CREATED             SIZE
	springboot/spring-boot-docker   latest              99ce9468da74        6 seconds ago       117.5 MB
	springboot/spring-boot-docker 就是我们构建好的镜像，下一步就是运行该镜像

	docker run -p 8080:8080 -t springboot/spring-boot-docker
	启动完成之后我们使用docker ps查看正在运行的镜像：

	docker ps
	CONTAINER ID        IMAGE                           COMMAND                  CREATED             STATUS              PORTS                    NAMES
	063570da86a9        springboot/springboot-docker   "java -Djava.security"   30 seconds ago      Up 27 seconds       0.0.0.0:8080->8080/tcp   determined_mahavira
	可以看到我们构建的容器正在在运行，访问浏览器：http://192.168.65.**:8080/,返回
	
	Hello Docker!
	说明使用 Docker 部署 Spring Boot 项目成功！



