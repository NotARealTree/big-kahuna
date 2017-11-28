package com.notarealtree.bigkahuna.dagger;

import com.amazonaws.services.s3.AmazonS3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class KahunaModule_AmazonS3Factory implements Factory<AmazonS3> {
  private final KahunaModule module;

  public KahunaModule_AmazonS3Factory(KahunaModule module) {
    this.module = module;
  }

  @Override
  public AmazonS3 get() {
    return Preconditions.checkNotNull(
        module.amazonS3(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonS3> create(KahunaModule module) {
    return new KahunaModule_AmazonS3Factory(module);
  }
}
