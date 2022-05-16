package data;

import java.util.ArrayList;
import java.util.Scanner;
import util.MyToys;

public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getChoice() {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                System.out.println(this.get(i));
            }
            result = MyToys.getAnInteger("Please select an operation: ", "Input a valid option(1-6), please!", 1, 7);
        }
        return result;
    }
}
