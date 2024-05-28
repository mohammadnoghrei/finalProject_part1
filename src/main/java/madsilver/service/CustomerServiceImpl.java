package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Customer;
import madsilver.repository.CustomerRepository;
import org.hibernate.SessionFactory;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService{
    public CustomerServiceImpl(CustomerRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
