
package mcqs_assignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author rames
 */
public class MCQs_Assignment extends JFrame implements ActionListener{

    JLabel lblmsg, lblimg;
    JButton btnadmin, btnuser;
    
    public MCQs_Assignment()
    {
        Container con = getContentPane();
        setSize(1000, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        Font f = new Font("Arial", Font.BOLD, 22);
        ImageIcon icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        
        
        lblmsg = new JLabel("Welcome, How would you like to login?");
        lblmsg.setForeground(Color.black);
        lblmsg.setFont(new Font("Serif", Font.BOLD, 40));
        btnadmin = new JButton("Admin");
        btnuser = new JButton("Student");
        
        btnadmin.setFont(f);
        btnuser.setFont(f);
        
        lblmsg.setBounds(150, 80, 750, 80);
        lblimg.setBounds(0, 0, 1000, 400);
        btnadmin.setBounds(270, 200, 130, 40);
        btnuser.setBounds(570, 200, 130, 40);
        
        con.add(lblmsg);
        con.add(btnadmin);
        con.add(btnuser);
        con.add(lblimg);
        
        btnadmin.addActionListener(this);
        btnuser.addActionListener(this);
    }
    public static void main(String[] args) {
        new MCQs_Assignment().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(btnadmin)) 
      {
           new Admin_Login_Form();
           this.dispose();
      } 
      else if(e.getSource().equals(btnuser))
      {
            new User_Login_Form();
            this.dispose();
      }
    }

    
}
