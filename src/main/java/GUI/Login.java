package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import BusinessLogic.AdminServices;

public class Login extends JFrame implements ActionListener {

    private JProgressBar progressBar = new JProgressBar();
    private JButton btnLogin, btnRegister;
    private JLabel BackGroundImage, PUPLogo, txtPUP, txtAddress, txtMembership, txtNumber, txtPassword, txtAcc, txtReg, txtprompt;
    private JTextField numTxtFld;
    private JPasswordField passTxtFld;
    private RoundedPanels redSquare;
    private AdminServices adminServices;
    private int trial = 0;

    Login() {
        adminServices = new AdminServices();

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtprompt = new JLabel("", SwingConstants.CENTER);
        txtprompt.setForeground(Color.white);
        txtprompt.setBounds(240, 330, 500, 30);
        add(txtprompt);

        txtPUP = new JLabel("POLYTECHNIC UNIVERSITY OF THE PHILIPPINES");
        txtPUP.setForeground(Color.white);
        txtPUP.setFont(new Font("impact", Font.PLAIN, 22));
        txtPUP.setBounds(325, 150, 420, 25);
        add(txtPUP);

        txtAddress = new JLabel("Binan Campus - Brgy. Zapote 4024 Binãn, Philippines");
        txtAddress.setForeground(Color.white);
        txtAddress.setFont(new Font("aptos", Font.PLAIN, 13));
        txtAddress.setBounds(370, 173, 420, 16);
        add(txtAddress);

        txtMembership = new JLabel("MEMBERSHIP FORM");
        txtMembership.setForeground(Color.white);
        txtMembership.setFont(new Font("impact", Font.PLAIN, 30));
        txtMembership.setBounds(378, 220, 420, 30);
        add(txtMembership);

        txtNumber = new JLabel("Number:");
        txtNumber.setForeground(Color.white);
        txtNumber.setFont(new Font("impact", Font.PLAIN, 20));
        txtNumber.setBounds(378, 270, 420, 20);
        add(txtNumber);

        txtPassword = new JLabel("Password:");
        txtPassword.setForeground(Color.white);
        txtPassword.setFont(new Font("impact", Font.PLAIN, 20));
        txtPassword.setBounds(378, 310, 420, 20);
        add(txtPassword);

        numTxtFld = new JTextField("enter_here");
        numTxtFld.setBounds(495, 270, 110, 20);
        numTxtFld.setBorder(null);
        add(numTxtFld);

        passTxtFld = new JPasswordField();
        passTxtFld.setBounds(495, 310, 110, 20);
        passTxtFld.setBorder(null);
        add(passTxtFld);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(440, 370, 90, 20);
        btnLogin.setBackground(Color.white);
        btnLogin.setForeground(new Color(171, 34, 34));
        btnLogin.addActionListener(this);
        add(btnLogin);
        
        txtAcc = new JLabel("Register new member?   register here:");
        txtAcc.setForeground(Color.white);
        txtAcc.setFont(new Font("aptos", Font.PLAIN, 10));
        txtAcc.setBounds(390, 400, 200, 10);
        add(txtAcc);

        btnRegister = new JButton("<html><i><u>Here</u></i></html>");
        btnRegister.setForeground(Color.yellow);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setFont(new Font("aptos", Font.PLAIN, 10));
        btnRegister.setBounds(550, 400, 60, 12);
        btnRegister.addActionListener(this);
        add(btnRegister);

        PUPLogo = new JLabel();
        ImageIcon Logo = new ImageIcon("Images/PUPLogo.png");
        PUPLogo.setBounds(255, 140, 65, 65);
        PUPLogo.setIcon(Logo);
        Image scaledImage = Logo.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        PUPLogo.setIcon(new ImageIcon(scaledImage));
        add(PUPLogo);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(0, 0, 1000, 25);
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(171, 34, 34));
        add(progressBar);

        redSquare = new RoundedPanels(30, new Color(171, 34, 34));
        redSquare.setBounds(240, 130, 500, 300);
        this.add(redSquare);

        BackGroundImage = new JLabel();
        ImageIcon backgroundPic = new ImageIcon("Images/BG.png");
        BackGroundImage.setIcon(backgroundPic);
        BackGroundImage.setSize(1000, 600);
        this.add(BackGroundImage);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            if (trial < 4) {
                trial++;
                String number = numTxtFld.getText();
                String password = new String(passTxtFld.getPassword());

                if (adminServices.VerifyAdmin(number, password)) {
                    startProgressBar();  
                } else {
                    numTxtFld.setText("");
                    passTxtFld.setText("");
                    txtprompt.setText("Incorrect number or password.Login Attempts: " + trial);
                }

            } else {
                txtprompt.setText("Login attempts exceeded: Attempts 5");
                numTxtFld.setEditable(false);
                passTxtFld.setEditable(false);
            }

        } else if (e.getSource() == btnRegister) {
            new Register();
            this.dispose();
        }
    }

    public void startProgressBar() {
        progressBar.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(counter);
                counter++;
                if (counter > 100) {
                    ((Timer) e.getSource()).stop();
                    new Records();
                    dispose();
                }
            }
        });

        timer.start();
    }
}
