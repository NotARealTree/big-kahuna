package com.notarealtree.bigkahuna.dagger;

import com.notarealtree.bigkahuna.resources.KahunaResource;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { KahunaModule.class })
public interface KahunaComponent {
    KahunaResource kahunaService();
}
