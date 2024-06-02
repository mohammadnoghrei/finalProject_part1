package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Services;
import madsilver.model.SubServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubServices,Long> implements SubServicesRepository {
    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<SubServices> getEntityClass() {
        return SubServices.class;
    }

    @Override
    public List<SubServices> findAllSubServicesOfaService(Services services) {
        Session session= SessionFactorySingleton.getInstance().getCurrentSession();
        Query<SubServices> query = session.createQuery("FROM SubServices s WHERE s.services = :service ", SubServices.class);
        query.setParameter("service",services);
        List<SubServices> subServiceList=query.list();
        session.close();
        return subServiceList;
    }
}
