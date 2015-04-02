package de.cpgaertner.seeme.guttag;

import de.cpgaertner.seeme.guttag.conf.GuttagConfiguration;
import de.cpgaertner.seeme.guttag.resources.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class GuttagApplication extends Application<GuttagConfiguration> {
    @Override
    public void run(GuttagConfiguration conf, Environment env) throws Exception {
        final VersionResource versionResource = new VersionResource(conf.getVersion());

        env.jersey().register(versionResource);
    }
}
