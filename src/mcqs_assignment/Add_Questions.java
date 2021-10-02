
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
public class Add_Questions extends JFrame implements ActionListener{

    JLabel lblimg, lbltitle, lblcourse, lblques, lblans1, lblans2, lblans3, lblans4, lblcorrect;
    JButton btnadd, btnback;
    JTextField txtans1, txtans2, txtans3, txtans4, txtcorrectans, txtquestion;
    JComboBox combcourse;
    ImageIcon icon;
    
     
    
    public Add_Questions(){
        Font f = new Font("Arial", Font.BOLD, 22);
        setTitle("Adding New Questions");
        setSize(900,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        lbltitle = new JLabel("Add New Questions");
        lbltitle.setForeground(Color.black);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 30));
        
        btnback =new JButton("Back");
        txtquestion = new JTextField();
        txtans1 = new JTextField();
        txtans2 = new JTextField();
        txtans3 = new JTextField();
        txtans4 = new JTextField();
        txtcorrectans = new JTextField();
        lblcourse = new JLabel("Courses :");
        lblques = new JLabel("Question :");
        lblans1 = new JLabel("Answer one:");
        lblans2 = new JLabel("Answer two:");
        lblans3 = new JLabel("Answer three:");
        lblans4 = new JLabel("Answer four:");
        lblcorrect = new JLabel("Correct Ans:");
        combcourse = new JComboBox();
        combcourse.addItem("Modern Web");
        combcourse.addItem("Java");
        combcourse.addItem("Python");
        btnadd =new JButton("Add");
        
        btnback.setFont(f);
        lblcourse.setFont(f);
        combcourse.setFont(f);
        lblques.setFont(f);
        lblans1.setFont(f);
        lblans2.setFont(f);
        lblans3.setFont(f);
        lblans4.setFont(f);
        lblcorrect.setFont(f);
        txtquestion.setFont(f);
        txtans1.setFont(f);
        txtans2.setFont(f);
        txtans3.setFont(f);
        txtans4.setFont(f);
        txtcorrectans.setFont(f);
        btnadd.setFont(f);
        
        icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        
        lbltitle.setBounds(250, 30, 300, 80);
        btnback.setBounds(750, 10, 100, 30);
        lblcourse.setBounds(40, 100, 120, 30);
        combcourse.setBounds(150, 100, 180, 30);
        lblques.setBounds(40, 140, 120, 30);
        txtquestion.setBounds(40, 180, 800, 50);
        lblans1.setBounds(40, 240, 150, 30);
        lblans2.setBounds(40, 280, 150, 30);
        lblans3.setBounds(40, 320, 150, 30);
        lblans4.setBounds(40, 360, 150, 30);
        lblcorrect.setBounds(40, 400, 150, 30);
        txtans1.setBounds(200, 240, 150, 30);
        txtans2.setBounds(200, 280, 150, 30);
        txtans3.setBounds(200, 320, 150, 30);
        txtans4.setBounds(200, 360, 150, 30);
        txtcorrectans.setBounds(200, 400, 150, 30);
        btnadd.setBounds(650, 460, 150, 30);
        lblimg.setBounds(0, 0, 900, 800);
        
        add(lbltitle);
        add(btnback);add(btnadd);
        add(lblcourse);
        add(combcourse);
        add(lblques);
        add(txtquestion);
        add(lblans1);add(lblans2);add(lblans3);add(lblans4);add(lblcorrect);
        add(txtans1);add(txtans2);add(txtans3);add(txtans4);add(txtcorrectans);
        add(lblimg);
        
        btnadd.addActionListener(this); 
        btnback.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnadd))
        {
            if(combcourse.getSelectedItem()=="Java")
            {
   
            String question = txtquestion.getText();
            String ans1 = txtans1.getText();
            String ans2 = txtans2.getText();
            String ans3 = txtans3.getText();
            String ans4 = txtans4.getText();
            String correctans = txtcorrectans.getText();
            
            PreparedStatement ps;
            String query = "INSERT INTO java_questions(Questions, Ans_one, Ans_two, Ans_three, Ans_four, Correct_ans) VALUES(?,?,?,?,?,?)";
        
        try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            
            ps.setString(1, question);
            ps.setString(2, ans1);
            ps.setString(3, ans2);
            ps.setString(4, ans3);
            ps.setString(5, ans4);
            ps.setString(6, correctans);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "New Question Added.");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }                         
        }
            if(combcourse.getSelectedItem()=="Python")
            {
   
            String question = txtquestion.getText();
            String ans1 = txtans1.getText();
            String ans2 = txtans2.getText();
            String ans3 = txtans3.getText();
            String ans4 = txtans4.getText();
            String correctans = txtcorrectans.getText();
            
            PreparedStatement ps;
            String query = "INSERT INTO science_questions(Questions, Ans_one, Ans_two, Ans_three, Ans_four, Correct_ans) VALUES(?,?,?,?,?,?)";
        
        try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            
            ps.setString(1, question);
            ps.setString(2, ans1);
            ps.setString(3, ans2);
            ps.setString(4, ans3);
            ps.setString(5, ans4);
            ps.setString(6, correctans);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "New Question Added.");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }                         
        }
            if(combcourse.getSelectedItem()=="Modern Web")
            {
   
            String question = txtquestion.getText();
            String ans1 = txtans1.getText();
            String ans2 = txtans2.getText();
            String ans3 = txtans3.getText();
            String ans4 = txtans4.getText();
            String correctans = txtcorrectans.getText();
            
            PreparedStatement ps;
            String query = "INSERT INTO web_questions(Questions, Ans_one, Ans_two, Ans_three, Ans_four, Correct_ans) VALUES(?,?,?,?,?,?)";
        
        try {
            ps = User_Registration_Form.getConnection().prepareStatement(query);
            
            ps.setString(1, question);
            ps.setString(2, ans1);
            ps.setString(3, ans2);
            ps.setString(4, ans3);
            ps.setString(5, ans4);
            ps.setString(6, correctans);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "New Question Added.");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }                         
        }
        }
        if(e.getSource().equals(btnback))
        {
            new Admin_Dashboard();
            this.dispose();
        }
    }
    
}
