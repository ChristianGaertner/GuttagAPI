package de.cpgaertner.seeme.guttag;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import de.cpgaertner.seeme.guttag.conf.GuttagConfiguration;
import de.cpgaertner.seeme.guttag.core.TimeFrame;
import de.cpgaertner.seeme.guttag.core.User;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;

@Log4j
public class GuttagModule extends AbstractModule {

    private final HibernateBundle<GuttagConfiguration> hibernateBundle =
            new HibernateBundle<GuttagConfiguration>(User.class, TimeFrame.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(GuttagConfiguration conf) {
                    return conf.getDatabase();
                }
            };

    @Override
    protected void configure() {
    }

    /**
     * Hack to get SessionFactory work.
     *
     * See http://stackoverflow.com/questions/23320927/how-to-auto-wire-hibernatebundle-with-guice-on-dropwizard
     * @param conf
     * @param env
     * @return
     */
    @Provides
    public SessionFactory provideSessionFactory(GuttagConfiguration conf, Environment env) {
        SessionFactory sf = hibernateBundle.getSessionFactory();

        if (sf == null) {
            try {
                hibernateBundle.run(conf, env);
                return hibernateBundle.getSessionFactory();
            } catch (Exception e) {
                log.error("Could not run hibernate-bundle", e);
            }
        }

        return sf;
    }
}
