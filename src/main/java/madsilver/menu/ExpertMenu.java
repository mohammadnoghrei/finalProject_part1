package madsilver.menu;


import madsilver.model.Expert;
import madsilver.model.ExpertStatus;
import madsilver.service.ExpertService;
import madsilver.utility.ApplicationContext;
import madsilver.utility.SecurityContext;

import java.io.*;
import java.util.Scanner;

public class ExpertMenu {

    private final ExpertService expertService = ApplicationContext.getExpertService();
    private final Scanner scanner = new Scanner(System.in);

    public void baseExpertMenu() {
        System.out.println("in next session of project expert can choose offer and do orders ");
        System.out.println("you can just change your password do you want it?(y/n)");
        String choose=scanner.next();
        scanner.nextLine();
        if (choose.toLowerCase().equals("y"))
            changePassword();
        else System.out.println("please enter valid value");
    }

    public void saveExpert() {
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
        System.out.println("please enter your address of image");
        String imagePath = scanner.next();
        byte[] image = saveImage(imagePath);
        Expert expert = Expert.builder()
                .firstname(firstname)
                .lastname(lastname)
                .nationCode(nationCode)
                .email(email)
                .username(username)
                .password(password)
                .expertStatus(ExpertStatus.WAITING_FOR_CONFIRMATION)
                .image(image)
                .avgScore(0)
                .cardBalance(0)
                .build();
        if (expertService.validate(expert)) {
            try {
                expertService.saveOrUpdate(expert);
                SecurityContext.expert = expert;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("please enter valid input **expert validation**");
        }
    }

    public byte[] saveImage(String path) {
        File file1 = new File(path);
        if (isJPEG(new File(path)) && file1.length() < 300000) {
            File file = new File(path);
            InputStream is = null;
            try {
                is = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            byte[] bytes = new byte[(int) file.length()];
            try {
                is.read(bytes);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return bytes;
        }

        return null;
    }

    private Boolean isJPEG(File filename) {
        boolean flag = false;
        DataInputStream ins;
        try {
            ins = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            flag = ins.readInt() == 0xffd8ffe0;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ins.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return flag;
    }

    public void changePassword() {
        System.out.println("please enter your username");
        String username = scanner.next();
        scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.next();
        scanner.nextLine();
        Expert expert;
        try {
            expert = ApplicationContext.getExpertService().findByUsername(username);
            if (password.equals(expert.getPassword())) {
                System.out.println("please enter new password");
                String newPassword = scanner.next();
                scanner.nextLine();
                if (newPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
                    System.out.println("please enter your new password again");
                    String newPassword2 = scanner.next();
                    scanner.nextLine();
                    if (newPassword.equals(newPassword2)) {
                        expert.setPassword(newPassword);
                        try {
                            expertService.saveOrUpdate(expert);
                            expert = SecurityContext.expert;
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
