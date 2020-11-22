## 感受 SpringBoot restful apis

- SpringBoot 2.4
- Java 11
- Docker MySQL

1、MySQL 数据源配置，Docker MySQL

```yml
# application.yml
spring:
  datasource:
    url: "jdbc:mysql://localhost:3306/yeshan"
    username: "root"
    password: "my-secret-pw"
    driver-class-name: "com.mysql.cj.jdbc.Driver"
```

创建 DB

```shell
# 启动 MySQL 容器
docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
# 创建 dababases
docker exec -it some-mysql bash
mysql -uroot -pmy-secret-pw

mysql> create database yeshan;
```

建表 SQL

```sql
CREATE TABLE `Person` (
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
```

2、安装依赖，启动应用

```
mvn install
mvn spring-boot:run
```

## 参考

- SpringBoot 教程
  - http://blog.didispace.com/spring-boot-learning-21-3-1/
- SpringBoot 项目工程结构推荐（EN，kuayue GFW）
  - https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
- SpringBoot 配置文件使用
  - https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-sql
  - https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
- SpringBoot 常用注解
  https://cloud.tencent.com/developer/article/1534616