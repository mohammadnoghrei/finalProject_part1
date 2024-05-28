package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Person;
import madsilver.repository.PersonRepository;
import org.hibernate.SessionFactory;

public class PersonServiceImpl extends BaseServiceImpl<Person,Long, PersonRepository> implements PersonService{

    public PersonServiceImpl(PersonRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
