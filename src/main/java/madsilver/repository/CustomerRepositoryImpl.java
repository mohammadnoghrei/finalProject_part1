package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Customer;
import madsilver.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer,Long> implements CustomerRepository{
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        Session session = SessionFactorySingleton.getInstance().openSession();

        Query query = session.createQuery("FROM Person p WHERE p.username=:username");
        query.setParameter("username", username);

        return Optional.ofNullable((Customer) query.getSingleResult());
    }
}

