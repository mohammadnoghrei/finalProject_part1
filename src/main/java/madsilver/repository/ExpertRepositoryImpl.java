package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ExpertRepositoryImpl extends BaseRepositoryImpl<Expert,Long> implements ExpertRepository{
    public ExpertRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public Optional<Expert> findByUsername(String username) {
        Session session = SessionFactorySingleton.getInstance().openSession();

        Query <Expert>query = session.createQuery("FROM Person p WHERE p.username=:username", Expert.class);
        query.setParameter("username", username);

        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Expert> findAllNotConfirmedExpert() {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Expert> expertQuery = session.createQuery("FROM Expert e where e.expertStatus=:expertStatus", Expert.class);
        expertQuery.setParameter("expertStatus", ExpertStatus.WAITING_FOR_CONFIRMATION);
        List<Expert> expertList = expertQuery.list();
        session.close();
        return expertList;
    }
    @Override
    public List<Expert> findAllConfirmedExpert() {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Expert> expertQuery = session.createQuery("FROM Expert e where e.expertStatus=:expertStatus", Expert.class);
        expertQuery.setParameter("expertStatus", ExpertStatus.CONFIRMED);
        List<Expert> expertList = expertQuery.list();
        session.close();
        return expertList;
    }
}
