package data;

import java.io.Serializable;

public class Student implements Serializable {
    String id;
    String name;
    
    //constructors
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    //getters&setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
