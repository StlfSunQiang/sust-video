# 微信小程序短视频发布平台  
## 研究背景及意义：  
随着互联网行业迅速发展，短视频也随之兴起，越来越多的人喜欢在工作之余使用快手、抖音等短视频app进行学习和娱乐。
而视频作为信息传播的介质，已经逐渐影响到人们的社交生活体验。如云豹网络科技开发的短视频，既有媒体属性，社交属性。
同时其长视频，相当于一个微电影的标准长度，如果与广告营销相嫁接的话，能够获得一定的营销效果，为此其逐渐吸引了企业营销的目光。
本次微信小程序短视频发布平台的开发可以实现视频资源的交互和共享，使每个学习者、爱好者都可以在本平台上传自己的视频资源，
每个用户可以在查看或删除自己的视频资源。为用户提供统一的视频资源发布、获取方式、背景音乐，增加视频资源的娱乐性和完整性。
## 研究现状与前景：
在刚刚过去的2019年春晚，一大批的短视频app活跃在春晚。快手赞助了浙江卫视，抖音更是在央视与全国观众进行了互动，
抖音在推出半年的时间就有了一亿的用户，每天的播放量更是高达十亿。
随着5G的来临，下载速度大幅度提升更是降低了短视频的门槛。小程序的发展是未来的一种趋势，它靠着微信的10亿用户，
同时还具有社交、变现交易的能力。在未来的发展中必然会占有一席之地。而截止2018年11月，小程序的数量已经达到120万。
这个数字还远远没有达到人们承受的上线。因此微信小程序短视频的发展前景一片光明。
## 功能简介：
微信小程序短视频发布平台分为基于微信小程序的客户端和基于web浏览器的后台管理两部分。
客户端的业务模块有：注册登录、更换头像、查看视频、搜索视频、选择背景音乐、上传视频、评论视频、点赞视频、举报视频、关注用户等模块；
后台管理的业务模块有：查看用户信息、对客户端的背景音乐进行添加和删除、对用户举报的视频进行查看和禁播等操作。
## 技术简介：

### 小程序api - 技术选型：

1、核心框架：Spring Framework 4.3.14.RELEASE

2、SpringBoot：1.5.10.RELEASE

3、持久层框架：MyBatis 3.4.5 + pagehelper 5.1.2

4、MySql 8.0.11

5、数据库连接池：阿里巴巴 Druid 1.1.0

6、zookeeper：3.4.11

7、spring-data-redis：1.8.7.RELEASE

8、swagger2：2.4.0

9、FFmpeg：2.0.1.1

### 短视频后台 - 技术选型：

1、核心框架：Spring Framework 4.3.8.RELEASE

2、持久层框架：MyBatis 3.2.8 + pagehelper 4.1.3

3、MySql 8.0.11

4、数据库连接池：阿里巴巴 Druid 1.1.0

5、jackson：2.7.4

6、slf4j：1.7.21

7、zookeeper：3.4.11

8、前端框架：Bootstrap + Jquery

9、前端分页组件：jqGrid

## 模块演示：

### 客户端演示：

### 注册登录模块
![注册登录](https://github.com/StlfSunQiang/Images/blob/master/image/注册登录.png)

### 个人主页模块
![个人主页](https://github.com/StlfSunQiang/Images/blob/master/image/个人主页.png)

### 视频首页模块
![视频首页](https://github.com/StlfSunQiang/Images/blob/master/image/视频首页.png)

### 视频详情模块
![视频详情](https://github.com/StlfSunQiang/Images/blob/master/image/视频详情.png)

### 选择背景音乐模块
![选择背景音乐](https://github.com/StlfSunQiang/Images/blob/master/image/选择背景音乐.png)

### 举报视频模块
![举报视频](https://github.com/StlfSunQiang/Images/blob/master/image/举报视频.png)

### 后台管理演示：

### 用户管理模块
![用户管理](https://github.com/StlfSunQiang/Images/blob/master/image/用户管理.png)

### 背景音乐管理
![背景音乐管理](https://github.com/StlfSunQiang/Images/blob/master/image/背景音乐管理.png)

### 举报管理
![举报管理](https://github.com/StlfSunQiang/Images/blob/master/image/举报管理.png)



