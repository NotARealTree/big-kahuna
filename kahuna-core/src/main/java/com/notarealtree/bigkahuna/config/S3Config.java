package com.notarealtree.bigkahuna.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class S3Config {
    @JsonProperty("s3-region")
    private String s3region = "test";
    @JsonProperty("access-key-id")
    private String accessKeyId;
    @JsonProperty("secret-access-key")
    private String secretAccessKey;
    @JsonProperty("bucketName")
    private String bucketName;

    public String getS3region() {
        return s3region;
    }

    public void setS3region(String s3region) {
        this.s3region = s3region;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
