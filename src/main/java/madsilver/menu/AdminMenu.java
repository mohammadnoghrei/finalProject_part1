package madsilver.menu;

import madsilver.model.Expert;
import madsilver.model.ExpertStatus;
import madsilver.model.Services;
import madsilver.model.SubServices;
import madsilver.service.AdminService;
import madsilver.service.ExpertService;
import madsilver.service.ServicesService;
import madsilver.service.SubServicesService;
import madsilver.utility.ApplicationContext;

import java.util.*;

public class AdminMenu {
    private final CustomerMenu customerMenu = new CustomerMenu();
    private final AdminService adminService = ApplicationContext.getAdminService();
    private final ExpertService expertService = ApplicationContext.getExpertService();
    private final ServicesService servicesService = ApplicationContext.getServicesService();
    private final SubServicesService subServicesService = ApplicationContext.getSubServicesService();
    private final Scanner scanner = new Scanner(System.in);


    public void baseAdminMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("welcome to admin menu");
            System.out.println("please select one item");
            System.out.println("""
                    1,save service 2,delete service 3,edit service
                    4,save sub service  5,delete sub service 6,edit sub service  7,edit sub service price and description
                    8,confirm Expert  0,Exit""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> saveService();
                case 2 -> deleteService();
                case 3 -> editService();
                case 4 -> saveSubService();
                case 5 -> deleteSubService();
                case 6 -> editSubService();
                case 7 -> updatePriceAndDescriptionOfSubService();
                case 8 -> confirmExpert();
                case 0 -> flag=false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }


    private void editSubService() {
        SubServices oldSubServices = customerMenu.selectSubService(customerMenu.selectService());
        if (oldSubServices != null) {
            System.out.println("please enter sub service name ");
            String subServiceName = scanner.next();
            scanner.nextLine();
            oldSubServices.setName(subServiceName);
            double basePrice = 0;
            boolean flag = true;
            System.out.println("please enter base price of sub service");
            while (flag) {
                try {
                    basePrice = scanner.nextDouble();
                    if (basePrice > 0)
                        flag = false;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage() + "\n please enter valid price");
                } finally {
                    scanner.nextLine();
                }
            }oldSubServices.setBasePrice(basePrice);
            System.out.println("please enter description for this sub service:");
            String description = scanner.next();
            scanner.nextLine();
            oldSubServices.setDescription(description);
            if (subServicesService.validate(oldSubServices))
                try {
                    subServicesService.saveOrUpdate(oldSubServices);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        } else System.out.println("your service is not exist");
    }

    private void editService() {
        Services services = customerMenu.selectService();
        System.out.println("please new enter name of service ");
        String serviceName = scanner.next();
        scanner.nextLine();
        services.setServiceName(serviceName);
        try {
            servicesService.saveOrUpdate(services);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n your service is exist please enter uniq name");
        }
    }

    private void deleteSubService() {
        SubServices subServices = customerMenu.selectSubService(customerMenu.selectService());
        try {
            subServicesService.delete(subServices);
        }catch (Exception e){
            System.out.println(e.getMessage()+"\n please try again lather");
        }
    }

    private void deleteService() {
        Services services = customerMenu.selectService();
        try {
            servicesService.delete(services);
        }catch (Exception e){
            System.out.println(e.getMessage()+"\nplease try again lather");
        }
    }

    public void saveService() {
        System.out.println("please enter name of service ");
        String serviceName = scanner.next();
        scanner.nextLine();
        Services services = Services.builder().ServiceName(serviceName).build();
        try {
            servicesService.saveOrUpdate(services);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n your service is exist please enter uniq name");
        }
    }

    public void saveSubService() {
        System.out.println("please first select service for your sub service");
        Services services = customerMenu.selectService();
        if (services != null) {
            System.out.println("please enter sub service name ");
            String subServiceName = scanner.next();
            scanner.nextLine();
            double basePrice = 0;
            boolean flag = true;
            System.out.println("please enter base price of sub service");
            while (flag) {
                try {
                    basePrice = scanner.nextDouble();
                    if (basePrice > 0)
                        flag = false;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage() + "\n please enter valid price");
                } finally {
                    scanner.nextLine();
                }
            }
            System.out.println("please enter description for this sub service:");
            String description = scanner.next();
            scanner.nextLine();
            SubServices subServices = SubServices.builder().services(services).name(subServiceName)
                    .basePrice(basePrice).description(description).build();
            if (subServicesService.validate(subServices))
                try {
                    subServicesService.saveOrUpdate(subServices);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        } else System.out.println("your service is not exist");
    }

    public void updatePriceAndDescriptionOfSubService() {
        System.out.println("please first select service for your sub service");
        SubServices subServices = customerMenu.selectSubService(customerMenu.selectService());

        if (subServices != null) {
            double basePrice = 0;
            boolean flag = true;
            System.out.println("please enter new base price ");
            while (flag) {
                try {
                    basePrice = scanner.nextDouble();
                    if (basePrice > 0)
                        flag = false;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                } finally {
                    scanner.nextLine();
                }
            }
            System.out.println("please enter new description for this sub service:");
            String description = scanner.next();
            scanner.nextLine();
            subServices.setDescription(description);
            subServices.setBasePrice(basePrice);
            if (subServicesService.validate(subServices))
                try {
                    subServicesService.saveOrUpdate(subServices);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        } else System.out.println("your sub service is not exist");
    }

    public void confirmExpert() {
        List<Expert> expertList = expertService.findAllNotConfirmedExpert();
        expertList.forEach(a -> System.out.println("id:" + a.getId() + "  name and username =" + a.getFirstname() + " _ " + a.getLastname() + " _ " + a.getUsername()));
        System.out.println("please enter id for confirm expert");
        long id = 0;
        while (id == 0) {
            try {
                id = scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + "\n please enter valid id");
            }
        }
        long finalId = id;
        Optional<Expert> result = expertList.stream()
                .filter(obj -> obj.getId() == finalId).findFirst();
        Expert findExpert = result.get();
        if (result.isEmpty())
            System.out.println("please enter valid id");
        else try {
            findExpert.setExpertStatus(ExpertStatus.CONFIRMED);
            expertService.saveOrUpdate(findExpert);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "failed save please try again ");
        }
    }

}
