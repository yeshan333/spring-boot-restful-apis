# 人体成分分析系统后端服务

> 开发环境依赖：JDK 8，MongoDB v4.2+，Git v2.0+，apache-maven v3.6+

## 快速开始

> 这里的实例数据库 MongoDB 使用 Docker 启动，Windows 请安装：[Docker-Desktop](https://www.docker.com/products/docker-desktop)

1、安装项目依赖

```bash
git clone https://github.com/yeshan333/spring-boot-restful-apis spring-boot-restful-apis
cd spring-boot-restful-apis
git checkout human-body-old
mvn install  # 安装依赖
```

2、Docker 启动 MongoDB

```bash
docker run --rm -d  -p 27017:27017/tcp mongo:latest
```

3、将数据导入到 MongoDB

<!-- 导出：mongodump -h 127.0.0.1 -o dbs，ref：https://www.jb51.net/article/52498.htm#_label1 -->

数据源位于 database 目录下

```bash
# eg：docker cp C:\Users\yeshan333\Desktop\HelloWorld\dbs\bodymanagement 11093e0e3f06:/home/dbs
docker cp  database\bodymanagement <Container-ID>:/home/dbs  # 将数据源移动到 MongoDB 容器内
docker exec -it <Container-ID>  # 进入 MongoDB docker 容器
mongorestore -d bodymanagement /home/dbs  # 还原数据库
```

4、启动应用

```bash
mvn spring-boot:run
```

## postman 接口测试

> 依赖：Postman：https://www.postman.com/，Postman Collection v2.1

将本项目中的 Web 接口调试的文件（Human-Body-Management.postman_collection.json）导入到 postman 即可使用开始调试