package by.gorodkevich.config;

import by.gorodkevich.models.IndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties()
@ComponentScan(basePackages = "")
public class QueueConfig {
    public static String QUEUE_NAME = "example.queue";





}
