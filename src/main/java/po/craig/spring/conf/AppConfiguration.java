package po.craig.spring.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

/**
 * spring boot 主配置文件
 * Created by wuxf on 15-7-24.
 */
@Configuration
@ComponentScan("po.craig.spring")
@EnableAutoConfiguration
public class AppConfiguration {
    @Value("${server.tomcat.maxKeepAliveRequests}")
    private String maxKeepAliveRequests = "1";

    /**
     * 生成一个内置tomcat实例，并设置默认编码为utf-8
     * @return tomcat实例
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new TomcatEmbeddedServletContainerFactory() {
            public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
                TomcatEmbeddedServletContainer embeddedServletContainer =
                        (TomcatEmbeddedServletContainer) super.getEmbeddedServletContainer(initializers);
                Connector connector = embeddedServletContainer.getTomcat().getConnector();
                connector.setURIEncoding("UTF-8");
                connector.setAttribute("maxKeepAliveRequests", maxKeepAliveRequests);
                return embeddedServletContainer;
            }
        };
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(DatasourceConfig datasourceConfig) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(datasourceConfig.getUrl());
        hikariConfig.setUsername(datasourceConfig.getUsername());
        hikariConfig.setPassword(datasourceConfig.getPassword());
        hikariConfig.setMaximumPoolSize(datasourceConfig.getMaximumPoolSize());
        hikariConfig.setDriverClassName(datasourceConfig.getDriverClassName());
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    // 文件上传支持
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("50MB");
        factory.setMaxRequestSize("50MB");
        return factory.createMultipartConfig();
    }
}
