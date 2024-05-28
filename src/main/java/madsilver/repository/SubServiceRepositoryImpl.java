package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.SubServices;
import org.hibernate.SessionFactory;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubServices,Long> implements SubServicesRepository {
    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<SubServices> getEntityClass() {
        return SubServices.class;
    }
}
