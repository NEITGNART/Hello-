package Presentation;

import javax.swing.*;

public class StudentView extends JFrame {


    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;

    public StudentView() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        panel2 = new JPanel(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel3 = new JPanel(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));


        panel4 = new JPanel(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));

        JLabel jLabel = new JLabel("demo");

        panel1.add(jLabel);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Tab 1", null, panel1, "Does nothing at all");
        tabbedPane.addTab("Tab 2", null, panel2, "Does nothing at all");
        tabbedPane.addTab("Tab 3", null, panel3, "Does nothing at all");
        tabbedPane.addTab("Tab 4", null, panel4, "Does nothing at all");


        add(tabbedPane);


        setVisible(true);
    }
}
