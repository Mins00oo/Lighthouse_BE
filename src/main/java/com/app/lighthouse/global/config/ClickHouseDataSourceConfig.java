package com.app.lighthouse.global.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ClickHouseDataSourceConfig {

    @Bean(name = "clickHouseDataSource")
    @ConfigurationProperties(prefix = "clickhouse.datasource")
    public DataSource clickHouseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "clickHouseJdbcTemplate")
    public JdbcTemplate clickHouseJdbcTemplate(
            @Qualifier("clickHouseDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
