package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import util.MyToys;

/**
 *
 * @author leduc
 */
public class VaccineInjectionList {

    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Vaccine> vaccineList = new ArrayList<>();
    ArrayList<VaccineInjection> vaccineInjectionList = new ArrayList<>();

    //Tim student theo ID tra ve object
    public Student searchStudentObjectByID(String ID) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Student o : studentList) {
            if (o.getId().equalsIgnoreCase(ID)) {
                return o;
            }
        }
        return null;
    }

    //Tim vaccine theo ID tra ve object
    public Vaccine searchVaccineObjectByID(String ID) {
        if (vaccineList.isEmpty()) {
            return null;
        }
        for (Vaccine o : vaccineList) {
            if (o.getId().equalsIgnoreCase(ID)) {
                return o;
            }
        }
        return null;
    }

    //Tim vaccine injection theo ID tra ve object
    public VaccineInjection searchInjectionObjectByID(String ID) {
        if (vaccineInjectionList.isEmpty()) {
            return null;
        }
        for (VaccineInjection o : vaccineInjectionList) {
            if (o.getInjectionID().equalsIgnoreCase(ID)) {
                return o;
            }
        }
        return null;
    }

    //Xuat danh sach sinh vien
    public void writeStudent() throws FileNotFoundException, IOException {
        String filename = "student.dat";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            studentList.add(new Student("SE161422", "Le Minh Duc"));
            studentList.add(new Student("SE161423", "Nguyen Huynh Tuan"));
            studentList.add(new Student("SE161325", "Tran Le Trong Nhan"));
            studentList.add(new Student("SE161728", "Nguyen Trong Khang"));
            studentList.add(new Student("SE161829", "Ho Hai Dang"));
            studentList.add(new Student("SE151486", "Huynh Huu Dat"));
            studentList.add(new Student("SE152315", "Bui Trong Dung"));
            studentList.add(new Student("SE144521", "Lai Minh Huyen"));
            studentList.add(new Student("SE141543", "Ha Tieu Phu"));
            oos.writeObject(studentList);
            oos.close();
        } catch (IOException e) {
            System.out.println("Can't write Student list to file!");
        }
    }

    //Xuat danh sach vac xin
    public void writeVaccine() throws FileNotFoundException, IOException {
        String filename = "vaccine.dat";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            vaccineList.add(new Vaccine("Covid-V001", "Astra Zeneca"));
            vaccineList.add(new Vaccine("Covid-V002", "Sputnik V"));
            vaccineList.add(new Vaccine("Covid-V003", "Verocell"));
            vaccineList.add(new Vaccine("Covid-V004", "Pfizer"));
            vaccineList.add(new Vaccine("Covid-V005", "Moderna"));
            oos.writeObject(vaccineList);
            oos.close();
        } catch (IOException e) {
            System.out.println("Can't write Vaccine list to file!");
        }
    }

    //1. Show student information
    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty. Nothing to print");
            return;
        }

        String header = String.format("|%-10s|%-25s|", "ID", "Name");
        System.out.println(header);
        System.out.println("--------------------------------------");
        for (Student o : studentList) {
            String show = String.format("|%-10s|%-25s|", o.getId(), o.getName());
            System.out.println(show);
        }
    }

    public void printVaccineList() {
        System.out.println("Vaccine list:");
        if (vaccineList.isEmpty()) {
            System.out.println("The vaccine list is empty. Nothing to print");
            return;
        }

        String header = String.format("|%-10s|%-25s|", "ID", "Name");
        System.out.println(header);
        System.out.println("--------------------------------------");
        for (Vaccine o : vaccineList) {
            String show = String.format("|%-10s|%-25s|", o.getId(), o.getName());
            System.out.println(show);
        }
    }

    //2. Add new injection
    public void addInjection() {
        System.out.println("=====================================================================");
        System.out.println("You have chosen to: Add student's first vaccine injection information");
        while (true) {
            String injectionID;
            String studentID;
            String vaccineID;
            String date1;
            String place1;
            boolean mui1;

            do {
                injectionID = MyToys.getString("Input injection's ID:", "Injection ID cannot be a null!").toUpperCase();
                if (searchInjectionObjectByID(injectionID) != null) {
                    System.out.println("This injection ID has already existed! "
                            + "Input another one!");
                }
            } while (searchInjectionObjectByID(injectionID) != null);

            //Enter student ID
            boolean flag;
            do {
                flag = false;
                studentID = MyToys.getString("Input student's ID:", "Student ID cannot be a null!").toUpperCase();
                if (searchStudentObjectByID(studentID) == null) {
                    System.out.println("This student is not in the list! "
                            + "Input another one!");
                    flag = true;
                }
                for (VaccineInjection o : vaccineInjectionList) {
                    if (o.getStudentID().equalsIgnoreCase(studentID)) {
                        System.out.println("This student has already have an injection profile! Please choose another student ID!");
                        flag = true;
                    }
                }
            } while (flag);

            //Enter vaccine ID
            printVaccineList();
            do {
                vaccineID = MyToys.getString("Input vaccine's ID:", "Vaccine ID cannot be a null!").toUpperCase();
                if (searchVaccineObjectByID(vaccineID) == null) {
                    System.out.println("This vaccine is not in the list! "
                            + "Input another one!");
                }
            } while (searchVaccineObjectByID(vaccineID) == null);

            //Dien date
            date1 = MyToys.getDate("Input first injection date: (dd/mm/yyyy)", "Invalid date!(dd/mm/yyyy)");
            place1 = MyToys.getString("Input first injection place: ", "Place cannot be a null!");
            mui1 = true;
            vaccineInjectionList.add(new VaccineInjection(injectionID, studentID, vaccineID, date1, place1, mui1));
            System.out.println("A new injection profile has been added successfully.");
            String ans = MyToys.getId("Do you want to add another injection profile? (Y/N)", "Answer cannot be null",
                    "Answer must be Y or N", "^[Y|N|y|n]$");
            if (ans.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    //3. Update injection information

    public void updateInjection() {
        System.out.println("=====================================================================");
        System.out.println("You have chosen to: Updating information of student's second vaccine injection");

        String injectionID;
        String date2;
        String place2;

        injectionID = MyToys.getString("Input injection's ID:", "Injection ID cannot be a null!");
        VaccineInjection injection = searchInjectionObjectByID(injectionID);

        if (injection == null) {
            System.out.println("The injection with this ID is not found!");
        } else {
            if (injection.mui2 == true) {
                System.out.println("This student has already done 2 injections!");
                return;
            } else if (injection.mui1 == false) {
                System.out.println("This student hasn't finish first injection!");
                return;
            }
            //Show first injection
            System.out.println("Here is the information of this injection: ");
            System.out.printf("|%-12s|%-10s|%-10s|%-10s|%-25s|",
                    "InjectionID", "StudentID", "VaccineID", "First date", "First place");
            System.out.printf("\n");
            System.out.println("-------------------------------------------------------------------------");
            injection.outputFirst();

            //Input second injection
            System.out.println("You are required to input second injection information!");
            do {
                date2 = MyToys.getDate("Input second injection date: (dd/mm/yyyy)", "Invalid date!(dd/mm/yyyy)");
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                Date d1 = null, d2 = null;
                try {
                    d1 = formatter1.parse(injection.getDate1());
                    d2 = formatter1.parse(date2);
                } catch (ParseException ex) {
                    System.out.println("Wrong date format!");
                }

                long diffInMillies = Math.abs(d2.getTime() - d1.getTime());
                int diffInDays = Math.toIntExact(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
                if (diffInDays  < 28 || diffInDays  > 84) {
                    System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection!");
                } else {
                    break;
                }
            } while (true);
            place2 = MyToys.getString("Input second injection place: ", "Place cannot be a null!");

            injection.setDate2(date2);
            injection.setPlace2(place2);
            injection.setMui2(true);

            System.out.println("Second injection info has been updated successfully!");
        }
    }

    //4. Delete student vaccine injection information
    public void removeInjection() {
        System.out.println("=====================================================================");
        System.out.println("You have chosen to: Delete student vaccine injection information");
        String id;
        id = MyToys.getString("Input injection's ID:", "ID cannot be a null!");

        if (searchInjectionObjectByID(id) != null) {
            System.out.println("Profile found: ");
            String header = String.format("|%-12s|%-10s|%-10s|%-12s|%-25s|%-12s|%-25s|",
                    "InjectionID", "StudentID", "VaccineID", "First date", "First place", "Second date", "Second place");
            System.out.println(header);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            searchInjectionObjectByID(id).outputAll();

            String confirmation = MyToys.getId("Are you sure you want to remove this injection profile? (Y/N)", "Answer cannot be null",
                    "Answer must be Y or N", "^[Y|N|y|n]$");
            if (confirmation.equalsIgnoreCase("Y")) {
                vaccineInjectionList.remove(searchInjectionObjectByID(id));
                System.out.println("Injection profile removed successfully!");
            } else {
                System.out.println("Injection profile removal denied!");
                return;
            }
        } else {
            System.out.println("Injection profile not found");
        }
    }

    //5. Search for injection information by studentID
    public void searchInjectionByStudentID() {
        System.out.println("=====================================================================");
        System.out.println("You have chosen to: Search for injection information by studentID");
        String studentID;
        studentID = MyToys.getString("Input student's ID: ", "ID cannot be a null!");
        int count = 0;

        for (VaccineInjection o : vaccineInjectionList) {
            if (o.getStudentID().equalsIgnoreCase(studentID)) {
                count++;
                if (count == 1) {
                    String header = String.format("|%-12s|%-10s|%-10s|%-12s|%-25s|%-12s|%-25s|",
                            "InjectionID", "StudentID", "VaccineID", "First date", "First place", "Second date", "Second place");
                    System.out.println(header);
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                }
                o.outputAll();
            }
        }
        if (count == 0) {
            System.out.println("The injection profile with this student ID does not exist!");
        }
    }

    //6. Store injection data to file
    public void writeToFile() throws FileNotFoundException, IOException {
        System.out.println("=====================================================================");
        System.out.println("You have chosen to: Store injection data to file");
        if (vaccineInjectionList.isEmpty()) {
            System.out.println("The injection list is empty. Nothing to write!");
            return;
        }

        String filename = "injection.dat";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vaccineInjectionList);
            oos.close();
            System.out.println("Write to file \"injection.dat\" successfully!");
        } catch (IOException e) {
            System.out.println("Can't write to file!");
        }
    }
}
