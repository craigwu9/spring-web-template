package po.craig.spring.conf;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring安全配置文件 Created by wuxf on 15-7-28.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery("select user_name, password, enable from mng_user where user_name = ?")
                .authoritiesByUsernameQuery("select t1.user_name, t2.role_name from mng_user_role t1, mng_role t2 "
                        + " where t1.role_id = t2.id and t1.user_name = ?")
                .passwordEncoder(new BCryptPasswordEncoder(10));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO: 这里直接跳到的是html，在页面里我无法获取到csrf的值，先禁用
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login**", "/comp/**", "/lib/**", "/images/**").permitAll()        // 不需要验证的资源
                .antMatchers("/root/**").hasAuthority("ROOT")          // 访问/root/**的资源需要root角色
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")  // 登录页面
                .permitAll();
    }
}
