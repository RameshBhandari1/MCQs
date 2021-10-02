
package mcqs_assignment;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author rames
 */
public class View_Python_Questions {

    Statement st = null; 
    ResultSet rs = null; 
    String s;
    public View_Python_Questions(){
        try{ 
        st = User_Registration_Form.getConnection().createStatement();
        s = "select * from science_questions"; 
        rs = st.executeQuery(s);
        ResultSetMetaData rsmt = rs.getMetaData(); 
        int c = rsmt.getColumnCount();
        Vector column = new Vector(c);

        for(int i = 1; i <= c; i++) {
            column.add(rsmt.getColumnName(i)); 
        } 
            Vector data = new Vector(); 
            Vector row = new Vector(); 

        while(rs.next()) { 
            row = new Vector(c); 

            for(int i = 1; i <= c; i++){
                row.add(rs.getString(i));
            } 

        data.add(row);
        } 

        JFrame frame = new JFrame(); 
        frame.setSize(1500,500); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        JPanel panel = new JPanel(); 
        JTable table = new JTable(data,column);
        table.setFont(new Font("Tahome", Font.BOLD, 15));
        table.setRowHeight(35);
        TableColumnModel tblcol = table.getColumnModel();
        tblcol.getColumn(0).setPreferredWidth(1);
        tblcol.getColumn(1).setPreferredWidth(500);
        JTableHeader head = table.getTableHeader();
        head.setBackground(Color.blue);
        head.setForeground(Color.white);
        head.setFont(new Font("Tahome", Font.BOLD, 18));
        JScrollPane jsp = new JScrollPane(table); 
        panel.setLayout(new BorderLayout()); 
        panel.add(jsp,BorderLayout.CENTER); 
        frame.setContentPane(panel); 
        frame.setVisible(true); 
    }
    catch(Exception e){ 
        JOptionPane.showMessageDialog(null, "ERROR"); 
    }
    finally{
        try{ 
            st.close(); 
            rs.close(); 
            User_Registration_Form.getConnection().close(); 
        }
        catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "ERROR CLOSE"); 
        } 
    } 
    }
}
