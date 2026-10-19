package com.customerorder.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "redis")
public class RedisDetailsConfig {

    private String host;
    private int port;
    private int ttl;

    public RedisDetailsConfig(String host, int port, int ttl) {
        this.host = host;
        this.port = port;
        this.ttl = ttl;

        System.out.println(host);
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public int getTtl() {
        return this.ttl;
    }
}
