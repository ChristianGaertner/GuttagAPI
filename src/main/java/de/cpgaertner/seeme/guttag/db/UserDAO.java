package de.cpgaertner.seeme.guttag.db;

import de.cpgaertner.seeme.guttag.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDAO extends AbstractDAO<User> {
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

    public List<User> findAll() {
        return list(namedQuery("de.cpgaertner.seeme.guttag.core.User.findAll"));
    }
}
