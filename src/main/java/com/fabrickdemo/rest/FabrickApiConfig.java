package com.fabrickdemo.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fabrickapi")
public class FabrickApiConfig {
    String url;
    String apikey;

    public String getApikey() {
        return this.apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}