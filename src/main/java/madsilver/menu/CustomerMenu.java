package madsilver.menu;


import madsilver.base.exeption.NotFoundException;
import madsilver.model.*;
import madsilver.service.CustomerService;
import madsilver.service.OrderService;
import madsilver.service.ServicesService;
import madsilver.service.SubServicesService;
import madsilver.utility.ApplicationContext;
import madsilver.utility.SecurityContext;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public Scanner scanner = new Scanner(System.in);

    private final OrderService orderService = ApplicationContext.getOrderService();
    private final CustomerService customerService = ApplicationContext.getCustomerService();
    private final ServicesService servicesService = ApplicationContext.getServicesService();
    private final SubServicesService subServicesService = ApplicationContext.getSubServicesService();



    public void baseCustomerMenu(){
        System.out.println("welcome to customer menu");
        System.out.println("please select one item");
        System.out.println("1,edit profile  2,change password\n" +
                "3,save order  0,Exit");
        int choose =scanner.nextInt();
        switch (choose){
            case 1->editCustomer();
            case 2->changePassword();
            case 3->saveOrder();
        }
    }

    private void editCustomer() {

    }

    public void saveCustomer() {
        System.out.println("please enter your first name:");
        String firstname = scanner.next();
        System.out.println("please enter your last name:");
        String lastname = scanner.next();
        System.out.println("please enter your nation code:");
        String nationCode = scanner.next();
        System.out.println("please enter your email:");
        String email = scanner.next();
        System.out.println("please enter your username:");
        String username = scanner.next();
        System.out.println("please enter your password:");
        String password = scanner.next();
        System.out.println("please enter your card balance ");
        double cardBalance = 0;
        try {
            cardBalance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("please enter valid price");
        }
        Customer customer= Customer.builder()
                .firstname(firstname)
                .lastname(lastname)
                .nationCode(nationCode)
                .email(email)
                .username(username)
                .password(password)
                .cardBalance(cardBalance)
                .build();

        try {
            customerService.saveOrUpdate(customer);
            SecurityContext.customer=customer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void saveOrder() {
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SubServices subServices = null;
        try {
            subServices = selectSubService(selectService());
        } catch (NotFoundException e) {
            e.getMessage();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        LocalDate date = null;
        if (subServices != null) {
            while (date == null) {
                System.out.println("Please enter date for do order (yyyy-mm-dd):");
                String input = scanner.next();
                scanner.nextLine();
                try {
                    date = LocalDate.parse(input, DATE_FORMATTER);
                    System.out.println("YOUR date is: " + date);
                } catch (DateTimeException e) {
                    System.out.println("The date entered is not valid. Please try again using the format yyyy-mm-dd.");
                }
            }
            System.out.println("the " + subServices.getName() + " base price : " + subServices.getBasePrice() + " your offer offer price should be more than base price");
            System.out.println("please enter your offer price for order");
            double price = 0;
            boolean flag = true;
            while (flag) {
                try {
                    price = scanner.nextLong();
                    scanner.nextLine();
                    if (price < subServices.getBasePrice()) {
                        System.out.println("your offer price less than base price please try again!!");
                    }else flag=false;
                } catch (InputMismatchException e) {
                    System.out.println("please enter valid price");
                }
            }
            System.out.println("please enter your address");
            String address = scanner.next();
            Customer customer=ApplicationContext.getCustomerService().findByUsername(SecurityContext.customer.getUsername());
            Order order = Order.builder()
                    .customer(customer)
                    .subServices(subServices)
                    .address(address)
                    .customerOfferPrice(price)
                    .requestedDateToDoOrder(date)
                    .orderRegisterDate(LocalDate.now())
                    .build();
            try {
                if (orderService.validate(order))
                    orderService.saveOrUpdate(order);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println("your service not found");
    }

    public Services selectService() {
        List<Services> servicesList = servicesService.findAll();
        servicesList.forEach(a -> System.out.println(a.getId() + ": " + a.getServiceName()));
        System.out.println("please select one service");
        long id = scanner.nextLong();
        scanner.nextLine();
        Services services = null;
        for (Services s : servicesList) {
            if (s.getId() == id)
                services = s;
        }
        if (services != null)
            return services;
        else throw new NotFoundException("entity not found");

    }

    public SubServices selectSubService(Services services) {
        if (services != null) {
            List<SubServices> subServicesList = subServicesService.findAllSubServicesOfaService(services);
            subServicesList.forEach(a -> System.out.println(a.getId() + ": " + a.getName()));
            System.out.println("please select one sub service");
            long id = scanner.nextLong();
            scanner.nextLine();
            SubServices subServices = null;
            for (SubServices s : subServicesList) {
                if (s.getId() == id)
                    subServices = s;
            }
            if (subServices != null)
                return subServices;
            else throw new NotFoundException("entity not found");
        }
        return null;
    }



    public void changePassword() {
        System.out.println("please enter your username");
        String username = scanner.next();
        scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.next();
        scanner.nextLine();
        Customer customer;
        try {
            customer = ApplicationContext.getCustomerService().findByUsername(username);
            if (password.equals(customer.getPassword())) {
                System.out.println("please enter new password");
                String newPassword = scanner.next();
                scanner.nextLine();
                if (newPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
                    System.out.println("please enter your new password again");
                    String newPassword2 = scanner.next();
                    scanner.nextLine();
                    if (newPassword.equals(newPassword2)) {
                        customer.setPassword(newPassword);
                        try {
                            customerService.saveOrUpdate(customer);
                            customer=SecurityContext.customer;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else System.out.println("please enter valid password");
                } else System.out.println("please enter valid password");
            } else System.out.println("please enter valid password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
