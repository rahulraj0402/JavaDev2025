package com.coding.rahul.learningRestAPIs;

public class TokenBucketRateLimiter {
    private final int capacity; // max token bucket can hold
    private final int refilRate; // token per second
    private  double token; // current token
    private long lastRefillTime; // last refil timestamp

    public TokenBucketRateLimiter(int capacity, int refilRate, double token, long lastRefillTime) {
        this.capacity = capacity;
        this.refilRate = refilRate;
        this.token = token;
        this.lastRefillTime = lastRefillTime;
    }
// https://app.eraser.io/workspace/zwCIBHabmi5Atcb3YORn
    public synchronized boolean allowRequest(){

    }
    private void refill(){

    }
}
