
# Spring Boot 启动项目

包含以下内容
- 完整的Maven配置，包括打包，依赖拷贝等
- 多环境的配置文件
- logback配置


# IDEA配置:
- 开发时运行程序：可直接运行main方法
- 开发时运行程序：使用spring boot maven 插件运行，增加一个Maven配置，在Command Line中填入spring-boot:run，在在Profiles指定配置文件dev
- 配置打包Configuration：增加一个Maven配置，在Command Line中填入clean package，在Profiles指定需要打包的配置文件，如prod
