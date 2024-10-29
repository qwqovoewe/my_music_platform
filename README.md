## 项目备注

24.09.15结束，沸点预备成员转正项目，前后端分离，springboot+vue

github地址：[qwqovoewe/my_music_platform: build (github.com)](https://github.com/qwqovoewe/my_music_platform)

歌曲和mv在数据库里存的是服务器的存储url

腾讯云服务器，过期了



用到的：

把静态资源放到static中

密码加密用cn.tool中的BCrypt.hashpw()

用MybatisX插件生成mapper映射文件

部署拦截器

分页查询

进行aop增强（@InvokeLog）

用token获取UserId（@CurrentUserId）

异常统一处理：@ContollerAdvice	

指标监控接口：/actucator

图形化指标监控：同时打开两个controller，然后localhost8888

完善数据库时：

用网易云api下载资源和歌词json文件

将数据部署到服务器，数据库存url



查看歌词 https://music.163.com/api/song/media?id= 

查看歌曲(https://music.163.com/api/song/enhance/player/url?id=1469041281&ids=[1469041281]&br=3200000)

未实现：

模板引擎相关-Thymeleaf:可实现动态渲染

密码加密:用cn.hoot,SCrypt.Hashpw()

会报错，和前面配置冲突，时间赶就没弄

可使用整合redis实现项目性能提升

### 8.2 常用端点

| 端点名称         | 描述                                      |
| :--------------- | :---------------------------------------- |
| `beans`          | 显示应用程序中所有Spring Bean的完整列表。 |
| `health`         | 显示应用程序运行状况信息。                |
| `info`           | 显示应用程序信息。                        |
| `loggers`        | 显示和修改应用程序中日志的配置。          |
| `metrics`        | 显示当前应用程序的“指标”信息。            |
| `mappings`       | 显示所有`@RequestMapping`路径列表。       |
| `scheduledtasks` | 显示应用程序中的计划任务。                |
