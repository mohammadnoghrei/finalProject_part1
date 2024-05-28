package madsilver.service;

import madsilver.base.service.BaseServiceImpl;

import madsilver.model.Offer;

import madsilver.repository.OfferRepository;
import org.hibernate.SessionFactory;

public class OfferServiceImpl extends BaseServiceImpl<Offer,Long, OfferRepository> implements OfferService{
    public OfferServiceImpl(OfferRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
