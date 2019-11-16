package com.example.twitterhose.configurations;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterApiConfig {

    private static final String CONSUMER_KEY = "4h0BAc7lg8kJXJLjoQJW70n6U";
    private static final String CONSUMER_SECRET = "Pkya2ZplepT3TTSTjkun0mZEPm0KuB6WTquGhApc3AIKTXJTWR";
    private static final String ACCESS_TOKEN = "591795371-wrYKl7FqLaaZok8G132y0OFJRuwGvelz77leDdZ7";
    private static final String ACCESS_TOKEN_SECRET = "mZCwAJ9bylkvfV6nt1dPizUh3jhXnHmF4RKohcQfHSkP6";

    public static Configuration setupTwitter4jConfiguration() {
        final ConfigurationBuilder builder = new ConfigurationBuilder();
        return builder.setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET)
                .build();
    }

}
