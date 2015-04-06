package de.cpgaertner.seeme.guttag;

import com.hubspot.dropwizard.guice.GuiceBundle;
import de.cpgaertner.seeme.guttag.conf.GuttagConfiguration;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GuttagApplication extends Application<GuttagConfiguration> {

    @Override
    public void initialize(Bootstrap<GuttagConfiguration> bootstrap) {

        GuiceBundle<GuttagConfiguration> guiceBundle = GuiceBundle.<GuttagConfiguration>newBuilder()
                .addModule(new GuttagModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(GuttagConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);


        bootstrap.addBundle(new MigrationsBundle<GuttagConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(GuttagConfiguration conf) {
                return conf.getDatabase();
            }
        });
    }

    @Override
    public void run(GuttagConfiguration conf, Environment env) throws Exception {
    }
}
