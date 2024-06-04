package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Person;

import java.util.Optional;

public interface PersonService extends BaseService<Person,Long> {
    Person findByUsername(String username);
}
