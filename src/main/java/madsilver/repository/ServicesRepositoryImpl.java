package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Services;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServicesRepositoryImpl extends BaseRepositoryImpl<Services,Long> implements ServicesRepository{
    public ServicesRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Services> getEntityClass() {
        return Services.class;
    }

    @Override
    public List<Services> findAll() {
            Session session = SessionFactorySingleton.getInstance().openSession();
            Query<Services> queryStudent = session.createQuery("FROM Services ", Services.class);
            List<Services> servicesList = queryStudent.list();
            session.close();
            return servicesList;
    }
}
