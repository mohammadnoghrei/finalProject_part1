package madsilver.repository;

import madsilver.base.repository.BaseRepository;

import madsilver.model.Person;

import java.util.Optional;

public interface PersonRepository extends BaseRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
}
