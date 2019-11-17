package com.example.twitterhose.services;

import com.example.twitterhose.models.TweetData;
import com.example.twitterhose.models.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
@Log4j2
public class KafkaPublisher {

    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, TweetData> kafkaTemplate;

    @Autowired
    public KafkaPublisher(KafkaTemplate<String, TweetData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public void publishAsync(Status status) {
        if (status != null) {
            try {
                publish(new TweetData(status));
            } catch (Exception ex) {
                log.error(String.format("Error while publishing to Kafka - %s", ex.getMessage()), ex);
            }
        }
    }

    private void publish(TweetData tweetData) {
        User user = tweetData.getUser();
        final String key = String.format("%s_%d", user.getName(), user.getId());
        this.kafkaTemplate.send(topic, key, tweetData);
    }

}
