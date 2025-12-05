package com.banking;



//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//public class BankingApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(BankingApplication.class, args);
//    }
//}


//
//
//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
//        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class
//})


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

@SpringBootApplication
@EnableJpaRepositories("com.banking.repository")
@EntityScan("com.banking.entity")
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkDbPath() {
        return args -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:h2:file:C:/Users/neeneera/Downloads/crud/Banking/data/banklib", "sa", "")) {
                DatabaseMetaData metaData = conn.getMetaData();
                System.out.println(" Connected to DB: " + metaData.getURL());
            } catch (Exception e) {
                System.err.println(" Failed to connect to DB");
                e.printStackTrace();
            }
        };
    }
}

