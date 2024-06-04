package madsilver.service;

import madsilver.base.exeption.NotFoundException;
import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Expert;
import madsilver.model.Person;
import madsilver.model.Services;
import madsilver.repository.ExpertRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ExpertServiceImpl extends BaseServiceImpl<Expert,Long, ExpertRepository> implements ExpertService{
    public ExpertServiceImpl(ExpertRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Expert findByUsername(String username) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Expert foundEntity = repository.findByUsername(username).get();
            session.getTransaction().commit();
            session.close();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with %s not found", username));
        }
    }

    @Override
    public List<Expert> findAllNotConfirmedExpert() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Expert>expertList = repository.findAllNotConfirmedExpert();
            transaction.commit();
            return expertList;
        } catch (Exception e) {
            e.getMessage();
            assert transaction != null;
            transaction.rollback();
            return null;
        }
    }
}
