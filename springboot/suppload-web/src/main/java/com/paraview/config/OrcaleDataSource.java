package com.paraview.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//orcale配置  其中的意思同上mysql
@Configuration
@MapperScan(basePackages = "com.paraview.oracleMapper", sqlSessionTemplateRef  = "orcaleSqlSessionTemplate")
public class OrcaleDataSource {

    @Bean(name = "orcaleDataSources")
    @Qualifier("orcaleDataSources")
    @ConfigurationProperties(prefix = "spring.datasource.oracledb")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "orcaleSqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("orcaleDataSources") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/oracleMapper/*.xml"));
        return bean.getObject();
    }

    //配置声明式事务管理器
    @Bean(name = "orcaleTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("orcaleDataSources") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "orcaleSqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("orcaleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
