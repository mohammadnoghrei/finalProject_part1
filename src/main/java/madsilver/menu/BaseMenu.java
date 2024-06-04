package madsilver.menu;

import madsilver.model.Admin;
import madsilver.model.Customer;
import madsilver.model.Expert;
import madsilver.model.Person;
import madsilver.utility.ApplicationContext;
import madsilver.utility.SecurityContext;

import java.util.Scanner;

public class BaseMenu {

    private final AdminMenu adminMenu = new AdminMenu();
    private final CustomerMenu customerMenu = new CustomerMenu();
    private final ExpertMenu expertMenu = new ExpertMenu();
    public Scanner scanner = new Scanner(System.in);

    public void baseMenu() {
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
            customerMenu.baseCustomerMenu();
            SecurityContext.customer = (Customer) person;
        } else if (Expert.class == person.getClass()) {
            expertMenu.baseExpertMenu();
            SecurityContext.expert = (Expert) person;
        } else if (Admin.class == person.getClass()) {
            adminMenu.baseAdminMenu();
            SecurityContext.admin = (Admin) person;
        }
    }
}
