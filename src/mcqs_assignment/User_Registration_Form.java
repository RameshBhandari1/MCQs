
package mcqs_assignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author rames
 */
public class User_Registration_Form extends JFrame implements ActionListener{
    JLabel lbltitle, lblname, lblemail, lbluser, lblpass1, lblpass2, lblphone, lbltoken, lbladdress, lbllogin, lblimg;
    JTextField txtname, txtemail, txtuser, txtphone, txtaddress;
    JButton btnsubmit, btnclear, btnuserlogin, btntoken;
    JRadioButton rbtmale, rbtfemale, rbtothers;
    JPasswordField password1, confirmpassword2;
    ImageIcon icon;
    
    
    public static Connection getConnection(){
     
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mcqs_assignment", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return conn;
    }
    public boolean checkEmail(String email)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkEmail = false;
        String query = "SELECT * FROM student_info WHERE Email=?";
        
        try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            ps.setString(1, email);
            
            rs = ps.executeQuery(query);
            
            if(rs.next())
            {
                checkEmail = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return checkEmail;
    }
    
    
    public User_Registration_Form()
    {
        Container con = getContentPane();
        setSize(700, 700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form For Student");
        
        Font f = new Font("Arial", Font.BOLD, 20);
        icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        
        lbltitle = new JLabel("Registration Form For Student:");
        lbltitle.setForeground(Color.black);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 28));
        lblname = new JLabel("Name :");
        lblemail = new JLabel("Email-ID :");
        lbluser = new JLabel("Username :");
        lblpass1 = new JLabel("Create Passowrd :");
        lblpass2 = new JLabel("Confirm Password :");
        lblphone = new JLabel("Phone No :");
        lbladdress = new JLabel("Address :");
        
        lbltoken = new JLabel();
        lbltoken.setBounds(250, 370, 150, 30);
        btntoken = new JButton("Token");
        btntoken.setBounds(250, 370, 150, 30);

        txtname = new JTextField();
        txtemail = new JTextField();
        txtuser = new JTextField();
        password1 = new JPasswordField();
        confirmpassword2 = new JPasswordField();
        txtphone = new JTextField();
        txtaddress = new JTextField();

        btnsubmit = new JButton("Register");
        btnclear = new JButton("Clear");

        lbltitle.setBounds(100, 30, 400, 40);
        lblname.setBounds(80, 70, 200, 30);
        lblemail.setBounds(80, 110, 200, 30);
        lbluser.setBounds(80, 150, 200, 30);
        lblpass1.setBounds(80, 190, 200, 30);
        lblpass2.setBounds(80, 230, 200, 30);
        lblphone.setBounds(80, 270, 200, 30);
        lbladdress.setBounds(80, 310, 200, 30);

        
        txtname.setBounds(300, 70, 200, 30);
        txtemail.setBounds(300, 110, 200, 30);
        txtuser.setBounds(300, 150, 200, 30);
        password1.setBounds(300, 190, 200, 30);
        confirmpassword2.setBounds(300, 230, 200, 30);
        txtphone.setBounds(300, 270, 200, 30);
        txtaddress.setBounds(300, 310, 200, 30);
        lblimg.setBounds(0, 0, 700, 700);
                
        btnsubmit.setBounds(150, 420, 150, 30);
        btnclear.setBounds(350, 420, 150, 30);
        
        lblname.setFont(f);
        lblphone.setFont(f);
        lblpass1.setFont(f);
        lblpass2.setFont(f);
        lblemail.setFont(f);
        lbluser.setFont(f);
        lbltoken.setFont(f);
        btntoken.setFont(f);
        lbladdress.setFont(f);
        
        txtname.setFont(f);
        txtphone.setFont(f);
        password1.setFont(f);
        confirmpassword2.setFont(f);
        txtemail.setFont(f);
        txtuser.setFont(f);
        txtaddress.setFont(f);
        
        
        btnsubmit.setFont(f);
        btnclear.setFont(f);
        
        lbllogin = new JLabel("Already have an Account!");
        lbllogin.setForeground(Color.blue);
        lbllogin.setFont(new Font("Serif", Font.ITALIC, 20));
        lbllogin.setBounds(120, 450, 220, 30);
        btnuserlogin = new JButton("Click here.");
        btnuserlogin.setForeground(Color.white);
        btnuserlogin.setBackground(Color.blue);
        btnuserlogin.setFont(new Font("Serif", Font.ITALIC, 15));
        btnuserlogin.setBounds(335, 457, 130, 20);

        con.add(lbllogin);
        con.add(btnuserlogin);
        con.add(lbltitle);
        con.add(lblname);
        con.add(txtname);
        con.add(lblemail);
        con.add(txtemail);
        con.add(lbluser);
        con.add(txtuser);
        con.add(lblpass1);
        con.add(password1);
        con.add(lblpass2);
        con.add(confirmpassword2);
        con.add(lblphone);
        con.add(txtphone);
        con.add(btnsubmit);
        con.add(btnclear);
        con.add(lbladdress);
        con.add(txtaddress);
        con.add(lbltoken);
        con.add(btntoken);
        con.add(lblimg);
        
        btnsubmit.addActionListener(this);
        btnclear.addActionListener(this);
        btnuserlogin.addActionListener(this);
        btntoken.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtname.getText();
        String email = txtemail.getText();
        String username = txtuser.getText();
        String pass = String.valueOf(password1.getPassword());
        String re_pass = String.valueOf(confirmpassword2.getPassword());

        String phone = txtphone.getText();
        String address = txtaddress.getText();
        String token = lbltoken.getText(); 
        if (e.getSource().equals(btnsubmit))
        {
        
        
            if("".equals(name)||"".equals(email)||"".equals(username)||"".equals(phone)||"".equals(address)||"".equals(token))
            {
                JOptionPane.showMessageDialog(null, "Please fill all the Form and try again!!");
            }

            else if(pass.equals("")||re_pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add A Password");
            }
            else if(!pass.equals(re_pass))
            {
                JOptionPane.showMessageDialog(null, "Retype The Password Again");
                password1.setText("");
                confirmpassword2.setText("");
            }

            else if(checkEmail(email))
            {
                JOptionPane.showMessageDialog(null, "This Email Already Exist");
            }
            else{
                PreparedStatement ps;
                String query = "INSERT INTO student_info(Name,Email,Username,Password,Phone,Address,Token) VALUES(?,?,?,?,?,?,?)";

                try {
                    ps = User_Registration_Form.getConnection().prepareStatement(query);

                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, username);
                    ps.setString(4, pass);
                    ps.setString(5, phone);
                    ps.setString(6, address);
                    ps.setString(7, token);

                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "New User Add");
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }  
            }
    }
    if(e.getSource().equals(btnclear))
    {
        txtname.setText("");
        txtemail.setText("");
        txtuser.setText("");
        txtphone.setText("");
        confirmpassword2.setText("");
        txtaddress.setText("");
        password1.setText("");
        lbltoken.setVisible(false);
        btntoken.setVisible(true);
    } 
    if (e.getSource().equals(btnuserlogin)){
        new User_Login_Form();
        this.dispose();
    }
    if(e.getSource().equals(btntoken))
    {
        if("".equals(name)||"".equals(email)||"".equals(username)||"".equals(pass)||"".equals(re_pass)||"".equals(phone)||"".equals(address))
        {
            JOptionPane.showMessageDialog(null, "Please fill all the Form and try again!!");
        }
        else
        {
            lbltoken.setText(String.valueOf(username+"366"));
            btntoken.setVisible(false);
        }
    }
    }
}
