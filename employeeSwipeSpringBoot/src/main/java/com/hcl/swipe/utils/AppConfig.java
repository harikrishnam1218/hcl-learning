package com.hcl.swipe.utils;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
//@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {
	@Autowired
    private Environment env;


    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }    

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource()
    {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
      //  dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    	dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
    	dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
		/*
		 * dataSource.setUrl(env.getProperty("jdbc.url"));
		 * dataSource.setUsername(env.getProperty("jdbc.username"));
		 * dataSource.setPassword(env.getProperty("jdbc.password"));
		 */
        return dataSource;
    }

	/*
	 * @Bean public DataSourceInitializer dataSourceInitializer(DataSource
	 * dataSource) { DataSourceInitializer dataSourceInitializer = new
	 * DataSourceInitializer(); dataSourceInitializer.setDataSource(dataSource);
	 * ResourceDatabasePopulator databasePopulator = new
	 * ResourceDatabasePopulator(); databasePopulator.addScript(new
	 * ClassPathResource("data.sql"));
	 * dataSourceInitializer.setDatabasePopulator(databasePopulator);
	 * dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase)); return
	 * dataSourceInitializer; }
	 */
}
