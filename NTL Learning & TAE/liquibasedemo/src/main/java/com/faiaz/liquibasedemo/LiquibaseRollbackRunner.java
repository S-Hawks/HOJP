//package com.faiaz.liquibasedemo;
//
//import liquibase.Liquibase;
//import liquibase.database.Database;
//import liquibase.database.DatabaseFactory;
//import liquibase.database.jvm.JdbcConnection;
//import liquibase.exception.LiquibaseException;
//import liquibase.resource.ClassLoaderResourceAccessor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//@Component
//public class LiquibaseRollbackRunner implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/liquibasedb", "postgress","f1234F")){
//            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
//            Liquibase liquibase = new Liquibase("db/chagelog/db.changelog-master.yaml",new ClassLoaderResourceAccessor(),database);
//
//            liquibase.rollback("version1.0", "development");
//        }catch (LiquibaseException e){
//            e.printStackTrace();
//        }
//
//    }
//}
