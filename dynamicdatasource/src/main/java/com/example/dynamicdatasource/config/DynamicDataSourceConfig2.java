//package com.example.dynamicdatasource.config;
//
//import com.example.dynamicdatasource.enu.DataSourceTypeEnum;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @description:
// * @author: lyq
// * @createDate: 2020/1/31
// */
//
//@Configuration
//@MapperScan(basePackages = "com.example.dynamicdatasource.dynamic.mapper")
//public class DynamicDataSourceConfig2 {
//
//    @Value("${spring.datasource.primary.url}")
//    private String primaryUrl;
//    @Value("${spring.datasource.user.url}")
//    private String userUrl;
//    @Value("${mybatis.mapper-locations}")
//    private String resources;
//
//    @Autowired
//    private HikariConfig hikariConfig;
//
//
//    @Primary
//    @Bean(name = "primaryDataSource")
//    public DataSource getPrimaryDataSource(){
//        return hikariConfig.getHikariDataSource(primaryUrl);
//    }
//    @Bean(name = "userDataSource")
//    public DataSource getUserDataSource(){
//        return hikariConfig.getHikariDataSource(userUrl);
//    }
//    @Bean("dynamicDataSource")
//    public DynamicDataSource dynamicDataSource(@Qualifier("primaryDataSource") DataSource primary,@Qualifier("userDataSource")DataSource userDataSource){
//        Map<Object,Object> target = new HashMap<>();
//        target.put(DataSourceTypeEnum.PRIMARY,primary);
//        target.put(DataSourceTypeEnum.USER,userDataSource);
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(target);
//        dataSource.setDefaultTargetDataSource(primary);
//        return dataSource;
//    }
//
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource")DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(resources));
//        return bean.getObject();
//    }
//}
