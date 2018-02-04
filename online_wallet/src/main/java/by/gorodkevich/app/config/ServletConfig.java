package by.gorodkevich.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("by.gorodkevich.app.controller")
@EnableWebMvc
public class ServletConfig {
   /* @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
    @Bean
    public MappingJackson2HttpMessageConverter converter(){
        return new MappingJackson2HttpMessageConverter();
    }*/
}
