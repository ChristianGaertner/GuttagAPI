package de.cpgaertner.seeme.guttag;

import de.cpgaertner.seeme.guttag.conf.GuttagConfiguration;
import de.cpgaertner.seeme.guttag.core.User;
import de.cpgaertner.seeme.guttag.db.UserDAO;
import de.cpgaertner.seeme.guttag.resources.ApplicationResource;
import de.cpgaertner.seeme.guttag.resources.VersionResource;
import de.cpgaertner.seeme.guttag.resources.v1.UserResource;
import de.cpgaertner.seeme.guttag.resources.v1.UsersResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GuttagApplication extends Application<GuttagConfiguration> {

    private final HibernateBundle<GuttagConfiguration> hibernateBundle =
            new HibernateBundle<GuttagConfiguration>(User.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(GuttagConfiguration conf) {
            return conf.getDatabase();
        }
    };


    @Override
    public void initialize(Bootstrap<GuttagConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new MigrationsBundle<GuttagConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(GuttagConfiguration conf) {
                return conf.getDatabase();
            }
        });
    }

    @Override
    public void run(GuttagConfiguration conf, Environment env) throws Exception {
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());

        env.jersey().register(new VersionResource(conf.getVersion()));
        env.jersey().register(new ApplicationResource());
        env.jersey().register(new UserResource(userDAO));
        env.jersey().register(new UsersResource(userDAO));
    }
}
