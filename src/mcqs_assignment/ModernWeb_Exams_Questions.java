
package mcqs_assignment;
import java.awt.*; 
import java.awt.event.*; //package to implement event response 
import javax.swing.*; //package to implement swing gui
import java.sql.*; //package to connect to mysql database
/**
 *
 * @author rames
 */
public class ModernWeb_Exams_Questions extends JFrame implements ActionListener{
    JLabel lblimg, lblques, lblrule1, lblrule2, lblrule3;
    JButton btnnext, btnsubmit;
    JRadioButton jbutton[]=new JRadioButton[5];
    ButtonGroup buttongroup;
    ImageIcon icon;
    String ans[]=new String[11];
    int count=0,current=-1; 
    long StartTime, EndTime,seconds,minutes,flag=0;; 
    int a;
    
    String v; 
    
    public ModernWeb_Exams_Questions(){
        Font f = new Font("Arial", Font.BOLD, 22);
        setTitle("Examination Dashboard");
        setSize(1200,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        buttongroup=new ButtonGroup(); 
        for(int i=0;i<5;i++)  
        {  
            jbutton[i]=new JRadioButton();
            jbutton[i].setFont(new Font("Arial", Font.BOLD, 22));
            add(jbutton[i]);  
            buttongroup.add(jbutton[i]);  
        }
        if(current !=-1)
        {   
            jbutton[0].setBounds(40, 170, 200, 40);  
            jbutton[1].setBounds(40, 230, 200, 40);  
            jbutton[2].setBounds(40, 290, 200, 40);  
            jbutton[3].setBounds(40, 350, 200, 40);  
        }
        
        
        lblques=  new JLabel("Welcome to the Web examination. Please Click Start button to begin the test.");
        lblrule1=  new JLabel("1) Please, read the question carefully before attending question.");
        lblrule2=  new JLabel("2) Once you have clicked on next button you cannot go back to previous question.");
        lblrule3=  new JLabel("3) Please finished your test with in 5 minutes.");
        
        btnnext = new JButton("Start");
        btnsubmit = new JButton("Result");
        
        lblques.setFont(f);lblrule1.setFont(f);lblrule2.setFont(f);lblrule3.setFont(f);
        btnnext.setFont(f);btnsubmit.setFont(f);
        
        

        lblques.setBounds(30, 110, 1200, 40);
        lblrule1.setBounds(50, 180, 1100, 40);
        lblrule2.setBounds(50, 220, 1100, 40);
        lblrule3.setBounds(50, 260, 1100, 40);

        btnnext.setBounds(800, 400, 150, 35);
        btnsubmit.setBounds(800, 400, 150, 35);
        
        icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
        lblimg.setBounds(0, 0, 1200, 600);
        

        add(lblques);add(lblrule1);add(lblrule2);add(lblrule3);
        add(btnsubmit);
        add(btnnext);
        add(lblimg);
        
        btnnext.addActionListener(this);
        btnsubmit.addActionListener(this);
        btnsubmit.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try
        {
            if(e.getSource().equals(btnnext) && current ==9 )
            {
                btnsubmit.setVisible(true);
                btnnext.setVisible(false);
                JOptionPane.showMessageDialog(this,"No more questions. Please go back to previous question or end test and see result.\n");
            }
            else if(e.getSource().equals(btnnext))  //if user clicks on start/next and there are more questions available to be displayed
            {  
                if(current == -1) //if user hasn't started test yet, i.e., she/he clicks on "start" button
                {
                    StartTime = System.currentTimeMillis(); //stores time when user starts test
                    btnnext.setText("Next"); //setting text of b1 button to "next"
                    lblrule1.setVisible(false);
                    lblrule2.setVisible(false);
                    lblrule3.setVisible(false);
                }
                else
                {
                    check();//adding user's response to the question
                }
                current++; //incrementing counter of questions countered
                setnext();//setting next question    
            }  
            
            if(e.getSource().equals(btnsubmit))  //if user clicks on result button
            {  
                EndTime = System.currentTimeMillis(); //stores time when user ends test
                EndTime-=StartTime; //stores time taken by user to give test in milliseconds
                EndTime/=1000; //stores time taken by user to give test in seconds
                if(EndTime>=60) // if time can be expressed in minutes or hours
                {
                    seconds = EndTime%60; //calculating seconds
                    EndTime/=60; //calculating minutes
                    flag=1;
                    if(EndTime>=60) //if time can be expressed in hours
                    {
                        flag=2;
                        minutes=EndTime%60; //calculating minutes
                        EndTime/=60; //calculating hours
                    }
                }
                current++;   
                check(); //checks user's responses against correct responses stored in database                
                if(flag==0)
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");  
                else if(flag==1)
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" minutes "+seconds+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");     
                else
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" hours "+minutes+" minutes "+seconds+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");     
                //displays total score and percentage
                if(a==JOptionPane.YES_OPTION) //checks if user wants to see answer key or not
                    showAnswerKey();
                else
                {
                    System.exit(0);  //closes interface and exits
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("actionPerformed"+ex);
        }  
    }
    void setnext() //function to set next question 
    {  
        jbutton[4].setSelected(true);
        int k= 0; 
        try
        {
            for(int i=1; i<=10; i++){
            Statement stmt = User_Registration_Form.getConnection().createStatement();
            
            if(current==k)  
            {    
                String sql="select * from web_questions order by rand()"; //selects all fields of table 'web_questions' 
                ResultSet rs = stmt.executeQuery(sql); //executing sql query 
                if(rs.next()){ //pointing to next row of result set 
                String s1 =rs.getString("Questions"); //getting value stored in result set under field "Questions"
                String s2 =rs.getString("Ans_one"); //getting value stored in result set under field "Ans_one"
                String s3 =rs.getString("Ans_two"); //getting value stored in result set under field "Ans_two"
                String s4 =rs.getString("Ans_three"); //getting value stored in result set under field "Ans_three"
                String s5 =rs.getString("Ans_four"); //getting value stored in result set under field "Ans_four"
                lblques.setText("Q."+i+" "+s1); //setting question
                jbutton[0].setText(s2);jbutton[1].setText(s3);jbutton[2].setText(s4);jbutton[3].setText(s5);
                }//setting options
            } 
            k++;
            }
            lblques.setBounds(30,40,1200,30);  
            for(int i=0,j=0;i<=140;i+=40,j++)  
                jbutton[j].setBounds(50,80+i,500,30);  
        }   
        catch(Exception e)
        {
            System.out.println("setnext\n"+e);
        }
    }
        
    void check()  //function to check number of correct answers 
    {  
        try
        {
            Statement stmt = User_Registration_Form.getConnection().createStatement();
            String sq="select * from web_questions";
            ResultSet rs2 = stmt.executeQuery(sq);
            for(int i=1;i<=10;i++)
            {  
                rs2.absolute(i);
                ans[i] =rs2.getString("Correct_ans");           
                for(int j=0;j<4;j++){
                     if(jbutton[j].isSelected()) //if answer has been selected in radio button group
                    {
                       v =jbutton[j].getText();
                        String s1 = v;                   
                        if(s1.equals(ans[i])){ //checks if user's answer matches correct answer
                           count+=1;
                        }
                    }                
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("check: CATCH: "+e);
        }
    }
  
    void showAnswerKey() //function to print answer key if requested for
    {
        try
        {
            
            Statement stmt = User_Registration_Form.getConnection().createStatement();
            String answerkey="";
            answerkey+="Answer Key:\nQ.No. Correct Answer\n";
            for(int i=1;i<=10;i++)
            {
                String sq="select Correct_ans from web_questions where ID="+i+"";
                ResultSet rs2 = stmt.executeQuery(sq);
                rs2.next();
                String s2 =rs2.getString("Correct_ans"); //stores correct answer
                if(i<=9)
                 answerkey+="   "+(char)(i+48)+"  "+s2+"\n";
                else //0-9 is 48-57 in ascii 
                 answerkey+="  10"+" "+s2+"\n";
            }
            JOptionPane.showMessageDialog(this,answerkey); //prints answer key

            System.exit(0);
            User_Registration_Form.getConnection().close();
        }
        catch(Exception e)
        {
            System.out.println("showAnswerKey\n"+e);
        }
    }
}
