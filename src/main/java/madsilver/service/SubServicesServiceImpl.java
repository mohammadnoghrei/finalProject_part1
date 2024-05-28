package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.SubServices;
import madsilver.repository.SubServicesRepository;
import org.hibernate.SessionFactory;

public class SubServicesServiceImpl extends BaseServiceImpl<SubServices,Long, SubServicesRepository> implements SubServicesService{
    public SubServicesServiceImpl(SubServicesRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
