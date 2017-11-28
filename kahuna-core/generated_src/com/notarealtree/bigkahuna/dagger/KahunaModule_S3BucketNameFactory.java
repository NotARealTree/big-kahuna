package com.notarealtree.bigkahuna.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class KahunaModule_S3BucketNameFactory implements Factory<String> {
  private final KahunaModule module;

  public KahunaModule_S3BucketNameFactory(KahunaModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return Preconditions.checkNotNull(
        module.s3BucketName(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<String> create(KahunaModule module) {
    return new KahunaModule_S3BucketNameFactory(module);
  }
}
