package de.cpgaertner.seeme.guttag.db;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.cpgaertner.seeme.guttag.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

@Singleton
public class UserDAO extends AbstractDAO<User> {
    @Inject
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public User create(User user) {
        return persist(user);
    }

    public User update(User user) {
        currentSession().update(user);
        return user;
    }

    public void delete(User user) {
        currentSession().delete(user);
    }

    public List<User> findAll() {
        return list(namedQuery("de.cpgaertner.seeme.guttag.core.User.findAll"));
    }
}
