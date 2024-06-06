package madsilver.menu;

import madsilver.model.*;
import madsilver.utility.ApplicationContext;
import madsilver.utility.SecurityContext;

import java.util.Scanner;

public class BaseMenu {

    private final AdminMenu adminMenu = new AdminMenu();
    private final CustomerMenu customerMenu = new CustomerMenu();
    private final ExpertMenu expertMenu = new ExpertMenu();
    public Scanner scanner = new Scanner(System.in);

    public void signIn() {
        System.out.println("***********  WELCOME  **********");
        System.out.println();
        System.out.println("please enter your username:");
        String username = scanner.next();

        System.out.println("please enter your password:");
        String password = scanner.next();

        Person person = null;
        try {
            person = ApplicationContext.getPersonService().findByUsername(username);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (person == null) {
            System.out.println("please enter valid userName or password");
        } else if (!person.getPassword().equals(password)) {
            System.out.println("please enter valid userName or passWord");
        } else if (Customer.class == person.getClass()) {
            SecurityContext.customer = (Customer) person;
            customerMenu.baseCustomerMenu();
        } else if (Expert.class == person.getClass()) {
            Expert expert = ApplicationContext.getExpertService().findById(person.getId());
            if (expert.getExpertStatus().equals(ExpertStatus.CONFIRMED)) {
                SecurityContext.expert = expert;
                expertMenu.baseExpertMenu();
            }else System.out.println("you are not confirmed");
        } else if (Admin.class == person.getClass()) {
            SecurityContext.admin = (Admin) person;
            adminMenu.baseAdminMenu();
        }
    }
    public void baseMenu(){
        System.out.println("""
                welcome to system\s
                 please select one item
                 1,singIn  2,register""");
        int choose=scanner.nextInt();
        switch (choose){
            case 1-> signIn();
            case 2-> registerPerson();
        }
    }

    private void registerPerson() {
        System.out.println(" please select one item\n" +
                " 1,customer  2,expert");
        int choose=scanner.nextInt();
        switch (choose){
            case 1 -> {
                customerMenu.saveCustomer();
                customerMenu.baseCustomerMenu();
            }
            case 2 -> {
                expertMenu.saveExpert();
                System.out.println("welcome to system please waiting for confirm");
            }
        }
    }
}
