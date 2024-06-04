package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Customer;
import madsilver.model.Person;

public interface CustomerService extends BaseService<Customer,Long> {
    Customer findByUsername(String username);
}
