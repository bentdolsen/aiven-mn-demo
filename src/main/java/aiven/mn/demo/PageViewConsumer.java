package aiven.mn.demo;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(groupId = "pageview-consumer", offsetReset = OffsetReset.LATEST)
public class PageViewConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(PageViewConsumer.class);

    @Topic("pageviews")
    public void pageViews(@KafkaKey PageViewKey key, PageView pageView) {
        LOG.info("Got page view with key {} and device {}", key.getId(), pageView.getDevice());
    }
}
