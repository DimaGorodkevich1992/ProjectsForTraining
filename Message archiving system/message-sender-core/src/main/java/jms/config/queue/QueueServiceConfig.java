package jms.config.queue;

public interface QueueServiceConfig {
    String getQueueName();

    String getUrl();

    int getNumberConsumers();

    long getRetryTimeout();
}
