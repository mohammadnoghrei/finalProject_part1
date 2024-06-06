package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class SubServiceExpertRepositoryImpl extends BaseRepositoryImpl<SubServiceExpert,Long> implements SubServiceExpertRepository{
    public SubServiceExpertRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<SubServiceExpert> getEntityClass() {
        return SubServiceExpert.class;
    }

    @Override
    public Optional<SubServiceExpert> findSubServiceExpert(Expert expert, SubServices subServices) {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query query = session.createQuery("FROM SubServiceExpert p WHERE p.expert=:expert and  p.subServices=:subService");
        query.setParameter("subService", subServices);
        query.setParameter("expert", expert);
        session.close();
        return Optional.ofNullable((SubServiceExpert) query.getSingleResult());
    }
}
