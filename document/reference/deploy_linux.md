# mall-swarm 在Linux环境下的部署

## 环境搭建

## 应用部署

##3 部署mall-registry

```bash
docker run -p 8001:8001 --name mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-registry/logs:/var/logs \
-d mall/mall-registry:1.0-SNAPSHOT
```

### 部署mall-config

```bash 
docker run -p 8301:8301 --name mall-config \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-config/logs:/var/logs \
-d mall/mall-config:1.0-SNAPSHOT
```

### 部署mall-monitor

```bash 
docker run -p 8101:8101 --name mall-monitor \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-monitor/logs:/var/logs \
-d mall/mall-monitor:1.0-SNAPSHOT
```

### 部署mall-gateway

```bash 
docker run -p 8201:8201 --name mall-gateway \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-gateway/logs:/var/logs \
-d mall/mall-gateway:1.0-SNAPSHOT
```

### 部署mall-admin

```bash 
docker run -p 8180:8180 --name mall-admin \
--link mysql:db \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-admin/logs:/var/logs \
-d mall/mall-admin:1.0-SNAPSHOT
```

### 部署mall-portal

```bash 
docker run -p 8085:8085 --name mall-portal \
--link mysql:db \
--link redis:redis \
--link mongo:mongo \
--link rabbitmq:rabbit \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-portal/logs:/var/logs \
-d mall/mall-portal:1.0-SNAPSHOT
```

### 部署mall-search

```bash 
docker run -p 8081:8081 --name mall-search \
--link mysql:db \
--link elasticsearch:es \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-search/logs:/var/logs \
-d mall/mall-search:1.0-SNAPSHOT
```

### 部署mall-demo

```bash 
docker run -p 8082:8082 --name mall-demo \
--link mysql:db \
--link mall-registry:mall-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-demo/logs:/var/logs \
-d mall/mall-demo:1.0-SNAPSHOT
```

## 注意

- 打包时如果遇到找不到`mall-common`、`mall-mbg`或`mall-security`的情况，需要先按顺序将这些模块install到本地maven仓库再进行打包；

- prod环境下从配置中心获取的是存储在git仓库中的配置，如需更改需要将mall-config模块的配置文件application.yml中的git仓库配置改为你自己的；

```yaml
spring:
  cloud:
    config:
      server:
        git: #Git仓库存储
          uri: https://gitee.com/macrozheng/mall-config.git #改为你自己的配置
          username: macro
          password: 123456
          clone-on-start: true
          search-paths: '{application}'
```