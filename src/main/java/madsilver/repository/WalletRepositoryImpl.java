package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Admin;
import madsilver.model.Wallet;
import org.hibernate.SessionFactory;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet,Long> implements WalletRepository {
    public WalletRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return null;
    }
}
