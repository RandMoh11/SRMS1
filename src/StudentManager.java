
import java.util.ArrayList;

public class StudentManager {

 
    
  private ArrayList<Student> students = new ArrayList<>();

   
  
  
  public void addStudent(Student s) {
        students.add(s);
    }

    public void displayAll() {
    if (students.isEmpty()) {
            
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
      System.out.println(s);
        }
    }

    
    public boolean removeStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    public boolean updateGPA(String id, double newGpa) {
   for (Student s : students) {
     
       if (s.getId().equals(id)) {
       s.setGpa(newGpa);
      return true;
            }
        }
    return false;
    }

  
    public ArrayList<Student> getStudents() {
        return students;
    }
}
