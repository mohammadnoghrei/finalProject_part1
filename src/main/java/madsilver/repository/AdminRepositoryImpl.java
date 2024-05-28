package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import org.hibernate.SessionFactory;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,Long> implements AdminRepository{
    public AdminRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
