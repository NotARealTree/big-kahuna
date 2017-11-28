package com.notarealtree.bigkahuna.dagger;

import com.amazonaws.services.s3.AmazonS3;
import com.notarealtree.bigkahuna.resources.KahunaResource;
import com.notarealtree.bigkahuna.s3.S3Connector;
import com.notarealtree.bigkahuna.s3.S3Connector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerKahunaComponent implements KahunaComponent {
  private Provider<String> s3BucketNameProvider;

  private Provider<AmazonS3> amazonS3Provider;

  private Provider<S3Connector> s3ConnectorProvider;

  private DaggerKahunaComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.s3BucketNameProvider = KahunaModule_S3BucketNameFactory.create(builder.kahunaModule);
    this.amazonS3Provider =
        DoubleCheck.provider(KahunaModule_AmazonS3Factory.create(builder.kahunaModule));
    this.s3ConnectorProvider =
        DoubleCheck.provider(S3Connector_Factory.create(s3BucketNameProvider, amazonS3Provider));
  }

  @Override
  public KahunaResource kahunaService() {
    return new KahunaResource(s3ConnectorProvider.get());
  }

  public static final class Builder {
    private KahunaModule kahunaModule;

    private Builder() {}

    public KahunaComponent build() {
      if (kahunaModule == null) {
        throw new IllegalStateException(KahunaModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerKahunaComponent(this);
    }

    public Builder kahunaModule(KahunaModule kahunaModule) {
      this.kahunaModule = Preconditions.checkNotNull(kahunaModule);
      return this;
    }
  }
}
