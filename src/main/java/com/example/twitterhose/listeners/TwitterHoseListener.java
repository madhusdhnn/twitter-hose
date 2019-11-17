package com.example.twitterhose.listeners;

import com.example.twitterhose.services.KafkaPublisher;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Log4j2
@Component
public class TwitterHoseListener implements StatusListener {

    private final KafkaPublisher kafkaPublisher;

    @Autowired
    public TwitterHoseListener(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    @Override
    public void onStatus(Status status) {
        log.info(String.format("Received status at %s. Publishing new tweet to Kafka for user %s with status id %d", status.getCreatedAt(), status.getUser().getName(), status.getId()));
        this.kafkaPublisher.publishAsync(status);
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        log.warn(String.format("Received deletion notice - %s", statusDeletionNotice));
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        log.warn(String.format("Received Track limitation notice - %d", numberOfLimitedStatuses));
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
        log.warn(String.format("Received Scrub geo event for userId %d and upToStatusId is %d", userId, upToStatusId));
    }

    @Override
    public void onException(Exception ex) {
        final String message = String.format("Error in twitter stream listener - %s", ex.getMessage());
        log.error(message, ex);
        throw new RuntimeException(message, ex);
    }

    @Override
    public void onStallWarning(StallWarning warning) {
        log.warn(String.format("Received Stall warning - %s", warning));
    }

}
