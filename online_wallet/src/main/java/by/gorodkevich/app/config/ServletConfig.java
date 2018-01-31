package by.gorodkevich.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.gorodkevich.app.controller")

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
