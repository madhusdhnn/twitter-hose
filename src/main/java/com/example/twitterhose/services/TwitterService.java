package com.example.twitterhose.services;

import com.example.twitterhose.configurations.TwitterApiConfig;
import com.example.twitterhose.listeners.TwitterHoseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

import javax.annotation.PostConstruct;

@Service
public class TwitterService {

    @Value("${filter.keywords}")
    private String[] filterQueryKeywords;

    private final TwitterHoseListener twitterHoseListener;

    @Autowired
    public TwitterService(TwitterHoseListener twitterHoseListener) {
        this.twitterHoseListener = twitterHoseListener;
    }

    @PostConstruct
    void bootstrap() {
        Configuration configuration = TwitterApiConfig.setupTwitter4jConfiguration();
        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        new TwitterStreamingService(twitterStream).attachListener(this.twitterHoseListener).stream(new FilterQuery(filterQueryKeywords));
    }

}
