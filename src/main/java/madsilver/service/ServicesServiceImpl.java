package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Services;
import madsilver.repository.ServicesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ServicesServiceImpl extends BaseServiceImpl<Services,Long, ServicesRepository> implements ServicesService{
    public ServicesServiceImpl(ServicesRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<Services> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Services> lessonList= repository.findAll();
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
