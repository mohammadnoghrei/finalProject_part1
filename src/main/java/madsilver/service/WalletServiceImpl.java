package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Wallet;
import madsilver.repository.WalletRepository;
import org.hibernate.SessionFactory;

public class WalletServiceImpl extends BaseServiceImpl<Wallet,Long, WalletRepository> implements WalletService{
    public WalletServiceImpl(WalletRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
