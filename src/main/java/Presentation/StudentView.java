package Presentation;

import DataAccess.StudentDAO;
import Model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentView extends JFrame implements ActionListener {


    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JTable table;

    JButton removeButton = new JButton();
    JButton updateButton = new JButton();

    String[] columns = new String[]{"MSSV", "Fist Name",  "Last Name" ,"Năm sinh",
            "Address",  "Xoá", "Chỉnh sửa"};

    List<Student> list = null;

    JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTextField searchField = new JTextField(40);
    JLabel searchLabel = new JLabel("Search by");
    String[] type = {"id", "name"};
    JComboBox typeBox = new JComboBox(type);


    JButton searchButton = new JButton("Tìm kiếm");

    public StudentView() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel1 = new JPanel();

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        header.add(searchLabel);
        header.add(typeBox);
        header.add(searchField);
        header.add(searchButton);

        panel1.add(header);



        JTabbedPane tabbedPane = new JTabbedPane();


        table = new JTable();
        showTable();
        JScrollPane jScrollPane = new JScrollPane(table);
        panel1.add(jScrollPane);

        panel2 = new JPanel(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        tabbedPane.addTab("Tab 1", null, panel1, "Does nothing at all");
        tabbedPane.addTab("Tab 2", null, panel2, "Does nothing at all");

        add(tabbedPane);

        setVisible(true);
    }

    public void showTable() {

        if (list == null) return;

        Object[][] data = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] =  list.get(i).getFirstName();
            data[i][2] = list.get(i).getLastName();
            data[i][3] = String.valueOf(list.get(i).getDob());
            data[i][4] = list.get(i).getAddress();
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);

        // removeButton
        table.getColumn("Xoá").setCellEditor(new ButtonEditor(new JCheckBox(), "Xoá", removeButton));
        table.getColumn("Xoá").setCellRenderer(new ButtonRenderer("Xoá"));

        // Update Button

        table.getColumn("Chỉnh sửa").setCellEditor(new ButtonEditor(new JCheckBox(), "Chỉnh sửa", updateButton));
        table.getColumn("Chỉnh sửa").setCellRenderer(new ButtonRenderer("Chỉnh sửa"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



    public void renderTable(List<Student> student) {
        Object[][] data = new String[student.size()][6];
        for (int i = 0; i < student.size(); ++i) {
            data[i][0] = student.get(i).getId();
            data[i][1] =  student.get(i).getFirstName();
            data[i][2] = student.get(i).getLastName();
            data[i][3] = String.valueOf(student.get(i).getDob());
            data[i][4] = String.valueOf(student.get(i).getAddress());
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        // removeButton
        table.getColumn("Xoá").setCellEditor(new ButtonEditor(new JCheckBox(), "Xoá", removeButton));
        table.getColumn("Xoá").setCellRenderer(new ButtonRenderer("Xoá"));
        // Update Button

        table.getColumn("Chỉnh sửa").setCellEditor(new ButtonEditor(new JCheckBox(), "Chỉnh sửa", updateButton));
        table.getColumn("Chỉnh sửa").setCellRenderer(new ButtonRenderer("Chỉnh sửa"));

    }




    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String text) {
            setText(text);
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    public void addSearchListenActioner(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void addRemoveListenActioner(ActionListener actionListener) {
        removeButton.addActionListener(actionListener);
    }

    public void addupdateListenActioner(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public String idSelected() {
        int row = table.getSelectedRow();
        return list.get(row).getId();
    }

    public String getTextSearch() {
        return searchField.getText();
    }

    public String getTypeCombobox() {
        return typeBox.getSelectedItem().toString();
    }


    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;

        public ButtonEditor(JCheckBox checkBox, String label, JButton button) {
            super(checkBox);
            this.label = label;
            this.button = button;
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            this.button.setText(label);
            return this.button;
        }

        public Object getCellEditorValue() {
            return label;
        }

    }


}
