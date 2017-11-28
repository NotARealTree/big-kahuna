package com.notarealtree.bigkahuna.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class KahunaConfig extends Configuration {
    @JsonProperty("s3")
    private S3Config s3Config;

    public S3Config getS3Config() {
        return s3Config;
    }

    public void setS3Config(S3Config s3Config) {
        this.s3Config = s3Config;
    }
}
