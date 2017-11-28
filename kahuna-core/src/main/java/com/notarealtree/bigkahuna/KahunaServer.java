package com.notarealtree.bigkahuna;

import com.notarealtree.bigkahuna.config.KahunaConfig;
import com.notarealtree.bigkahuna.dagger.DaggerKahunaComponent;
import com.notarealtree.bigkahuna.dagger.KahunaComponent;
import com.notarealtree.bigkahuna.dagger.KahunaModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KahunaServer extends Application<KahunaConfig> {

    @Override
    public void run(KahunaConfig configuration, Environment environment) throws Exception {
        KahunaComponent kahunaComponent = DaggerKahunaComponent.builder()
                .kahunaModule(new KahunaModule(configuration))
                .build();

        environment.jersey().register(kahunaComponent.kahunaService());
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            args = new String[]{"server", "kahuna.yml"};
        }
        new KahunaServer().run(args);
    }
}
