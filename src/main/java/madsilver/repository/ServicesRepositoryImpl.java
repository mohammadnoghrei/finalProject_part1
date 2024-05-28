package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import madsilver.model.Services;
import org.hibernate.SessionFactory;

public class ServicesRepositoryImpl extends BaseRepositoryImpl<Services,Long> implements ServicesRepository{
    public ServicesRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Services> getEntityClass() {
        return Services.class;
    }
}
