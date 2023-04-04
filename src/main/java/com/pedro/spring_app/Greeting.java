package com.pedro.spring_app;

public class Greeting {

    private final long id;
    private final String features;

    public Greeting(long id, String content) {
        this.id = id;
        this.features = content;
    }

    public long getId() {
        return id;
    }

    public String getFeatures() {
        return features;
    }
}