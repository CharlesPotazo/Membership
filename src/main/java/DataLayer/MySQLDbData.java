package DataLayer;

import java.sql.*;
import java.util.*;
import java.util.Date;
import Models.*;

public class MySQLDbData {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite", "root", "Charuzu03");
    }

    public List<Student> getStudents() {
        String selectStatement = "SELECT stud_ID, lastName, firstName, middleName, course, yearLevel, address, contact, position, affiliation, birthdate FROM tbl_cite";
        List<Student> students = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement selectCommand = connection.prepareStatement(selectStatement); ResultSet reader = selectCommand.executeQuery()) {

            while (reader.next()) {
                String studID = reader.getString("stud_ID");
                String lastName = reader.getString("lastName");
                String firstName = reader.getString("firstName");
                String middleName = reader.getString("middleName");
                String course = reader.getString("course");
                String yearLevel = reader.getString("yearLevel");
                String address = reader.getString("address");
                String contact = reader.getString("contact");
                String position = reader.getString("position");
                String affiliation = reader.getString("affiliation");
                Date birthdate = reader.getDate("birthdate");

                Student readStudent = new Student();
                readStudent.studID = studID;
                readStudent.lastName = lastName;
                readStudent.firstName = firstName;
                readStudent.middleName = middleName;
                readStudent.course = course;
                readStudent.yearLevel = yearLevel;
                readStudent.address = address;
                readStudent.contact = contact;
                readStudent.position = position;
                readStudent.affiliation = affiliation;
                readStudent.birthdate = birthdate;
                students.add(readStudent);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return students;
    }

    public Student addStudent(String studID, String lastName, String firstName, String middleName, String course, String yearLevel, String address, String contact, String position, String affiliation, Date birthdate) {
        String insertStatement = "INSERT INTO tbl_cite (stud_ID, lastName, firstName, middleName, course, yearLevel, address, contact, birthdate, position, affiliation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement insertCommand = connection.prepareStatement(insertStatement)) {

            insertCommand.setString(1, studID);
            insertCommand.setString(2, lastName);
            insertCommand.setString(3, firstName);
            insertCommand.setString(4, middleName);
            insertCommand.setString(5, course);
            insertCommand.setString(6, yearLevel);
            insertCommand.setString(7, address);
            insertCommand.setString(8, contact);
            insertCommand.setDate(9, new java.sql.Date(birthdate.getTime()));
            insertCommand.setString(10, position);
            insertCommand.setString(11, affiliation);

            int rowsAffected = insertCommand.executeUpdate();

            Student student = new Student();
            student.studID = studID;
            student.lastName = lastName;
            student.firstName = firstName;
            student.middleName = middleName;
            student.course = course;
            student.yearLevel = yearLevel;
            student.address = address;
            student.contact = contact;
            student.birthdate = birthdate;
            student.position = position;
            student.affiliation = affiliation;
            return student;

        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public List<Admin> getAdmin() {
        String selectStatement = "SELECT userID, lastName, firstName, middleName, userPassword FROM tbl_admin";
        List<Admin> admins = new ArrayList<Admin>();

        try (Connection connection = getConnection(); PreparedStatement selectCommand = connection.prepareStatement(selectStatement); ResultSet reader = selectCommand.executeQuery()) {

            while (reader.next()) {
                String userID = reader.getString("userID");
                String lastName = reader.getString("lastName");
                String firstName = reader.getString("firstName");
                String middleName = reader.getString("middleName");
                String userPassword = reader.getString("userPassword");

                Admin readAdmin = new Admin();
                readAdmin.userID = userID;
                readAdmin.lastName = lastName;
                readAdmin.firstName = firstName;
                readAdmin.middleName = middleName;
                readAdmin.userPassword = userPassword;

                admins.add(readAdmin);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return admins;
    }

    public Student GetStudentByID(String stud_ID) {
        String findCommand = "SELECT * FROM tbl_cite WHERE stud_ID = ?";
        Student student = null;

        try (Connection connection = getConnection(); PreparedStatement selectCommand = connection.prepareStatement(findCommand)) {

            selectCommand.setString(1, stud_ID);

            try (ResultSet reader = selectCommand.executeQuery()) {
                if (reader.next()) {
                    student = new Student();
                    student.studID = reader.getString("stud_ID");
                    student.lastName = reader.getString("lastName");
                    student.firstName = reader.getString("firstName");
                    student.middleName = reader.getString("middleName");
                    student.course = reader.getString("course");
                    student.yearLevel = reader.getString("yearLevel");
                    student.address = reader.getString("address");
                    student.contact = reader.getString("contact");
                    student.birthdate = reader.getDate("birthdate");
                    student.position = reader.getString("position");
                    student.affiliation = reader.getString("affiliation");
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return student;
    }
}
