package Presentation;

import DataAccess.StudentDAO;
import Model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    private StudentView studentView;
    StudentDAO studentDAO = StudentDAO.getStudentDAO();


    public StudentController() {
        studentView = new StudentView();
        studentView.addSearchListenActioner(new AddSearchListenActioner());
        studentView.addRemoveListenActioner(new AddRemoveListenActioner());
        studentView.addSearchListenActioner(new AddSearchListenActioner());
    }

    class AddRemoveListenActioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Remove ok");
        }
    }

    class AddUpdateListenActioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Update ok");
        }
    }


    class AddSearchListenActioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = studentView.getTextSearch();
            List<Student> list = new ArrayList<>();
            list.add(studentDAO.findOne(id));
            studentView.renderTable(list);
        }
    }
}


