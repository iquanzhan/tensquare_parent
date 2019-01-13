# tensquare_parent
基于SpringBoot+SpringCloud+SpringMVC+SpringData的Java系统

## 创建父项目

#### 配置pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.chengxiaoxiao</groupId>
    <artifactId>tensquare_parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <name>tensquare_parent</name>
    <description>十次方项目</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
        <relativePath/>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <repositories>
        <repository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </pluginRepository>
        <pluginRepository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>
    
</project>
```

### Redis依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

application.yml:

```
  redis:
    host: 192.168.217.130
```

### mongDB驱动

```
<dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver</artifactId>
        <version>3.6.3</version>
    </dependency>
</dependencies>
```

### SpringDataMongoDB

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
application.yml:

```
  data:
    mongodb:
      host: 192.168.217.130
      database: spitdb
```

### elasticsearch

```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-elasticsearch</artifactId>
</dependency>
```

application.yml

```
  data:
    elasticsearch:
      cluster-nodes: 192.168.217.130:9300
```

### 配置elastsearch可以跨域访问

```
http.cors.enabled: true
http.cors.allow-origin: "*"
```

### logstash配置mysql同步

```
input {
  jdbc {
	  # mysql jdbc connection string to our backup databse
	  jdbc_connection_string => "jdbc:mysql://192.168.217.130:3306/tensquare_article?characterEncoding=UTF8"
	  # the user we wish to excute our statement as
	  jdbc_user => "root"
	  jdbc_password => "123456"
	  # the path to our downloaded jdbc driver  
	  jdbc_driver_library => "C:\java\logstash-5.6.8\mysqletc\mysql-connector-java-5.1.46.jar"
	  # the name of the driver class for mysql
	  jdbc_driver_class => "com.mysql.jdbc.Driver"
	  jdbc_paging_enabled => "true"
	  jdbc_page_size => "50000"
	  #以下对应着要执行的sql的绝对路径。
	  #statement_filepath => ""
	  statement => "select id,title,content from tb_article"
	  #定时字段 各字段含义（由左至右）分、时、天、月、年，全部为*默认含义为每分钟都更新（测试结果，不同的话请留言指出）
      schedule => "* * * * *"
  }
}

output {
  elasticsearch {
	  #ESIP地址与端口
	  hosts => "localhost:9200" 
	  #ES索引名称（自己定义的）
	  index => "tensquare"
	  #自增ID编号
	  document_id => "%{id}"
	  document_type => "articel"
  }
  stdout {
      #以JSON格式输出
      codec => json_lines
  }
}

```



### JPA参数表示

```
@Modifying
@Query(value = "update tb_article set state='1' where id=?1", nativeQuery = true)
public void updateState(String id);
```

?1表示方法中参数的对应位置

### RabbitMQ搭建

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
            <scope>test</scope>
        </dependency>
```

application.yml

```
spring:
  rabbitmq:
    host: 192.168.217.130
```

### 使用commons-lang

```
        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang</artifactId>
            <version>2.5</version>
            <scope>compile</scope>
        </dependency>
```

### 使用BCrypt加密

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```

并在Application中增加Bean

```
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
```

配置Spring Security可以匿名访问所有路径

```
/**
 * @author Cheng Xiaoxiao
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests().
                antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
```

### 使用JJWT

```
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.6.0</version>
        </dependency>
```



# Docker环境搭建

#### 1.创建mysql

下载镜像：

```
docker pull centos/mysql‐57‐centos7
```

创建容器：

```
docker run ‐di ‐‐name=tensquare_mysql ‐p 3306:3306 ‐e MYSQL_ROOT_PASSWORD=123456 centos/mysql‐57‐centos7
```

#### 2.创建redis

创建容器

```
docker run -di --name=tensquare_redis -p 6379:6379 redis
```

#### 3.创建mongodb

```
docker run -di --name=tensquare_mongo -p 27017:27017 mongo
```

#### 4.创建elasticSearch

```
docker run -di --name=tensquare_elasticsearch -p 9200:9200 -p 9300:9300 elasticsearch:5.6.8
```

#### 5.IK分词器安装

* ik文件上传至宿主机
* 在宿主机中将ik文件夹拷贝到容器内 /usr/share/elasticsearch/plugins 目录下
* docker cp ik tensquare_elasticsearch:/usr/share/elasticsearch/plugins/

#### 6.HEAD插件安装

* 修改/usr/share/elasticsearch.yml，允许跨域

* ```
  http.cors.enabled: true
  http.cors.allow-origin: "*"
  
  //重新启动docker以生效
  ```

* 创建head容器

* docker run -di --name=my_head -p 9100:9100 mobz/elasticsearch-head:5

wordcount可以实现热词统计

#### 7.RabbitMQ安装

```
docker run -di --name=tensquare_rabbitmq -p 5671:5671 -p 5672:5672 -p 4369:4369 -p 15671:15671 -p 15672:15672 -p 25672:25672 rabbitmq:management
```



## 挂载docker配置文件到宿主机

1.进入docker所在目录

```
docker exec -it tensquare_elasticsearch /bin/bash
```

2.拷贝文件至宿主机

```
docker cp tensquare_elasticsearch:/usr/share/elasticsearch/config/elasticsearch.yml /usr/share/elasticsearch.yml
```

3.停止和删除原来的容器

```
docker stop tensquare_elasticsearch
docker rm tensquare_elasticsearch
```

4.重新创建容器命令

```
docker run -di --name=tensquare_elasticsearch -p 9200:9200 -p 9300:9300 -v /usr/share/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml elasticsearch:5.6.8
```

5.修改都能访问

```
vi /usr/share/elasticsearch.yml
删除transport.host: 0.0.0.0前#

```



此时启动容器会出现错误，比如最多打开的文件的个数以及虚拟内存区域数量等等，如果你放开了此配置，意味着需要打开更多的文件以及虚拟内存，所以我们还需要系统调优。

1.修改/etc/security/limits.conf，添加如下内容

 ```
  * soft nofile 65536
  * hard nofile 65536
 ```

​	nofile是单个进程允许打开的最大文件个数 

2.修改/etc/sysctl.conf，追加内容

```
vm.max_map_count=655360
```

​	限制一个进程可以拥有的VMA(虚拟内存区域)的数量

3.执行下面命令 修改内核参数马上生效

```
sysctl -p
```


​	重新启动虚拟机，再次启动容器，发现已经可以启动并远程访问