
package mcqs_assignment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author rames
 */
public class Admin_Login_Form extends JFrame implements ActionListener{
    JButton btnadminlogin, btnuserform;
    JLabel lblname,lblpass,lblimg,lbladlogo,lbltitle;
    JTextField txtname; 
    JPasswordField  txtpass;
    ImageIcon icon, adminicon;
    JCheckBox showPassword;
    
    public Admin_Login_Form(){
        Font f = new Font("Arial", Font.BOLD, 22);
        setTitle("User Login Form");
        setSize(730,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        adminicon = new ImageIcon("images/admin.png");
        lbladlogo = new JLabel(adminicon);
        icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        
        lbltitle = new JLabel("Login For Admin");
        lbltitle.setForeground(Color.black);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 30));
        
        btnadminlogin = new JButton("Login");
        btnuserform = new JButton("For User Login");
        btnuserform.setFont(new Font("Serif", Font.BOLD, 20));
        lblname = new JLabel("Username :");
        lblpass = new JLabel("Password :");
        showPassword = new JCheckBox("Show Password");
        
        txtname = new JTextField();
        txtpass = new JPasswordField();
        
        lblname.setBounds(300, 130, 150, 30);
        lblpass.setBounds(300, 190, 150, 30);
        lbladlogo.setBounds(50, 120, 200, 200);
        btnadminlogin.setBounds(380, 280, 150, 40);
        btnuserform.setBounds(500, 10, 170, 30);
        lblimg.setBounds(0, 0, 900, 600);
        lbltitle.setBounds(200, 50, 300, 40);
        
        txtname.setBounds(460, 130, 200, 30);
        txtpass.setBounds(460, 190, 200, 30);
        showPassword.setBounds(460, 230, 120, 20);
        
        btnadminlogin.setFont(f);
        btnadminlogin.setForeground(Color.blue);
        lblname.setFont(f);
        lblpass.setFont(f);
        txtpass.setFont(f);
        txtname.setFont(f);
        
        add(lbltitle);
        add(lblname);
        add(lblpass);
        add(showPassword);
        add(btnadminlogin);
        add(btnuserform);
        add(txtpass);
        add(txtname);
        add(lbladlogo);
        add(lblimg);
        
        btnadminlogin.addActionListener(this);
        btnuserform.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a= txtname.getText(); 
        String b= txtpass.getText(); 
         
         if(e.getSource().equals(btnadminlogin)) 
         {
            if(a.equals("ramesh") && b.equals("ramesh"))
            {
                new Admin_Dashboard();
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect username or Password");
            }
         }        
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                txtpass.setEchoChar((char) 0);
            } 
            else {
                txtpass.setEchoChar('*');
            }
        } 
        if (e.getSource().equals(btnuserform)){
            new User_Login_Form();
            this.dispose();
        }
    }    
}
