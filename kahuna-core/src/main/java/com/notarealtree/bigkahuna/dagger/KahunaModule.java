package com.notarealtree.bigkahuna.dagger;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.notarealtree.bigkahuna.config.KahunaConfig;
import com.notarealtree.bigkahuna.config.S3Config;
import com.notarealtree.bigkahuna.dagger.annotations.S3BucketName;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class KahunaModule {
    private final KahunaConfig kahunaConfig;

    public KahunaModule(KahunaConfig kahunaConfig) {
        this.kahunaConfig = kahunaConfig;
    }

    @Provides
    @Singleton
    public AmazonS3 amazonS3() {
        S3Config s3Config = kahunaConfig.getS3Config();
        BasicAWSCredentials credentials =
                new BasicAWSCredentials(s3Config.getAccessKeyId(), s3Config.getSecretAccessKey());
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.fromName(s3Config.getS3region()))
                .build();
    }

    @Provides
    @S3BucketName
    public String s3BucketName() {
        return kahunaConfig.getS3Config().getBucketName();
    }

}
