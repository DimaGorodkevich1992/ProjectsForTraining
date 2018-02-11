package by.gorodkevich.online.wallet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@ComponentScan("by.gorodkevich.online.wallet.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String REMEMBER_ME_KEY = "OW_REMEMBER_ME_KEY";
    private static final String REMEMBER_ME_COOKIE = "OW_REMEMBER_ME_COOKIE";
    private static final int REMEMBER_ME_PERIOD = 1209600; // two weeks

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                    .csrf().disable()
                    .anonymous()
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/service/**").authenticated()
                .and()
                    .formLogin()
                    .loginProcessingUrl("/api/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .successHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_ACCEPTED))
                    .failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied"))
                .and()
                    .rememberMe()
                    .rememberMeServices(rememberMeServices())
                    .key(REMEMBER_ME_KEY)
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public RememberMeServices rememberMeServices()
    {
        PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices(
                REMEMBER_ME_KEY, userDetailsService, tokenRepository());
        rememberMeServices.setAlwaysRemember(true);
        rememberMeServices.setCookieName(REMEMBER_ME_COOKIE);
        rememberMeServices.setTokenValiditySeconds(REMEMBER_ME_PERIOD);
        return rememberMeServices;
    }

    @Bean
    public PersistentTokenRepository tokenRepository()
    {
        return new InMemoryTokenRepositoryImpl();
    }
}
