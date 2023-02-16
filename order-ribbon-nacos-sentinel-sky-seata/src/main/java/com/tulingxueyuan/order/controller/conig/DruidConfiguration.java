package com.tulingxueyuan.order.controller.conig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;


/**
 * @author:gaojinjun
 * @date: 2023022023/2/15下午2:17
 **/


@Configuration
@ConditionalOnProperty("spring.datasource.type")
public class DruidConfiguration {
//    @Bean
//    //绑定application.yml文件中所有的属性到datasource对象中
//   /*
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }
//    */
//    //根据application.yml构造数据源
//    public DataSource dataSource(DataSourceProperties properties){
//        //根据配置动态构建一个DataSource
//        return properties.initializeDataSourceBuilder().build();
//    }

    //构造Druid监控台,通过localhost:port/druid 可以监控数据库连接相关情况
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//        servletRegistrationBean.addInitParameter("loginPassword","admin");
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//
//    }

//    /*构造过滤器：监控哪些访问*/
//    @Bean
//    public FilterRegistrationBean statFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }


}
