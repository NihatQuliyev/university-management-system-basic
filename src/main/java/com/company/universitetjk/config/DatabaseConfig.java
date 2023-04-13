package com.company.universitetjk.config;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConfig {

    @SneakyThrows
    public static  Connection connection(){
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/Universitet-mng";
        String username= "postgres";
        String password = "nihat5775";

        return DriverManager.getConnection(url,username,password);
    }
}
