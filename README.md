# docker_maven_springboot_jpa_flyway
docker+메이븐+스프링부트+jpa+flyway+swagger+SpringDoc조합으로 간단한 프로토타입 RestAPI작성

### 도커 컨테이너 기동
```git
docker-compose up -d
```

### DB name / Port
- dbname : springjpadb
- port : 3309

### 터미널에서 Maven flyway마이그레이션
```git
mvn clean flyway:clean
or
mvn clean flyway:migrate
or
mvn clean flyway:info
```

### Swagger API 확인
> 브라우저에서 
```git
http://localhost:8080/swagger-ui/index.html#/
```

### OpenAPI 확인
```git
http://localhost:8080/v3/api-docs
```
