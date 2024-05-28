package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Customer;
import org.hibernate.SessionFactory;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer,Long> implements CustomerRepository{
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
