package by.gorodkevich.app.config;


import by.gorodkevich.models.IndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


@Configuration
@EnableConfigurationProperties({QueueServicePropertiesConfiguration.class})
@ComponentScan(basePackages = "")
public class QueueConfig implements ApplicationListener<ContextRefreshedEvent> {

    public static String QUEUE_NAME = "example.queue";


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            service.startBatchPool(batchPoolConfiguration(), indexerEndpoint);
        } catch (CallbackAllreadyRegisteredException e) {
            e.printStackTrace();
        }
    }


}



