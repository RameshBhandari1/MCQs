
package mcqs_assignment;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author rames
 */
public class Student_Dashboard extends JFrame implements ActionListener{

    JLabel lbltitle, lbltitle2, lbltitle3, lblimg, lblcourse, lbltoken, lblyourtoken, lblinstoken, lblpass;
    JTextField txttoken;
    JPasswordField txtpass;
    JButton btnstart,btnback;
    JComboBox combcourse;
    
    public Student_Dashboard(String u){
        Container con = getContentPane();
        setSize(1300, 800);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        Font f = new Font("Arial", Font.BOLD, 30);
        ImageIcon icon = new ImageIcon("images/admindash.jfif");
        lblimg = new JLabel(icon);
        
        lbltitle = new JLabel("Welcome Student.");
        lbltitle2 = new JLabel("Here you can choose subject in which you want to take a test. For that");
        lbltitle3 = new JLabel("you have to first fill your token & password and click on  start button.");
        lbltitle.setForeground(Color.white);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 50));
        lbltitle2.setForeground(Color.white);
        lbltitle2.setFont(new Font("Serif", Font.BOLD, 32));
        lbltitle3.setForeground(Color.white);
        lbltitle3.setFont(new Font("Serif", Font.BOLD, 28));
        lbltoken = new JLabel("Your Token :");
        lblyourtoken = new JLabel("");
        lblinstoken = new JLabel("Your Token :");
        lblpass = new JLabel("Password :");
        txttoken = new JTextField();
        txtpass = new JPasswordField();
        lblcourse = new JLabel("Select Subject");
        combcourse = new JComboBox();
        combcourse.addItem("Modern Web");
        combcourse.addItem("Java");
        combcourse.addItem("Python");
        btnstart = new JButton("START");
        btnback = new JButton("Back");
        
        lbltitle.setBounds(400, 40, 800, 80);
        lbltitle2.setBounds(200, 120, 1000, 40);
        lbltitle3.setBounds(260, 165, 900, 40);
        lbltoken.setBounds(300, 240, 200, 40);
        lblyourtoken.setBounds(450, 240, 200, 40); 
        lblyourtoken.setText(String.valueOf(u+"366"));
        lblcourse.setBounds(300, 300, 180, 30);
        combcourse.setBounds(490, 300, 180, 30);
        lblinstoken.setBounds(300, 400, 180, 30);
        lblpass.setBounds(300, 450, 180, 30);
        txttoken.setBounds(450, 400, 200, 30);
        txtpass.setBounds(450, 450, 200, 30);
        btnstart.setBounds(750, 550, 120, 30);
        btnback.setBounds(500, 590, 120, 30);
        lblimg.setBounds(0, 0, 1300, 950);
        
        Font bf = new Font("Arial", Font.BOLD, 21);
        lblcourse.setFont(bf);
        lblcourse.setForeground(Color.white);
        lbltoken.setForeground(Color.white);
        lblyourtoken.setForeground(Color.yellow);
        combcourse.setFont(bf);
        btnstart.setFont(bf);
        lbltoken.setFont(bf);
        lblinstoken.setFont(bf);
        lblpass.setFont(bf);
        txttoken.setFont(bf);
        txtpass.setFont(bf);
        lblyourtoken.setFont(bf);
        lblinstoken.setForeground(Color.white);
        lblpass.setForeground(Color.white);
        btnback.setFont(bf);

        con.add(lblcourse);
        con.add(combcourse);
        con.add(lblinstoken);
        con.add(lblpass);
        con.add(txttoken);
        con.add(txtpass);
        con.add(lbltoken);
        con.add(lblyourtoken);
        con.add(btnstart);
        con.add(lbltitle);
        con.add(lbltitle2);
        con.add(lbltitle3);
        con.add(btnback);
        con.add(lblimg);
        
        btnstart.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnstart))
        {
            PreparedStatement ps;
            ResultSet rs;
            String token = txttoken.getText();
            String pass = String.valueOf(txtpass.getText());
        
            String query = "SELECT * FROM student_info WHERE Token =? AND Password =?";
            try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            
            ps.setString(1, token);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            if(txttoken.getText().equals("")&& pass.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill your Token and password.");
            }
            
           else if(rs.next())
            {
                if(combcourse.getSelectedItem().equals("Java")){
                new Java_Exams_Questions();
                this.dispose();
                }
                else if(combcourse.getSelectedItem().equals("Python")){
                    new Python_Questions_Exam();
                    this.dispose();
                }
                else if(combcourse.getSelectedItem().equals("Modern Web"))
                {
                    new ModernWeb_Exams_Questions();
                    this.dispose();
                }       
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Token Or Password!");
            }
            
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(e.getSource().equals(btnback))
        {
           new User_Login_Form();
           this.dispose();
        }
    }
    
}
