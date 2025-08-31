package com.empresa.jirametrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration.class,
        org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration.class
})
public class JiraMetricsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JiraMetricsApplication.class, args);
    }
}
