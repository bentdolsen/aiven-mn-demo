package aiven.mn.demo;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface PageViewProducer {

    @Topic("pageviews")
    void sendPageView(@KafkaKey PageViewKey key, PageView pageView);
}