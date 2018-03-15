package com.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/*
 * 数据库相关配置
 */
@Configuration
@MapperScan(basePackages = "com.demo", sqlSessionFactoryRef = "dbDataSqlSessionFactory")
public class DataSourceConfig {
	@Bean(name = "dbDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dbDataSqlSessionFactory")
	public SqlSessionFactory  sqlSessionFactory(@Qualifier("dbDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/dbMapper.xml"));
		return bean.getObject();
	}

	@Bean(name = "dbDataTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("dbDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "rmdataSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("dbDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

