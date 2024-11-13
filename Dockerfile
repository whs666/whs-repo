# 使用 OpenJDK 21 基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 Jar 包到容器中
COPY target/WeChatScheduledPush-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露端口（如果您的应用程序需要）
EXPOSE 8080

# 启动应用程序
ENTRYPOINT ["java", "-jar", "/app/app.jar"]