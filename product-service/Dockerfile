# 使用官方的 OpenJDK 镜像作为基础镜像
FROM openjdk:17-jdk-alpine
# 复制项目的 jar 文件到容器中
COPY target/product-service.jar /app/product-service.jar
# 暴露容器的端口
EXPOSE 8081
# 运行 jar 文件
ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]
