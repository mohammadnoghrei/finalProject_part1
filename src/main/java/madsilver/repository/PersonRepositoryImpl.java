package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person, Long> implements PersonRepository {
    public PersonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        Session session = SessionFactorySingleton.getInstance().openSession();

        Query query = session.createQuery("FROM Person p WHERE p.username=:username");
        query.setParameter("username", username);

        return Optional.ofNullable((Person) query.getSingleResult());
    }
}
