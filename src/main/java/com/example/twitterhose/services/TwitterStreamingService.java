package com.example.twitterhose.services;

import lombok.extern.log4j.Log4j2;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

import javax.annotation.PreDestroy;

@Log4j2
public class TwitterStreamingService {

    private final TwitterStream twitterStream;

    TwitterStreamingService(TwitterStream twitterStream) {
        this.twitterStream = twitterStream;
    }

    TwitterStreamingService attachListener(StatusListener listener) {
        this.twitterStream.addListener(listener);
        return this;
    }

    void stream(FilterQuery filterQuery) {
        log.info(String.format("Starting Twitter stream to collect tweets with filter query - %s", filterQuery));
        this.twitterStream.sample().filter(filterQuery);
    }

    @PreDestroy
    void close() {
        log.info("Closing Twitter stream");
        this.twitterStream.shutdown();
    }

}
