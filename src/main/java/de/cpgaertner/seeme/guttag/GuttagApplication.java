package de.cpgaertner.seeme.guttag;

import de.cpgaertner.seeme.guttag.conf.GuttagConfiguration;
import de.cpgaertner.seeme.guttag.resources.TestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class GuttagApplication extends Application<GuttagConfiguration> {
    @Override
    public void run(GuttagConfiguration conf, Environment env) throws Exception {
        final TestResource testResource = new TestResource(conf.getTest());

        env.jersey().register(testResource);
    }
}
