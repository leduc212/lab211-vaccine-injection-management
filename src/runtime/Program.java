package runtime;

import data.Menu;
import data.VaccineInjectionList;
import java.io.IOException;

/**
 *
 * @author leduc
 */
public class Program {

    public static void main(String[] args) {

        VaccineInjectionList vil = new VaccineInjectionList();

        Menu menu = new Menu();
        menu.add("=================VaccineInjectionManagement==========================");
        menu.add("1. Show information of all students");
        menu.add("2. Add student's first vaccine injection information");
        menu.add("3. Updating information of student's second vaccine injection");
        menu.add("4. Delete student vaccine injection information");
        menu.add("5. Search for injection information by studentID");
        menu.add("6. Store injection data to file");
        menu.add("7. Quit");

        int choice;
        
        try {
            vil.writeStudent();
            vil.writeVaccine();
        } catch (IOException ex) {
            System.out.println("Can't write Student list and Vaccine list to file");
        }

        do {

            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    System.out.println("=====================================================================");
                    System.out.println("You have chosen to: Show information of all students");
                    vil.printStudentList();
                    break;
                case 2:
                    vil.addInjection();
                    break;
                case 3:
                    vil.updateInjection();
                    break;
                case 4:
                    vil.removeInjection();
                    break;
                case 5:
                    vil.searchInjectionByStudentID();
                    break;
                case 6: {
                    try {
                        vil.writeToFile();
                    } catch (IOException e) {
                        System.out.println("Can't write to file!");
                    }
                }
                break;
                case 7:
                    System.out.println("Exiting...");
                    return;
            }
        } while (true);
    }
}
