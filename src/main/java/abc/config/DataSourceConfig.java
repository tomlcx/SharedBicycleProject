
package com.abc.tyc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;


@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    static final String PACKAGE = "com.abc.tyc.mapper.prism3";
    static final String MAPPER_LOCATION = "classpath:mapping/prism3/*.xml";


    /*
     * 主数据源
     */

    @Value("${spring.datasource.primary.url}")
    private String primaryUrl;

    @Value("${spring.datasource.primary.username}")
    private String primaryUsername;

    @Value("${spring.datasource.primary.password}")
    private String primaryPassword;

    @Value("${spring.datasource.primary.driver-class-name}")
    private String primaryDriverClassName;

    @Value("${spring.datasource.primary.druid.initial-size}")
    private String primaryDruidInitialSize;

    @Value("${spring.datasource.primary.druid.connection.init.sql}")
    private String primaryDruidInitSQL;

    @Value("${spring.datasource.primary.druid.min-idle}")
    private String primaryDruidMinIdle;

    @Value("${spring.datasource.primary.druid.max-active}")
    private String primaryDruidMaxActive;

/**
     * 最大超时时间，60s
     */

    @Value("${spring.datasource.primary.druid.max-wait}")
    private String primaryDruidMaxWaitTime;

    @Value("${spring.datasource.primary.druid.test-on-borrow}")
    private String primaryDruidTestOnBorrow;

    @Value("${spring.datasource.primary.druid.stat-view-servlet.allow}")
    private String primaryDruidStatViewServletAllow;

    @Value("${spring.datasource.primary.druid.validationQuery}")
    private String primaryDruidValidationQuery;

    @Value("${spring.datasource.primary.druid.testWhileIdle}")
    private String primaryDruidTestWhileIdle;

    @Value("${spring.datasource.primary.druid.timeBetweenEvictionRunsMillis}")
    private String primaryDruidTimeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.primary.druid.testOnReturn}")
    private String primaryDruidTestOnReturn;

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    @Primary
    public DataSource primaryDruidDataSource() {

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(primaryUrl);
        datasource.setUsername(primaryUsername);
        datasource.setPassword(primaryPassword);
        datasource.setDriverClassName(primaryDriverClassName);
        datasource.setInitialSize(Integer.parseInt(primaryDruidInitialSize));
        datasource.setMinIdle(Integer.parseInt(primaryDruidMinIdle));
        datasource.setMaxWait(Integer.parseInt(primaryDruidMaxWaitTime));
        datasource.setMaxActive(Integer.parseInt(primaryDruidMaxActive));
        ArrayList<String> initSqls = new ArrayList<>();
        initSqls.add(primaryDruidInitSQL);
        datasource.setConnectionInitSqls(initSqls);
        datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(primaryDruidTimeBetweenEvictionRunsMillis));
        datasource.setValidationQuery(primaryDruidValidationQuery);
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(true);
        datasource.setTestOnReturn(false);
        return datasource;
    }

//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(
//            @Qualifier("dataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(primaryDruidDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
