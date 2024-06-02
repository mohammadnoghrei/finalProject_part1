package madsilver.connection;



import madsilver.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {}

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)

                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Expert.class)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(Offer.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Services.class)
                    .addAnnotatedClass(SubServices.class)
                    .addAnnotatedClass(Wallet.class)


                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}