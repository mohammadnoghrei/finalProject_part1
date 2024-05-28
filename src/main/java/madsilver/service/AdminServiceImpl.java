package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Admin;
import madsilver.repository.AdminRepository;
import org.hibernate.SessionFactory;

public class AdminServiceImpl extends BaseServiceImpl<Admin,Long, AdminRepository> implements AdminService{
    public AdminServiceImpl(AdminRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
