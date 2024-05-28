package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Person;
import org.hibernate.SessionFactory;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person,Long> implements PersonRepository{
    public PersonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
