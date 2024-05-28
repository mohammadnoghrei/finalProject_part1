package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import madsilver.model.Expert;
import org.hibernate.SessionFactory;

public class ExpertRepositoryImpl extends BaseRepositoryImpl<Expert,Long> implements ExpertRepository{
    public ExpertRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
