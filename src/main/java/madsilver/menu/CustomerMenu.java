package madsilver.menu;

import lombok.extern.slf4j.Slf4j;
import madsilver.base.exeption.NotFoundException;
import madsilver.model.*;
import madsilver.service.CustomerService;
import madsilver.service.ServicesService;
import madsilver.service.SubServicesService;
import madsilver.utility.ApplicationContext;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public Scanner scanner = new Scanner(System.in);

    private final CustomerService customerService = ApplicationContext.getCustomerService();
    private final ServicesService servicesService = ApplicationContext.getServicesService();
    private final SubServicesService subServicesService = ApplicationContext.getSubServicesService();

    public void saveCustomer() {
        Customer customer = (Customer) makePerson();
        try {
            customerService.saveOrUpdate(customer);
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        LocalDate date=null;
        while (date == null) {
            System.out.println("Please enter date for do order (yyyy-mm-dd):");
            String input = scanner.next();
            scanner.nextLine();
            try {
                date = LocalDate.parse(input, DATE_FORMATTER);
                System.out.println("Entry date is: " + date);
            } catch (DateTimeException e) {
                System.out.println("The date entered is not valid. Please try again using the format yyyy-mm-dd.");
            }
        }
        System.out.println("please enter your offer price for order");
        double price = 0;
        boolean flag=true;
        while (flag){
        try {
            price=scanner.nextLong();
            scanner.nextLine();
            if (price<subServices.getBasePrice())
                System.out.println("your offer price less than base price please try again!!");
            else flag=false;
        }catch (InputMismatchException e){
            System.out.println("please enter valid price");
        }
        }
        System.out.println("please enter your address");
        String address=scanner.next();
        Order order=Order.builder()
                .subServices(subServices)
                .address(address)
                .customerOfferPrice(price)
                .orderRegisterDate(LocalDate.now())
                .build();


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
        return services;
//        if (services != null)
//            return services;
//        else throw new NotFoundException(String.format("entity not found"));

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
            else new NotFoundException(String.format("entity not found"));
        }
        return null;
    }

    public static Person makePerson() {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("please enter your :");

        Person person = Person.builder()
                .firstname(firstname)
                .lastname(lastname)
                .nationCode(nationCode)
                .email(email)
                .username(username)
                .password(password)
                .build();
        return person;
    }


}
