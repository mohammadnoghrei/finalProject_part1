package madsilver.service;

import madsilver.base.exeption.NotFoundException;
import madsilver.base.service.BaseServiceImpl;
import madsilver.model.*;
import madsilver.repository.SubServiceExpertRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SubServiceExpertServiceImpl extends BaseServiceImpl<SubServiceExpert,Long, SubServiceExpertRepository> implements SubServiceExpertService{
    public SubServiceExpertServiceImpl(SubServiceExpertRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public SubServiceExpert findSubServiceExpert(Expert expert, SubServices subServices) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            SubServiceExpert foundEntity = repository.findSubServiceExpert(expert,subServices).get();
            session.getTransaction().commit();
            session.close();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with  not found"));
        }
    }
}
