package data;

import java.io.Serializable;
import java.util.Date;

public class VaccineInjection implements Serializable {

    String injectionID;
    String studentID;
    String vaccineID;
    String date1;
    String place1;
    String date2 = null;
    String place2 = null;
    boolean mui1 = false;
    boolean mui2 = false;

    //constructors
    public VaccineInjection(String injectionID, String studentID, String vaccineID, String date1, String place1, boolean mui1) {
        this.injectionID = injectionID;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.date1 = date1;
        this.place1 = place1;
        this.mui1 = mui1;
    }

    //getters&setters
    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public boolean isMui1() {
        return mui1;
    }

    public void setMui1(boolean mui1) {
        this.mui1 = mui1;
    }

    public boolean isMui2() {
        return mui2;
    }

    public void setMui2(boolean mui2) {
        this.mui2 = mui2;
    }

    //output method
    public void outputFirst() {
        System.out.printf("|%-12s|%-10s|%-10s|%-10s|%-25s|",
                getInjectionID(), getStudentID(), getVaccineID(),
                getDate1(), getPlace1());
        System.out.printf("\n");
    }

    public void outputAll() {
        String show = String.format("|%-12s|%-10s|%-10s|%-12s|%-25s|%-12s|%-25s|",
                getInjectionID(), getStudentID(), getVaccineID(),
                getDate1(), getPlace1(),getDate2(),getPlace2());
        System.out.println(show);
    }
}
