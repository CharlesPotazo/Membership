package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import BusinessLogic.StudentServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Register extends JFrame implements ActionListener {

    private JLabel BackGroundImage, PUPLogo, txtBirthday, txtPassword, txtRegistration, txtStudNum, txtFirstN, txtMiddleN, txtLastN, txtContact, txtAddress, txtPosition, txtCourse, txtAffiliation, txtYear , message1, message2, message3;
    private RoundedPanels pnlWhite1, pnlWhite2;
    private JTextField txtfldBirthday, txtfldPassword, txtfldCourse, txtfldStudNum, txtfldFirstN, txtfldMiddleN, txfldLastN, txtfldContact, txtfldAddress, txtfldPosition, txtfldAffiliation, txtfldYear;
    private JButton btnRegister, btnLogin;
    private StudentServices studentService = new StudentServices();

    Register() {

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Register");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtRegistration = new JLabel("REGISTRATION");
        txtRegistration.setForeground(new Color(171, 34, 34));
        txtRegistration.setFont(new Font("impact", Font.PLAIN, 50));
        txtRegistration.setBounds(130, 65, 300, 50);
        add(txtRegistration);

        PUPLogo = new JLabel(); //Logo
        ImageIcon Logo = new ImageIcon("Images/PUPLogo.png");
        PUPLogo.setBounds(60, 58, 65, 65);
        PUPLogo.setIcon(Logo);
        Image scaledImage = Logo.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        PUPLogo.setIcon(new ImageIcon(scaledImage));
        add(PUPLogo);
        //------------------------------------------------------------------
        txtStudNum = new JLabel("Student Number:");
        txtStudNum.setForeground(new Color(171, 34, 34));
        txtStudNum.setFont(new Font("impact", Font.PLAIN, 25));
        txtStudNum.setBounds(70, 160, 180, 25);
        add(txtStudNum);

        txtfldStudNum = new JTextField();
        txtfldStudNum.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldStudNum.setBounds(280, 160, 200, 25);
        add(txtfldStudNum);

        //------------------------------------------------------------------
        txtFirstN = new JLabel("First Name:");
        txtFirstN.setForeground(new Color(171, 34, 34));
        txtFirstN.setFont(new Font("impact", Font.PLAIN, 25));
        txtFirstN.setBounds(70, 210, 180, 25);
        add(txtFirstN);

        txtfldFirstN = new JTextField();
        txtfldFirstN.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldFirstN.setBounds(280, 210, 200, 25);
        add(txtfldFirstN);

        txtPosition = new JLabel("Position:");
        txtPosition.setForeground(new Color(171, 34, 34));
        txtPosition.setFont(new Font("impact", Font.PLAIN, 25));
        txtPosition.setBounds(520, 210, 180, 25);
        add(txtPosition);

        txtfldPosition = new JTextField();
        txtfldPosition.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldPosition.setBounds(650, 210, 200, 25);
        add(txtfldPosition);
        //------------------------------------------------------------------
        txtMiddleN = new JLabel("Middle Name:");
        txtMiddleN.setForeground(new Color(171, 34, 34));
        txtMiddleN.setFont(new Font("impact", Font.PLAIN, 25));
        txtMiddleN.setBounds(70, 260, 180, 25);
        add(txtMiddleN);

        txtfldMiddleN = new JTextField();
        txtfldMiddleN.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldMiddleN.setBounds(280, 260, 200, 25);
        add(txtfldMiddleN);

        txtContact = new JLabel("Contact:");
        txtContact.setForeground(new Color(171, 34, 34));
        txtContact.setFont(new Font("impact", Font.PLAIN, 25));
        txtContact.setBounds(520, 260, 180, 25);
        add(txtContact);

        txtfldContact = new JTextField();
        txtfldContact.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldContact.setBounds(650, 260, 200, 25);
        add(txtfldContact);
        //--------------------------------------------------------------
        txtLastN = new JLabel("Last Name:");
        txtLastN.setForeground(new Color(171, 34, 34));
        txtLastN.setFont(new Font("impact", Font.PLAIN, 25));
        txtLastN.setBounds(70, 310, 180, 25);
        add(txtLastN);

        txfldLastN = new JTextField();
        txfldLastN.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txfldLastN.setBounds(280, 310, 200, 25);
        add(txfldLastN);

        txtAffiliation = new JLabel("Affiliation:");
        txtAffiliation.setForeground(new Color(171, 34, 34));
        txtAffiliation.setFont(new Font("impact", Font.PLAIN, 25));
        txtAffiliation.setBounds(520, 310, 180, 25);
        add(txtAffiliation);

        txtfldAffiliation = new JTextField();
        txtfldAffiliation.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldAffiliation.setBounds(650, 310, 200, 25);
        add(txtfldAffiliation);
        //--------------------------------------------------------------

        txtBirthday = new JLabel("Birthday:");
        txtBirthday.setForeground(new Color(171, 34, 34));
        txtBirthday.setFont(new Font("impact", Font.PLAIN, 25));
        txtBirthday.setBounds(70, 360, 180, 25);
        add(txtBirthday);

        txtfldBirthday = new JTextField();
        txtfldBirthday.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldBirthday.setBounds(280, 360, 200, 25);
        add(txtfldBirthday);
        
        message1 = new JLabel("Format: yyyy-mm-dd");
        message1.setForeground(new Color(253, 190, 2));
        message1.setSize(200, 10);
        message1.setBounds(280, 385, 200, 18);
        add(message1);

        txtYear = new JLabel("Year:");
        txtYear.setForeground(new Color(171, 34, 34));
        txtYear.setFont(new Font("impact", Font.PLAIN, 25));
        txtYear.setBounds(520, 360, 180, 25);
        add(txtYear);

        txtfldYear = new JTextField();
        txtfldYear.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldYear.setBounds(650, 360, 200, 25);
        add(txtfldYear);
        
        message2 = new JLabel("Word File:Ex. Second year");
        message2.setForeground(new Color(253, 190, 2));
        message2.setSize(200, 10);
        message2.setBounds(650, 385, 200, 18);
        add(message2);

        //--------------------------------------------------------------
        txtAddress = new JLabel("Address:");
        txtAddress.setForeground(new Color(171, 34, 34));
        txtAddress.setFont(new Font("impact", Font.PLAIN, 25));
        txtAddress.setBounds(70, 410, 180, 25);
        add(txtAddress);

        txtfldAddress = new JTextField();
        txtfldAddress.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldAddress.setBounds(280, 410, 200, 25);
        add(txtfldAddress);

        message3 = new JLabel("City Place Ex. Binan City");
        message3.setForeground(new Color(253, 190, 2));
        message3.setSize(200, 10);
        message3.setBounds(280, 435, 200, 18);
        add(message3);
        
        txtCourse = new JLabel("Course:");
        txtCourse.setForeground(new Color(171, 34, 34));
        txtCourse.setFont(new Font("impact", Font.PLAIN, 25));
        txtCourse.setBounds(520, 410, 180, 25);
        add(txtCourse);

        txtfldCourse = new JTextField();
        txtfldCourse.setBorder(BorderFactory.createLineBorder(new Color(171, 34, 34)));
        txtfldCourse.setBounds(650, 410, 200, 25);
        add(txtfldCourse);

        //------------------------------------------------------------------------
        btnRegister = new JButton("Register");
        btnRegister.setBackground(new Color(171, 34, 34));
        btnRegister.setForeground(Color.white);
        btnRegister.setFont(new Font("impact", Font.PLAIN, 25));
        btnRegister.setBounds(400, 470, 150, 25);
        add(btnRegister);

        btnLogin = new JButton("Return to Login Page");
        btnLogin.setBackground(new Color(171, 34, 34));
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(new Font("impact", Font.PLAIN, 15));
        btnLogin.setBounds(600, 500, 200, 20);
        add(btnLogin);

        pnlWhite1 = new RoundedPanels(40, Color.white);
        pnlWhite1.setBounds(50, 50, 380, 100);
        add(pnlWhite1);

        pnlWhite2 = new RoundedPanels(40, Color.white);
        pnlWhite2.setBounds(50, 120, 880, 410);
        add(pnlWhite2);

        BackGroundImage = new JLabel(); //Background
        ImageIcon backgroundPic = new ImageIcon("Images/BG.png");
        BackGroundImage.setIcon(backgroundPic);
        BackGroundImage.setSize(1000, 600);
        this.add(BackGroundImage);

        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            registerStudent();
        }else if (e.getSource() == btnLogin) {
            new Login();
            this.dispose();
        }
        
        
        
    }

    private void registerStudent() {
        String studID = txtfldStudNum.getText().trim();
        String firstName = txtfldFirstN.getText().trim();
        String middleName = txtfldMiddleN.getText().trim();
        String lastName = txfldLastN.getText().trim();
        String course = txtfldCourse.getText().trim();
        String yearLevel = txtfldYear.getText().trim();
        String address = txtfldAddress.getText().trim();
        String contact = txtfldContact.getText().trim();
        String position = txtfldPosition.getText().trim();
        String affiliation = txtfldAffiliation.getText().trim();
        String birthDay = txtfldBirthday.getText().trim();

        if (studID.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || yearLevel.isEmpty() || address.isEmpty() || contact.isEmpty() || position.isEmpty() || affiliation.isEmpty() || birthDay == null) {
            JOptionPane.showMessageDialog(this, "There is a missing field that requires to fill out", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date birthday = parseDate(birthDay);
        if (birthday == null) {
            JOptionPane.showMessageDialog(this, "Please follow the format provided \n ex. 2000-01-01", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean studentAdded = studentService.addStudent(studID, lastName, firstName, middleName, course, yearLevel, address, contact, position, affiliation, birthday);

        if (studentAdded) {
            JOptionPane.showMessageDialog(this, "Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtfldStudNum.setText("");
            txtfldFirstN.setText("");
            txtfldMiddleN.setText("");
            txfldLastN.setText("");
            txtfldCourse.setText("");
            txtfldYear.setText("");
            txtfldAddress.setText("");
            txtfldContact.setText("");
            txtfldPosition.setText("");
            txtfldAffiliation.setText("");
            txtfldBirthday.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add in the DataBase either wrong format or existing student number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
