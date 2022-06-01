package com.example.demo.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

@Configuration
public class DataSourceConfig {


    @Primary
    @Bean(name="ds1Properties")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSourceProperties ds1DataSourceProperties(){
        System.out.println("设置数据源bean成功");
        return new DataSourceProperties();
    }
    @Primary
    @Bean(name="dataSource1")
    public DataSource ds1DataSource(@Qualifier("ds1Properties") DataSourceProperties dataSourceProperties){
        System.out.println("初始化数据源");
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();

    }
    @Primary
    @Bean(name="ds1SqlsessionFactory")
    public SqlSessionFactory getds1SqlSessionFactory(@Qualifier(value="dataSource1") DataSource ds) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean("ds1TransactionManager")
    public DataSourceTransactionManager getds1TransactionManager(@Qualifier("dataSource1") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }

    @Bean("ds1SqlsessionTemplate")
    public SqlSessionTemplate getds1SqlSessionTemplate(@Qualifier("ds1SqlsessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
