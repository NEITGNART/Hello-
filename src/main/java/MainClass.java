import DataAccess.DAO;
import DataAccess.StudentDAO;
import Model.Student;
import Presentation.StudentView;

import javax.swing.*;
import java.sql.Date;

public class MainClass {
    public static void main(String[] args) {
        DAO.setAttribute("jdbc:mysql://localhost:8889/qlsv", "root", "root");
//        StudentDAO.getStudentDAO().addStudentDB(new Student("1", "1", "1", Date.valueOf("2020-01-01"), "1"));
        SwingUtilities.invokeLater(StudentView::new);
    }
}
