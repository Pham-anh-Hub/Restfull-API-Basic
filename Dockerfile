## 1. Nền tảng nào? (FROM)
#  #→
#  #→ 2. Đứng ở đâu? (WORKDIR)
#  #→
#  #→ 3. Chép cái gì vào? (COPY)
#  #→
#  #→ 4. Mở cổng nào? (EXPOSE)
#  #→
#  #→ 5. Chạy bằng lệnh gì? (ENTRYPOINT)
FROM eclipse-temurin:17-jre-alpine
## Vì dự án sử dụng java 17
#
WORKDIR /app
## 1 câu lệnh sau dòng này sẽ thực hiện trong thư mục /app

COPY build/libs/*.jar app.jar
##Copy file .jar đã build (nếu dùng Maven thì ở thư mục target/, nếu Gradle thì ở build/libs/)
## và đổi tên thành app.jar cho ngắn gọn, dễ quản lý.
#
EXPOSE 8080
## Khai báo cổng ứng dụng lắng nghe
## Cổng mặc định của Spring Boot là 8080.
#
ENTRYPOINT ["java", "-jar", "app.jar"]
## Lệnh thực thi để khởi động Spring Boot



# sudo fallocate -l 2G /swapfile
  #sudo chmod 600 /swapfile
  #sudo mkswap /swapfile
  #sudo swapon /swapfile

#  Tat swap hien tai
# sudo swapoff /swapfile




# Các chỉ thị cơ bản trong Single-stage Dockerfile
 #Chỉ thị
 #
 #Ý nghĩa & Vai trò
 #
 #FROM
 #
 #Khai báo Base Image ban đầu (vd: amazoncorretto:17-alpine, ubuntu:24.04). Mọi Dockerfile đều phải bắt đầu bằng FROM.
 #
 #WORKDIR
 #
 #Thiết lập thư mục làm việc mặc định bên trong container cho các lệnh tiếp theo (COPY, RUN, CMD).
 #
 #COPY
 #
 #Sao chép tệp/thư mục cục bộ từ máy host vào bên trong image filesystem (vd: COPY build/libs/*.jar app.jar).
 #
 #ADD
 #
 #Giống COPY nhưng hỗ trợ thêm tính năng tự động giải nén tệp .tar.gz hoặc tải tệp từ URL (khuyên dùng COPY mặc định).
 #
 #RUN
 #
 #Thực thi lệnh trong quá trình build image để cài đặt packages, thư viện (vd: RUN ./gradlew dependencies).
 #
 #ENV
 #
 #Khai báo các biến môi trường và thông số cấu hình (vd: ENV JAVA_OPTS="-Xms256m -Xmx512m").
 #
 #EXPOSE
 #
 #Khai báo cổng (port) mạng mà container dự định lắng nghe (Spring Boot mặc định port 8080).
 #
 #CMD
 #
 #Lệnh mặc định được thực thi khi container khởi chạy (chỉ có 1 lệnh CMD cuối cùng có hiệu lực).