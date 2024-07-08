package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BusinessLogic.StudentServices;
import java.util.List;
import Models.Student;
import java.awt.event.*;

public class Records extends JFrame implements ActionListener {

    private JLabel BackGroundImage, PUPLogo, txtMembership, txtViewing;
    private JPanel pnlRed;
    private RoundedPanels pnlSquare1, pnlSquare2;
    private JTable table;
    private JScrollPane scrollPane;
    private JTable RecordsTable;
    private DefaultTableModel tableModel;
    private StudentServices studentServices;
    private JButton Logout, Search, SeeAll;
    private JTextField txtfldSearch;

    Records() {
        studentServices = new StudentServices();

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Viewing");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Logout = new JButton("Logout");
        Logout.setForeground(Color.white);
        Logout.setBackground(new Color(171, 34, 34));
        Logout.setFont(new Font("arimo", Font.PLAIN, 20));
        Logout.setBounds(660, 20, 200, 25);
        Logout.setBorderPainted(false);
        Logout.addActionListener(this);
        add(Logout);

        txtMembership = new JLabel("MEMBERSHIP");
        txtMembership.setForeground(Color.WHITE);
        txtMembership.setFont(new Font("impact", Font.PLAIN, 40));
        txtMembership.setBounds(100, 30, 220, 40);
        add(txtMembership);

        txtViewing = new JLabel("RECORDS");
        txtViewing.setForeground(Color.WHITE);
        txtViewing.setFont(new Font("impact", Font.PLAIN, 30));
        txtViewing.setBounds(50, 160, 220, 30);
        add(txtViewing);

        PUPLogo = new JLabel(); // Logo
        ImageIcon Logo = new ImageIcon("Images/PUPLogo.png");
        PUPLogo.setBounds(20, 15, 75, 75);
        PUPLogo.setIcon(Logo);
        Image scaledImage = Logo.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        PUPLogo.setIcon(new ImageIcon(scaledImage));
        add(PUPLogo);

        String[] columnNames = {"stud ID", "Last Name", "First Name", "Middle Name", "Course", "Year", "Address", "Contact", "Birthday", "Position", "Affiliation"};
        tableModel = new DefaultTableModel(columnNames,0);
        RecordsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(RecordsTable);
        scrollPane.setBounds(40, 270, 900, 250);
        add(scrollPane);
        RecordsTable.setEnabled(false);
        PutRecordsInTheTable();
        
        SeeAll = new JButton("View All");
        SeeAll.setForeground(new Color(171, 34, 34));
        SeeAll.setBounds(820, 220, 120, 30);
        SeeAll.setBackground(Color.white);
        SeeAll.addActionListener(this);
        add(SeeAll);

        Search = new JButton("Search");
        Search.setForeground(new Color(171, 34, 34));
        Search.setBounds(710, 220, 100, 30);
        Search.setBackground(Color.white);
        Search.addActionListener(this);
        add(Search);

        txtfldSearch = new JTextField("Input_Student_ID");
        txtfldSearch.setBounds(500, 220, 200, 30);
        add(txtfldSearch);

        pnlRed = new JPanel();
        pnlRed.setBackground(new Color(171, 34, 34));
        pnlRed.setBounds(0, 0, 1000, 100);
        add(pnlRed);

        pnlSquare1 = new RoundedPanels(40, new Color(171, 34, 34));
        pnlSquare1.setBounds(25, 150, 300, 100);
        add(pnlSquare1);

        pnlSquare2 = new RoundedPanels(40, new Color(171, 34, 34));
        pnlSquare2.setBounds(25, 200, 930, 330);
        add(pnlSquare2);

        BackGroundImage = new JLabel(); // Background
        ImageIcon backgroundPic = new ImageIcon("Images/BG.png");
        BackGroundImage.setIcon(backgroundPic);
        BackGroundImage.setSize(1000, 600);
        add(BackGroundImage);

        setVisible(true);
    }

    private void PutRecordsInTheTable() {
        List<Student> students = studentServices.GetAllStudents();

        tableModel.setRowCount(0);

        for (Student student : students) {
            tableModel.addRow(new Object[]{
                student.studID, student.lastName, student.firstName, student.middleName,
                student.course, student.yearLevel, student.address, student.contact,
                student.birthdate, student.position, student.affiliation
            });
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logout) {
            new Login();
            this.dispose();
        }else if (e.getSource() == SeeAll){
            PutRecordsInTheTable();
        } else if (e.getSource() == Search) {

            Student student = studentServices.GetStudentByID(txtfldSearch.getText().trim());
            txtfldSearch.setText("Input_Student_ID");
            tableModel.setRowCount(0); 

            if (student != null) {
                tableModel.addRow(new Object[]{
                    student.studID, student.lastName, student.firstName, student.middleName,
                    student.course, student.yearLevel, student.address, student.contact,
                    student.birthdate, student.position, student.affiliation
                });
            } else {
                JOptionPane.showMessageDialog(this, "Either not a Student_ID or Student not found", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
