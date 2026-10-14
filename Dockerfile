## 1. Nền tảng nào? (FROM)
#  #→
#  #→ 2. Đứng ở đâu? (WORKDIR)
#  #→
#  #→ 3. Chép cái gì vào? (COPY)
#  #→
#  #→ 4. Mở cổng nào? (EXPOSE)
#  #→
#  #→ 5. Chạy bằng lệnh gì? (ENTRYPOINT)
#FROM eclipse-temurin:17-jre-alpine
## Vì dự án sử dụng java 17
#
#WORKDIR /app
## 1 câu lệnh sau dòng này sẽ thực hiện trong thư mục /app
#
#COPY build/libs/*.jar app.jar
##Copy file .jar đã build (nếu dùng Maven thì ở thư mục target/, nếu Gradle thì ở build/libs/)
## và đổi tên thành app.jar cho ngắn gọn, dễ quản lý.
#
#EXPOSE 8080
## Khai báo cổng ứng dụng lắng nghe
## Cổng mặc định của Spring Boot là 8080.
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
## Lệnh thực thi để khởi động Spring Boot

FROM gradle:8-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar -x test --no-daemon
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
