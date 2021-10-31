//package com.pluralsight.conferencedemo.configurations;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class PersistanceConfiguration
//{
//
//   @Bean
//   public DataSource dataSource()
//   {
//      DataSourceBuilder builder = DataSourceBuilder.create();
//      builder.url("jdbc:postgresql://localhost:5432/conference_app");
//      return builder.build();
//
//   }
//
//}
