package aiven.mn.demo;

import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.time.Instant;
import java.util.UUID;

@Singleton
public class PageViewGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(PageViewGenerator.class);

    protected final PageViewProducer producer;

    public PageViewGenerator(PageViewProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedDelay = "10s")
    public void generatePageView() {
        // TODO build an API to receive the page views from
        PageViewKey pageViewKey = new PageViewKey();
        pageViewKey.setId(UUID.randomUUID().toString());
        PageView pageView = new PageView();
        pageView.setId(pageViewKey.getId());
        pageView.setDevice("web");
        pageView.setIpAddress("192.168.0.1");
        pageView.setReferrer("https://www.google.com");
        pageView.setTime(Instant.now());
        producer.sendPageView(pageViewKey, pageView);
        LOG.info("Sent fake page view");
    }
}
