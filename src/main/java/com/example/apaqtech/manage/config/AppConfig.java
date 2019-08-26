package com.example.apaqtech.manage.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

@Configuration
public class AppConfig {//只用修改config而不需要修改代码，就能实现功能
    //通过bean实现各种功能，在AppConfig中直接调用注入就可以实现

//    @Bean
//    AdminRepo adminRepo(){
//        return new AdminJpaRepo();
//    }


    /**
     * 如果没有这个datasource是无法链接数据库的
     * 把这个AppConfig当成一个配置文件即可
     * 可以根据需要配置多个datasource
     * @return
     */
    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();//连接本地数据库
        dataSource.setURL("jdbc:mysql://localhost:3306/apaqNet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("zts19950208");
        dataSource.setDatabaseName("apaqNet");
        return dataSource;
    }





}