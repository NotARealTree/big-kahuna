package com.notarealtree.bigkahuna.s3;

import com.amazonaws.services.s3.AmazonS3;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class S3Connector_Factory implements Factory<S3Connector> {
  private final Provider<String> bucketNameProvider;

  private final Provider<AmazonS3> s3Provider;

  public S3Connector_Factory(Provider<String> bucketNameProvider, Provider<AmazonS3> s3Provider) {
    this.bucketNameProvider = bucketNameProvider;
    this.s3Provider = s3Provider;
  }

  @Override
  public S3Connector get() {
    return new S3Connector(bucketNameProvider.get(), s3Provider.get());
  }

  public static Factory<S3Connector> create(
      Provider<String> bucketNameProvider, Provider<AmazonS3> s3Provider) {
    return new S3Connector_Factory(bucketNameProvider, s3Provider);
  }
}
