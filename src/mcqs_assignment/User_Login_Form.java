
package mcqs_assignment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author rames
 */
public class User_Login_Form extends JFrame implements ActionListener{
    JButton btnlogin ,btnadmin, btnreg;
    JLabel lbluser,lblpass, lblimg,lbladlogo,lbltitle,lbllogin;
    JTextField txtuser; 
    JPasswordField  txtpass;
    ImageIcon icon, adminicon;
    JCheckBox showPassword;
    
    public User_Login_Form()
    {
        Font f = new Font("Arial", Font.BOLD, 22);
        setTitle("Student Login Form");
        setSize(730,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        adminicon = new ImageIcon("images/user.png");
        lbladlogo = new JLabel(adminicon);
        icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        
        lbltitle = new JLabel("Login For Student");
        lbltitle.setForeground(Color.black);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 30));
        
        btnlogin = new JButton("Login");
        btnadmin = new JButton("For Admin Login");
        btnadmin.setFont(new Font("Serif", Font.BOLD, 20));
        lbluser = new JLabel("Username :");
        lblpass = new JLabel("Password :");
        showPassword = new JCheckBox("Show Password");
        
        txtuser = new JTextField();
        txtpass = new JPasswordField();
        
        lbllogin = new JLabel("New User?");
        lbllogin.setForeground(Color.black);
        lbllogin.setFont(new Font("Serif", Font.ITALIC, 20));
        lbllogin.setBounds(220, 340, 160, 30);
        btnreg = new JButton("Click here.");
        btnreg.setForeground(Color.white);
        btnreg.setBackground(Color.blue);
        btnreg.setFont(new Font("Serif", Font.ITALIC, 15));
        btnreg.setBounds(310, 347, 130, 20);
        
        lbluser.setBounds(300, 130, 150, 30);
        lblpass.setBounds(300, 190, 150, 30);
        lbladlogo.setBounds(50, 120, 200, 150);
        btnlogin.setBounds(340, 280, 150, 40);
        btnadmin.setBounds(480, 10, 200, 30);
        lblimg.setBounds(0, 0, 900, 600);
        lbltitle.setBounds(200, 50, 300, 40);
        
        txtuser.setBounds(460, 130, 200, 30);
        txtpass.setBounds(460, 190, 200, 30);
        showPassword.setBounds(460, 230, 120, 20);
        
        btnlogin.setFont(f);
        btnlogin.setForeground(Color.blue);
        lbluser.setFont(f);
        lblpass.setFont(f);
        txtpass.setFont(f);
        txtuser.setFont(f);
        
        add(lbllogin);
        add(btnreg);
        add(lbltitle);
        add(lbluser);
        add(lblpass);
        add(showPassword);
        add(btnlogin);
        add(btnadmin);
        add(txtpass);
        add(txtuser);
        add(lbladlogo);
        add(lblimg);
        
        btnlogin.addActionListener(this);
        btnadmin.addActionListener(this);
        showPassword.addActionListener(this);
        btnreg.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btnlogin){
        PreparedStatement ps;
        ResultSet rs;
        String user = txtuser.getText();
        String pass = String.valueOf(txtpass.getPassword());
        
        String query = "SELECT * FROM student_info WHERE Username =? AND Password =?";
        
        try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                new Student_Dashboard(user).setVisible(true);
                this.dispose();       
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password!");
            }    
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        }
        if(e.getSource() == btnadmin){
            new Admin_Login_Form();
            this.dispose();
        }
        if (e.getSource() == btnreg){
            new User_Registration_Form();
            this.dispose();
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                txtpass.setEchoChar((char) 0);
            } else {
                txtpass.setEchoChar('*');
            }
        }
        
    }
    
    
}
