package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;

public class Ask extends JFrame {
    private static final long serialVersionUID = -1928970409928880648L;

    JLabel jlnumber = new JLabel("学号：");
    JLabel jlname = new JLabel("姓名：");
    JLabel jlsex = new JLabel("性别：");
    JLabel jlbirthday = new JLabel("出生日期：");
    JLabel jldepartment = new JLabel("学院：");

    JTextField jtnumber = new JTextField("",20);
    JLabel jname = new JLabel();
    JLabel jsex = new JLabel();
    JLabel jbirthday = new JLabel();
    JLabel jdepartment = new JLabel();

    JButton buttonask = new JButton("查询");
    JButton buttonreturn = new JButton("返回");


    public Ask() {
        JPanel jpnumber = new JPanel();
        JPanel jpname = new JPanel();
        JPanel jpsex = new JPanel();
        JPanel jpbirthday = new JPanel();
        JPanel jpdepartment = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));

        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);

        jpname.add(jlname);
        jpname.add(jname);

        jpsex.add(jlsex);
        jpsex.add(jsex);

        jpbirthday.add(jlbirthday);
        jpbirthday.add(jbirthday);

        jpdepartment.add(jldepartment);
        jpdepartment.add(jdepartment);

        jpforbutton.add(buttonask);
        jpforbutton.add(buttonreturn);

        buttonask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;

                String sql = "SELECT number,name,sex,birthday,department FROM studentmanage";
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                }catch(Exception d){
                    System.out.println("jdbc fall");
                    d.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
                    stat=conn.createStatement();
                    res=stat.executeQuery(sql);
                    while (res.next())
                    {
                        if (res.getString(1).equals(jtnumber.getText()))
                        {
                            jname.setText(res.getString(2));
                            jsex.setText(res.getString(3));
                            jbirthday.setText(res.getString(4));
                            jdepartment.setText(res.getString(5));

                            break;
                        }
                    }
                }catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();


                }
                finally{
                    try{
                        conn.close();
                    }catch(SQLException ar){
                        ar.printStackTrace();
                    }

                }}}

        );

        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();
            }
        });


        this.setTitle("查询学生信息");
        this.setLayout(new GridLayout(9,1));
        this.add(jpnumber);
        this.add(jpname);
        this.add(jpsex);
        this.add(jpbirthday);
        this.add(jpdepartment);
        this.add(jpforbutton);
        this.setLocation(400,300);
        this.setSize(350,300);
        this.setVisible(true);


    }


}