package com.paraview.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//msql配置对象
@Configuration
@MapperScan(basePackages = "com.paraview.mapper", sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
public class MysqlDataSource {


    @Bean(name = "mysqlDataSources")
    @Qualifier("mysqlDataSources")
    //这是主数据库链接对象 一定要添加的
    @Primary
    //读取数据库中的配置文件属性
    @ConfigurationProperties(prefix = "spring.datasource.mysqldb")
    public DataSource secondaryDataSource() {

       return DataSourceBuilder.create().build();
       /* return DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class)
                .driverClassName(properties.determineDriverClassName())
                .url(properties.determineUrl())
                .username(properties.determineUsername())
                .password(properties.determinePassword())
                .build();*/

    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("mysqlDataSources") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        //这里很重要 就是指定自己的数据库sql文件的地址 其他的偶可以复制 这里需要改
                        .getResources("classpath:mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public PlatformTransactionManager secondaryTransactionManager(
            @Qualifier("mysqlDataSources") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
