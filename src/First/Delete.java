package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;



public class Delete extends JFrame {
    private static final long serialVersionUID = -1928970409928880648L;

    JLabel jlnumber = new JLabel("学号：");

    JTextField jtnumber = new JTextField("",20);

    JButton buttondelete = new JButton("删除");
    JButton buttonreturn = new JButton("返回");


    public Delete() {
        JPanel jpnumber = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));

        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);

        jpforbutton.add(buttondelete);
        jpforbutton.add(buttonreturn);

        buttondelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String number = jtnumber.getText();

                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;
                String sql = "DELETE FROM studentmanage WHERE number='"+number+"'";

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                }catch(Exception a){
                    a.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","123");
                    stat = conn.createStatement();
                    stat.executeUpdate(sql);
                }catch(SQLException h){
                    h.printStackTrace();

                }finally{
                    try{
                        conn.close();
                        System.out.println("close success!");
                    }catch(SQLException j){
                        System.out.println("close go die!");
                        j.printStackTrace();
                    }

                }

            }


        });

        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();
            }
        });


        this.setTitle("删除学生信息");
        this.setLayout(new GridLayout(9,1));
        this.add(jpnumber);
        this.add(jpforbutton);
        this.setLocation(400,300);
        this.setSize(350,300);
        this.setVisible(true);


    }



}