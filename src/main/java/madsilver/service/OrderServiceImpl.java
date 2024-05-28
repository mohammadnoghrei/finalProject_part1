package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Order;
import madsilver.repository.OrderRepository;
import org.hibernate.SessionFactory;

public class OrderServiceImpl extends BaseServiceImpl<Order,Long, OrderRepository> implements OrderService{
    public OrderServiceImpl(OrderRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
