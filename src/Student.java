
import java.util.ArrayList;

public class Student extends Person {

    private String id;
    private double gpa;
 private String   department;
  private int    year;
    private ArrayList<Course> courses = new ArrayList<>();

    
    public Student(String id, String name, double gpa, String department, int year) {
        super(name);
        this.id = id;
        this.gpa = gpa;
        this.department = department;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYear(int year) {
        this.year = year;
    }


public void addCourse(Course c) {
        courses.add(c);
    }
 public void removeCourse(String courseCode) {
        courses.removeIf(c -> c.getCourseCode().equals(courseCode));
    }

 
 
 
 
   @Override
    public String toString() {
        return id + "," + name + "," + gpa + "," + department + "," + year;
    }
}
