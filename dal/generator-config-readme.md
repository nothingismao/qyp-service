based on: http://mybatis.github.io/generator/quickstart.html

+ 代码修改generatorConfig.xml，
+ classPathEntry location修改为本地m2地址
+ table schema 修改成对于要生成配置文件的表明，domainObjectName改成pojo名称
+ cmd命令进入dal目录下
+ 执行 mvn org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate 命令
+ 刷新dal工程，可看到pojo，mapper等文件的生成