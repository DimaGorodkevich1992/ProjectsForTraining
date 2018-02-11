package by.gorodkevich.online.wallet.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import({PersistenceConfig.class, SecurityConfig.class})
@ComponentScan("by.gorodkevich.online.wallet.service")
public class ApplicationConfig {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("persistence.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

}
