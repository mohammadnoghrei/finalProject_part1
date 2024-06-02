package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Services;
import madsilver.model.SubServices;
import madsilver.repository.SubServicesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SubServicesServiceImpl extends BaseServiceImpl<SubServices,Long, SubServicesRepository> implements SubServicesService{
    public SubServicesServiceImpl(SubServicesRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<SubServices> findAllSubServicesOfaService(Services services) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<SubServices> lessonList= repository.findAllSubServicesOfaService(services);
            transaction.commit();
            return lessonList;
        } catch (Exception e) {
            e.getMessage();
            assert transaction != null;
            transaction.rollback();
            return null;
        }
    }
}
