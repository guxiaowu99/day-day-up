package io.study.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"io.study"})
@MapperScan({"io.study.core.mapper"})
@EnableScheduling
@EnableSwagger2
public class StudyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyAppApplication.class, args);
    }

}
