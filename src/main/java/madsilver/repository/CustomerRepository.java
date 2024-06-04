package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Customer;
import madsilver.model.Person;

import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
}
