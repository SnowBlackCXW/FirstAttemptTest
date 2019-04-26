package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import First.Window;

public class Look extends JFrame {
    private static final long serialVersionUID = -1928970409928880648L;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet res = null;


    //JButton buttonlook = new JButton("浏览");
    //JButton buttonreturn = new JButton("返回");

    JTable jtable;
    JScrollPane jscrollpane = new JScrollPane();

    Vector columnNames = null;
    Vector rowData = null;

    public Look() {
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));

        columnNames = new Vector();
        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("出生日期");
        columnNames.add("学院");
        rowData = new Vector();

        //jpforbutton.add(buttonlook);
        //jpforbutton.add(buttonreturn);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
            ps = conn.prepareStatement("SELECT * FROM studentmanage");
            res = ps.executeQuery();
            while (res.next())
            {
                Vector hang = new Vector();
                hang.add(res.getString(1));
                hang.add(res.getString(2));
                hang.add(res.getString(3));
                hang.add(res.getString(4));
                hang.add(res.getString(5));
                rowData.add(hang);

            }
            System.out.println("load  ok!");
        }catch (Exception q){
            q.printStackTrace();
            System.out.println("go die");
        }finally{
            try{
                res.close();
                ps.close();
                conn.close();
                System.out.println("close ok");
            }catch (SQLException o){
                o.printStackTrace();
                System.out.println("go die 2");
            }
        }




        jtable = new JTable(rowData,columnNames);
        jscrollpane = new JScrollPane(jtable);

        this.add(jscrollpane);
        this.setTitle("浏览学生信息");
        this.setLayout(new GridLayout(2,5));
        this.add(jpforbutton);
        this.setLocation(300,300);
        this.setSize(500,300);
        this.setVisible(true);
        this.setResizable(false);

    }


}