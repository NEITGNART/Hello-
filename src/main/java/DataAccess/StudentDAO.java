package DataAccess;

import Model.Student;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    List<Student> list = new ArrayList<>();
    DAO db = DAO.getDbUtil();
    private static StudentDAO studentDAO;

    public StudentDAO() {

    }

    private String
            addStudent = "";

    private String
            findOneStudent = "select * from student where id = ?";

    private String
            addOneStudent = "insert into student values(?,?,?,?,?)";

    public static StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new StudentDAO();
        }
        return studentDAO;
    }

    void addStudent(Student student) {
        if (findOne(student.getId()) == null) {
            list.add(student);
            addStudentDB(student);
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại");
        }
    }

    public void addStudentDB(Student student) {
        Object[] params = {student.getId(), student.getFirstName(),
                student.getLastName(), student.getDob(), student.getAddress()};
        var x = db.executeUpdate(addOneStudent, params);
    }

    public Student findOne(String id) {
        Object[] params = {id};
        var x = db.executeQuery(findOneStudent, params);
        try {
            if (x.next()) {
                return new Student(x.getString(1), x.getString(2),
                        x.getString(3), x.getDate(4), x.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
