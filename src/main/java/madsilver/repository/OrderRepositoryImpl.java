package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import madsilver.model.Order;
import org.hibernate.SessionFactory;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order,Long> implements OrderRepository{
    public OrderRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Order> getEntityClass() {
        return null;
    }
}
