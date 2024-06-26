package madsilver.service;

import madsilver.base.exeption.NotFoundException;
import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Customer;

import madsilver.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long, CustomerRepository> implements CustomerService{
    public CustomerServiceImpl(CustomerRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Customer findByUsername(String username) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Customer foundEntity = repository.findByUsername(username).get();
            session.getTransaction().commit();
            session.close();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with %s not found", username));
        }
    }
}
