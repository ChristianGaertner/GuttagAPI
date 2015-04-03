package de.cpgaertner.seeme.guttag.db;

import de.cpgaertner.seeme.guttag.core.TimeFrame;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class TimeFrameDAO extends AbstractDAO<TimeFrame> {
    public TimeFrameDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<TimeFrame> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public TimeFrame create(TimeFrame timeFrame) {
        return persist(timeFrame);
    }

    public TimeFrame update(TimeFrame timeFrame) {
        currentSession().update(timeFrame);
        return timeFrame;
    }

    public List<TimeFrame> findAll() {
        return list(namedQuery("de.cpgaertner.seeme.guttag.core.TimeFrame.findAll"));
    }

}
