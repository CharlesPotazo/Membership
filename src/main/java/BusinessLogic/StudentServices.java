package BusinessLogic;

import DataLayer.MySQLDbData;
import java.util.*;
import Models.Student;

public class StudentServices {

    private MySQLDbData studentData;

    public StudentServices() {
        this.studentData = new MySQLDbData();
    }

    public List<Student> GetAllStudents() {
        return studentData.getStudents();
    }
    
    public Student GetStudentByID(String Stud_ID) {
        return studentData.GetStudentByID(Stud_ID);
    }

    public boolean addStudent(String studID, String lastName, String firstName, String middleName, String course, String yearLevel, String address, String contact, String position, String affiliation, Date birthdate) {
      
        Student addedStudent = studentData.addStudent(studID, lastName, firstName, middleName, course, yearLevel, address, contact, position, affiliation, birthdate);
        return addedStudent != null; 
    }

}
