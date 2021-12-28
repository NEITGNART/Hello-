import DataAccess.DAO;
import DataAccess.StudentDAO;
import Model.Student;
import Presentation.StudentController;
import Presentation.StudentView;

import javax.swing.*;
import java.sql.Date;

public class MainClass {
    public static void main(String[] args) {
        DAO.setAttribute("jdbc:mysql://localhost:8889/qlsv", "root", "root");
        SwingUtilities.invokeLater(StudentController::new);
    }
}
