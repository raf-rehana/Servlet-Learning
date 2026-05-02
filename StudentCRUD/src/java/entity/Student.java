
package entity;

public class Student {
    private int id;
    private String name;
    private String studentClass;
    private String roll;

    public Student() {
    }

    public Student(String name, String studentClass, String roll) {
        this.name = name;
        this.studentClass = studentClass;
        this.roll = roll;
    }

    public Student(int id, String name, String studentClass, String roll) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.roll = roll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
    
    
    

}