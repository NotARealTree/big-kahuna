package com.notarealtree.bigkahuna.resources;

import com.notarealtree.bigkahuna.s3.S3Connector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class KahunaResource_Factory implements Factory<KahunaResource> {
  private final Provider<S3Connector> s3ConnectorProvider;

  public KahunaResource_Factory(Provider<S3Connector> s3ConnectorProvider) {
    this.s3ConnectorProvider = s3ConnectorProvider;
  }

  @Override
  public KahunaResource get() {
    return new KahunaResource(s3ConnectorProvider.get());
  }

  public static Factory<KahunaResource> create(Provider<S3Connector> s3ConnectorProvider) {
    return new KahunaResource_Factory(s3ConnectorProvider);
  }
}
