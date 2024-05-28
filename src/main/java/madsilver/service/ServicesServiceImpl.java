package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Services;
import madsilver.repository.ServicesRepository;
import org.hibernate.SessionFactory;

public class ServicesServiceImpl extends BaseServiceImpl<Services,Long, ServicesRepository> implements ServicesService{
    public ServicesServiceImpl(ServicesRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
