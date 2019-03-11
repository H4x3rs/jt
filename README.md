## 京淘电商项目
京淘电商网站项目


|序号|项目名称|主要业务|
|----|-------|--------|
|1| jt | 父项目，负责管理pom的版本依赖|
|2| jt-common| 公共类|
|3| jt-manager| 后台管理，商品的更新和维护|
|4| jt-web | 前台项目，商品的展现|
|5| jt-sso | 单点登录系统，实现session共享|
|6| jt-order| 订单系统|
|7| jt-card| 购物车系统|
|8| jt-search| 全文检索系统|


### 依赖关系

### 架构

前端采用vue进行开发，框架使用vue-template   
后端采用java进行开发，框架使用spring、spring-mvc  
基础服务层采用docker进行搭建

#### 网络架构

interface： docker-br0   
subnet：172.16.0.0  
mask： 255.255.255.0   
gateway： 172.16.0.1  


| 序号| 项目 | IP地址|端口映射|
|-----|-----|-------|----|
|0|mysql-master| 172.16.0.2|3306：3306|
|1|mysql-slave| 172.16.0.3|3307：3306|
|2|mycat-server| 172.16.0.4|8066：8066|
|3|jt-manager| 172.16.0.5|8000：8080|
|4|redis-master| 172.16.0.6|6379：6379|
|5|redis-salve1| 172.16.0.7|6380：6379|
|6|redis-salve2| 172.16.0.8|6391：6379|

### 技能点

### 启动
启动顺序


### 配置