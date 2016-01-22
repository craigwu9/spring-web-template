package po.craig.spring;

import po.craig.spring.conf.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * Created by wuxf on 15-7-24.
 */
@SpringBootApplication
@ComponentScan("po.craig.spring")
@Import(AppConfiguration.class)
public class Main extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppConfiguration.class);
        app.setShowBanner(false);
        app.run(args);
    }
}
