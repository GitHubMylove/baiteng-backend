package com.baiteng.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
**  @Author: gaozhixing
**  @Date: 2018/3/18 21:28
**  @Description:
**/
@Configuration
public class DataSourceConfig {
	@Autowired
    private Environment env;
    @Value("${electric.motorcycle.datasource.url}")
    String dataSourceUrl;
    @Value("${electric.motorcycle.datasource.username}")
    String dataSourceUsername;
    @Value("${electric.motorcycle.datasource.password}")
    String dataSourcePassword;
    @Value("${electric.motorcycle.datasource.driverClassName}")
    String dataSourceDriverClassName;

    @Primary
	@Bean(name = "electricMotorcycleDataSource")
    public DataSource driverAdminDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println(dataSourceUrl);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);//用户名
        dataSource.setPassword(dataSourcePassword);//密码
        dataSource.setDriverClassName(dataSourceDriverClassName);
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setDefaultAutoCommit(false);//设定不自动提交
        return dataSource;
    }

}
