package ru.santurov.accountingcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class AccountingCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountingCrudApplication.class, args);
    }

}
