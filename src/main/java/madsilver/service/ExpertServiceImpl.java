package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Expert;
import madsilver.repository.ExpertRepository;
import org.hibernate.SessionFactory;

public class ExpertServiceImpl extends BaseServiceImpl<Expert,Long, ExpertRepository> implements ExpertService{
    public ExpertServiceImpl(ExpertRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
