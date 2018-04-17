package jms.config.queue;

import jms.config.queue.QueueServiceConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "broker")
public class QueueServiceConfigImpl implements QueueServiceConfig {

    private String QueueName;
    private String Url;
    private int NumberConsumers;
    private long RetryTimeout;

    @Override
    public String getQueueName() {
        return QueueName;
    }

    public void setQueueName(String queueName) {
        QueueName = queueName;
    }

    @Override
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public int getNumberConsumers() {
        return NumberConsumers;
    }

    public void setNumberConsumers(int numberConsumers) {
        NumberConsumers = numberConsumers;
    }

    @Override
    public long getRetryTimeout() {
        return RetryTimeout;
    }

    public void setRetryTimeout(long retryTimeout) {
        RetryTimeout = retryTimeout;
    }
}
