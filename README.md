# 项目简介

该项目简化swagger2在spring boot框架上的使用，直接在mian入口类中引入`@EnableCustomSwagger2`即可。
- 源码：https://github.com/chenkevin1986/springfox-swagger2

- 样例：https://github.com/chenkevin1986/springfox-swagger2/spring-boot-swagger2-example

  项目主要是在Spring Boot：1.5.9以及Springfox-Swagger2：2.7.0的基础上进行开发的。请注意兼容性,Springfox-Swagger2 在2.4.0以上均可以使用（因为从2.4.0增加了contact对象）。

# 使用方法
1.  引入依赖：

   在maven项目`pom.xml`中:

```xml
<dependency>
	<groupId>com.gizwits</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.7.0.RELEASE</version>
</dependency>
```
​       在gradle项目`build.gradle`中:
````groovy
compile "com.gizwits:springfox-swagger2:2.7.0.RELEASE"
````

2.  在应用主类中增加`@EnableCustomSwagger2`注解

```java
@EnableCustomSwagger2
@SpringBootApplication
public class SpringBootSwagger2ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwagger2ExampleApplication.class, args);
    }

}
```

# 配置文件
**配置文件推荐yaml格式，若是使用properties配置，会遇到中文乱码的问题。对啦，有时候顺序问题也会成为使用properties的一大烦恼。故推荐大家使用yaml文件，用着用着，用久啦，习惯啦就好啦！**

## 基础配置说明、示例

```yaml
swagger2:
  enabled: true  #默认true 可以不用显式配置
  title: spring-boot-swagger2-example
  description: Example for swagger2.7 
  version: 2.7.0.RELEASE
  license: Apache License, Version 2.0 #许可证
  licenseUrl: https://www.apache.org/licenses/LICENSE-2.0.html #许可证URL
  termsOfServiceUrl: https://github.com/chenkevin1986/springfox-swagger2 #服务条款URL
  contact:
    name: kevin chen #维护人
    url: http://kevin86.com
    email: chenkevin1986@126.com
  base-package: com.gizwits #swagger扫描的基础包，默认：全扫描
  base-path: /**   #需要处理的基础URL规则，默认：/**
  exclude-path: /error, /ops/**  #需要排除的URL规则，默认：空
  keyname: Authorization #权限验证使用，消息头前置名称

```

## 分组配置说明、示例

当我们一个项目的API非常多的时候，我们希望对API文档实现分组。
具体配置示例及其说明如下：

**分组配置示例**

```yaml
swagger2:
  group-docket:
    enterprise:
      title: enterprise-api
      description: Example for enterprise-api
      version: 2.7.0.RELEASE
      license: Apache License, Version 2.0 #许可证
      licenseUrl: https://www.apache.org/licenses/LICENSE-2.0.html #许可证URL
      termsOfServiceUrl: https://github.com/chenkevin1986/springfox-swagger2 #服务条款URL
      contact:
        name: kevin chen #维护人
        url: http://kevin86.com
        email: chenkevin1986@126.com
      base-package: com.gizwits #swagger扫描的基础包，默认：全扫描
      base-path: /**   #需要处理的基础URL规则，默认：/**
      exclude-path: /error, /ops/**  #需要排除的URL规则，默认：空
      keyname: Authorization #权限验证使用，消息头前置名称     
    open:
      title: open-api
      description: Example for open-api
      version: 2.7.0.RELEASE
      license: Apache License, Version 2.0 #许可证
      licenseUrl: https://www.apache.org/licenses/LICENSE-2.0.html #许可证URL
      termsOfServiceUrl: https://github.com/chenkevin1986/springfox-swagger2 #服务条款URL
      contact:
        name: kevin chen #维护人
        url: http://kevin86.com
        email: chenkevin1986@126.com
      base-package: com.gizwits #swagger扫描的基础包，默认：全扫描
      base-path: /**   #需要处理的基础URL规则，默认：/**
      exclude-path: /error, /ops/**  #需要排除的URL规则，默认：空
      keyname: Authorization #权限验证使用，消息头前置名称

```

说明：默认配置与分组配置可以一起使用。


