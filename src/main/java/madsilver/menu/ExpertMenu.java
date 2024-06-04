package madsilver.menu;

import madsilver.model.Expert;
import madsilver.model.ExpertStatus;
import madsilver.service.ExpertService;
import madsilver.utility.ApplicationContext;

import java.io.*;
import java.util.Scanner;

public class ExpertMenu {
    private final CustomerMenu customerMenu=new CustomerMenu();
    private final ExpertService expertService= ApplicationContext.getExpertService();
    private final Scanner scanner =new Scanner(System.in);

    public  void baseExpertMenu(){}
    public void saveExpert(){
        Expert expert= (Expert) customerMenu.makePerson();
        expert.setExpertStatus(ExpertStatus.WAITING_FOR_CONFIRMATION);
        expert.setAvgScore(0);
        System.out.println("please enter your address of image");
        String imagePath=scanner.next();
        File file = new File(imagePath);
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
        }expert.setImage(bytes);
        if (expertService.validate(expert)){
            try {
                expertService.saveOrUpdate(expert);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }}else {
            System.out.println("please enter valid input **expert validation**");
        }


    }
}
