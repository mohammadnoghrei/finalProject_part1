package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import madsilver.model.Offer;
import org.hibernate.SessionFactory;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer,Long> implements OfferRepository{
    public OfferRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }
}
