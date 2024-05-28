package madsilver.utility;

import madsilver.connection.SessionFactorySingleton;
import madsilver.repository.*;
import madsilver.service.*;
import org.hibernate.SessionFactory;

public class ApplicationContext {
    static final SessionFactory SESSION_FACTORY;

    private static final AdminRepository ADMIN_REPOSITORY;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private static final ExpertRepository EXPERT_REPOSITORY;
    private static final PersonRepository PERSON_REPOSITORY;
    private static final ServicesRepository SERVICES_REPOSITORY;
    private static final SubServicesRepository SUB_SERVICES_REPOSITORY;
    private static final CommentRepository COMMENT_REPOSITORY;
    private static final OfferRepository OFFER_REPOSITORY;
    private static final OrderRepository ORDER_REPOSITORY;
    private static final WalletRepository WALLET_REPOSITORY;



    private static final AdminService ADMIN_SERVICE;
    private static final CustomerService CUSTOMER_SERVICE;
    private static final ExpertService EXPERT_SERVICE;
    private static final PersonService PERSON_SERVICE;
    private static final ServicesService SERVICES_SERVICE;
    private static final SubServicesService SUB_SERVICES_SERVICE;
    private static final CommentService COMMENT_SERVICE;
    private static final OfferService OFFER_SERVICE;
    private static final OrderService ORDER_SERVICE;
    private static final WalletService WALLET_SERVICE;

    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        ADMIN_REPOSITORY =new AdminRepositoryImpl(SESSION_FACTORY);
        CUSTOMER_REPOSITORY =new CustomerRepositoryImpl(SESSION_FACTORY);
        EXPERT_REPOSITORY =new ExpertRepositoryImpl(SESSION_FACTORY);
        PERSON_REPOSITORY = new PersonRepositoryImpl(SESSION_FACTORY);
        SERVICES_REPOSITORY =new ServicesRepositoryImpl(SESSION_FACTORY);
        SUB_SERVICES_REPOSITORY =new SubServiceRepositoryImpl(SESSION_FACTORY);
        COMMENT_REPOSITORY =new CommentRepositoryImpl(SESSION_FACTORY);
        OFFER_REPOSITORY =new OfferRepositoryImpl(SESSION_FACTORY);
        ORDER_REPOSITORY =new OrderRepositoryImpl(SESSION_FACTORY);
        WALLET_REPOSITORY =new WalletRepositoryImpl(SESSION_FACTORY);


        ADMIN_SERVICE =new AdminServiceImpl(ADMIN_REPOSITORY,SESSION_FACTORY);
        CUSTOMER_SERVICE =new CustomerServiceImpl(CUSTOMER_REPOSITORY,SESSION_FACTORY);
        EXPERT_SERVICE = new ExpertServiceImpl(EXPERT_REPOSITORY,SESSION_FACTORY);
        PERSON_SERVICE = new PersonServiceImpl(PERSON_REPOSITORY,SESSION_FACTORY);
        SERVICES_SERVICE =new ServicesServiceImpl(SERVICES_REPOSITORY,SESSION_FACTORY);
        SUB_SERVICES_SERVICE =new SubServicesServiceImpl(SUB_SERVICES_REPOSITORY,SESSION_FACTORY);
        COMMENT_SERVICE =new CommentServicesImpl(COMMENT_REPOSITORY,SESSION_FACTORY);
        OFFER_SERVICE =new OfferServiceImpl(OFFER_REPOSITORY,SESSION_FACTORY);
        ORDER_SERVICE =new OrderServiceImpl(ORDER_REPOSITORY,SESSION_FACTORY);
        WALLET_SERVICE =new WalletServiceImpl(WALLET_REPOSITORY,SESSION_FACTORY);

    }


    public static AdminService getAdminService(){return ADMIN_SERVICE;}
    public static CustomerService getCustomerService(){return CUSTOMER_SERVICE;}
    public static ExpertService getExpertService(){return EXPERT_SERVICE;}
    public static PersonService getPersonService(){return PERSON_SERVICE;}
    public static ServicesService getServicesService(){return SERVICES_SERVICE;}
    public static SubServicesService getSubServicesService(){return SUB_SERVICES_SERVICE;}
    public static CommentService getCommentService(){return COMMENT_SERVICE;}
    public static OfferService getOfferService(){return OFFER_SERVICE;}
    public static OrderService getOrderService(){return ORDER_SERVICE;}
    public static WalletService getWalletService(){return WALLET_SERVICE;}
}
