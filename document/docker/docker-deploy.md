# Docker environment deployment

## docker environment installation
### docker installation
1. Install yum-utils：
yum install -y yum-utils \
device-mapper-persistent-data \
lvm2
2. Add docker repository location for yum source：
yum-config-manager \
--add-repo \
https://download.docker.com/linux/centos/docker-ce.repo
3. Install docker:
yum install docker-ce
4. Start docker: systemctl start docker 
Note: For common commands, see docker.md in the document / reference folder
5. Install the upload download plug-in：
yum -y install lrzsz
### docker compose installation
1. download URL：https://github.com/docker/compose/releases
2. Installation address：/usr/local/bin/docker-compose
3. Set to executable：sudo chmod +x /usr/local/bin/docker-compose
4. Test if the installation was successful：docker-compose --version

## mysql installation
### download image file
docker pull mysql:5.7 
### Create instance and launch
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root  \
-d mysql:5.7
> Parameter Description
- -p 3306:3306：Map container's port 3306 to host's port 3306
- -v /mydata/mysql/conf:/etc/mysql：Bind the configuration folder to the host
- -v /mydata/mysql/log:/var/log/mysql：Mount the log folder to the host
- -v /mydata/mysql/data:/var/lib/mysql/：Mount the configuration folder to the host
- -e MYSQL_ROOT_PASSWORD=root：Initialize rootUser's password
### Connect through the container's mysql command line tool
docker exec -it mysql mysql -u root -p root
### Set up remote access
grant all privileges on *.* to 'root' @'%' identified by 'root';
flush privileges;
### Enter the container file system
docker exec -it mysql /bin/bash

## redis installation
### download image file
docker pull redis:3.2
### Create instance and launch
docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data -d redis:3.2 redis-server --appendonly yes
### Use redis image to execute redis-cli command connection
docker exec -it redis redis-cli

## nginx installation
### download image file
docker pull nginx:1.10
### Create instance and launch
docker run -p 80:80 --name nginx \
-v /mydata/nginx/html:/usr/share/nginx/html \
-v /mydata/nginx/logs:/var/log/nginx  \
-d nginx:1.10
### Modify nginx configuration
1. Copy the configuration file in the container to the current directory：docker container cp nginx:/etc/nginx .
2. Modify file name：mv nginx conf
3. Terminate container：docker stop nginx
4. Execute the command to delete the original container：docker rm $ContainerId
5. Execute the following command：
docker run -p 80:80 --name nginx \
-v /mydata/nginx/html:/usr/share/nginx/html \
-v /mydata/nginx/logs:/var/log/nginx  \
-v /mydata/nginx/conf:/etc/nginx \
-d nginx:1.10

## rabbitmq installation
### download image file
docker pull rabbitmq:management
### Create instance and launch
docker run -d --name rabbitmq --publish 5671:5671 \
 --publish 5672:5672 --publish 4369:4369 --publish 25672:25672 --publish 15671:15671 --publish 15672:15672 \
rabbitmq:management

## elasticsearch installation
### download image file
docker pull elasticsearch:6.4.0
### Create instance and run
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch \
-v /mydata/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
-v /mydata/elasticsearch/data:/usr/share/elasticsearch/data \
-d elasticsearch:6.4.0
### Test
    Access returns version information：http://192.168.1.66:9200/
### Installation directory location
/usr/share/elasticsearch
### Install the head plugin (may not be installed, only for testing)
1. Enter docker internal bash:docker exec -it elasticsearch /bin/bash
2. Install the plug-in, specific reference：https://github.com/mobz/elasticsearch-head
3. test：http://192.168.1.66:9200/_plugin/head/
### Install Chinese word breaker IKAnalyzer
1. Enter docker internal bash:docker exec -it elasticsearch /bin/bash
2. Install the Chinese word segmentation plugin and execute the following command：elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.2.2/elasticsearch-analysis-ik-6.2.2.zip
3. test：
    - Access header plugin：打开地址http://192.168.1.66:9200/_plugin/head/ 
    - Select compound query and enter address：POST:http://192.168.1.66:9200/_analyze 
    - Input parameter：JSON:{"analyzer":"ik","text":"We are big data developers"}

## mongodb installation
### download image file
docker pull mongo:3.2
### Create instance and run
docker run -p 27017:27017 --name mongo -v /mydata/mongo/db:/data/db -d mongo:3.2
### Enter the container using mongo command
docker exec -it mongo mongo

## SpringBoot application command deployment
**Docker containers must be connected to access each other**
### Deploy mall-admin
docker run -p 8080:8080 --name mall-admin \
--link mysql:db \
-v /etc/timezone:/etc/timezone \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/admin/logs:/var/logs \
-d mall/mall-admin:1.0-SNAPSHOT
### Deploy mall-search
docker run -p 8081:8081 --name mall-search \
--link elasticsearch:es \
--link mysql:db \
-v /etc/timezone:/etc/timezone \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/search/logs:/var/logs \
-d mall/mall-search:1.0-SNAPSHOT
### Deploy mall-port
docker run -p 8085:8085 --name mall-portal \
--link mysql:db \
--link redis:redis \
--link mongo:mongo \
-v /etc/timezone:/etc/timezone \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/portal/logs:/var/logs \
-d mall/mall-portal:1.0-SNAPSHOT

## SpringBoot application automation deployment
### Deployment file
document/docker/docker-compose.yml
### Deployment command
docker-compose up -d