
package mcqs_assignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rames
 */
public class Admin_Dashboard extends JFrame implements ActionListener{
    
    JLabel lbltitle, lbltitle2, lbltitle3, lblimg, lblweb, lbljava, lblsci;
    JButton btnwebview, btnjavaview, btnsciview, btnwebadd, btnjavaadd, btnsciadd, btnback;
    
    public Admin_Dashboard(){
        Container con = getContentPane();
        setSize(1300, 750);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        Font f = new Font("Arial", Font.BOLD, 30);
        ImageIcon icon = new ImageIcon("images/admindash.jfif");
        lblimg = new JLabel(icon);
        
        lbltitle = new JLabel("Welcome Admin Ramesh!");
        lbltitle2 = new JLabel("Here you can add multiple questions by clicking ADD button and");
        lbltitle3 = new JLabel("you can also view questions by clicking VIEW button.");
        lbltitle.setForeground(Color.white);
        lbltitle.setFont(new Font("Serif", Font.BOLD, 50));
        lbltitle2.setForeground(Color.white);
        lbltitle2.setFont(new Font("Serif", Font.BOLD, 32));
        lbltitle3.setForeground(Color.white);
        lbltitle3.setFont(new Font("Serif", Font.BOLD, 28));
        lblweb = new JLabel("Modern Web");
        lbljava = new JLabel("Java");
        lblsci = new JLabel("Python");
        btnwebview = new JButton("VIEW");
        btnwebadd = new JButton("ADD");
        btnjavaview = new JButton("VIEW");
        btnjavaadd = new JButton("ADD");
        btnsciview = new JButton("VIEW");
        btnsciadd = new JButton("ADD");
        btnback = new JButton("Back");
        
        lbltitle.setBounds(300, 40, 800, 80);
        lbltitle2.setBounds(200, 120, 1000, 40);
        lbltitle3.setBounds(300, 165, 750, 40);
        lblweb.setBounds(300, 300, 220, 30);
        lbljava.setBounds(300, 400, 150, 30);
        lblsci.setBounds(300, 500, 150, 30);
        btnwebview.setBounds(580, 300, 120, 30);
        btnjavaview.setBounds(580, 400, 120, 30);
        btnsciview.setBounds(580, 500, 120, 30);
        btnwebadd.setBounds(750, 300, 120, 30);
        btnjavaadd.setBounds(750, 400, 120, 30);
        btnsciadd.setBounds(750, 500, 120, 30);
        btnback.setBounds(500, 580, 120, 30);
        lblimg.setBounds(0, 0, 1300, 950);
        
        lblweb.setFont(f);
        lblweb.setForeground(Color.white);
        lbljava.setFont(f);
        lbljava.setForeground(Color.white);
        lblsci.setFont(f);
        lblsci.setForeground(Color.white);
        Font bf = new Font("Arial", Font.BOLD, 21);
        btnwebview.setFont(bf);
        btnjavaview.setFont(bf);
        btnsciview.setFont(bf);
        btnwebadd.setFont(bf);
        btnjavaadd.setFont(bf);
        btnsciadd.setFont(bf);
        btnback.setFont(bf);
        
        con.add(lblweb);
        con.add(lbljava);
        con.add(lblsci);
        con.add(btnwebview);
        con.add(btnwebadd);
        con.add(btnjavaview);
        con.add(btnjavaadd);
        con.add(btnsciview);
        con.add(btnsciadd);
        con.add(lbltitle);
        con.add(lbltitle2);
        con.add(lbltitle3);
        con.add(btnback);
        con.add(lblimg);
        
        btnwebadd.addActionListener(this); 
        btnjavaadd.addActionListener(this); 
        btnsciadd.addActionListener(this); 
        btnjavaview.addActionListener(this); 
        btnwebview.addActionListener(this);
        btnsciview.addActionListener(this);
        btnback.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnwebadd)||e.getSource().equals(btnjavaadd)||e.getSource().equals(btnsciadd))
        {
            new Add_Questions();
            this.dispose();
        }
        if(e.getSource().equals(btnjavaview))
        {
            new View_Java_Questions();
            
        }
        if(e.getSource().equals(btnwebview))
        {
            new View_Web_Questions();
            
        }
        if(e.getSource().equals(btnsciview))
        {
            new View_Python_Questions();
            
        }
        if(e.getSource().equals(btnback))
        {
            new Admin_Login_Form();
            this.dispose();
        }
    }   
}
