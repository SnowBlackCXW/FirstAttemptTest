package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mysql.jdbc.Driver;

import First.Window;

public class Add extends JFrame {
    private static final long serialVersionUID = -1928970409928880648L;

    JLabel jlnumber = new JLabel("学号：");
    JLabel jlname = new JLabel("姓名：");
    JLabel jlsex = new JLabel("性别：");
    JLabel jlbirthday = new JLabel("出生日期：");
    JLabel jldepartment = new JLabel("学院：");

    JTextField jtnumber = new JTextField("",20);
    JTextField jtname = new JTextField("",20);
    JTextField jtsex = new JTextField("",20);
    JTextField jtbirthday = new JTextField("",20);
    JTextField jtdepartment = new JTextField("",20);

    JButton buttonadd = new JButton("添加");
    JButton buttonreturn = new JButton("返回");


    public Add() {
        JPanel jpnumber = new JPanel();
        JPanel jpname = new JPanel();
        JPanel jpsex = new JPanel();
        JPanel jpbirthday = new JPanel();
        JPanel jpdepartment = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));

        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);

        jpname.add(jlname);
        jpname.add(jtname);

        jpsex.add(jlsex);
        jpsex.add(jtsex);

        jpbirthday.add(jlbirthday);
        jpbirthday.add(jtbirthday);

        jpdepartment.add(jldepartment);
        jpdepartment.add(jtdepartment);

        jpforbutton.add(buttonadd);
        jpforbutton.add(buttonreturn);

        buttonadd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                //Add
                Connection conn = null;
                Statement stat = null;
                PreparedStatement ps=null;
                String sql = "INSERT INTO studentmanage(number,name,sex,birthday,department) "
                        + "values(?,?,?,?,?)";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("JBDC 加载成功!");
                }catch(Exception a){
                    System.out.println("JBDC 狗带!");
                    a.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
                    ps=conn.prepareStatement(sql);

                    ps.setString(1,jtnumber.getText());
                    ps.setString(2,jtname.getText());
                    ps.setString(3,jtsex.getText());
                    ps.setString(4,jtbirthday.getText());
                    ps.setString(5,jtdepartment.getText());

                    ps.executeUpdate();

                    System.out.println("MySQL 连接成功!");
                    //stat = conn.createStatement();
                    //stat.executeUpdate(sql);
                    System.out.println("插入数据成功!");

                }catch (SQLException b){
                    b.printStackTrace();
                }finally{
                    try{
                        conn.close();
                        System.out.println("MySQL 关闭成功");
                    }catch (SQLException c){
                        System.out.println("MySQL 关闭失败 ");
                        c.printStackTrace();
                    }

                }


            }}

        );

        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();
            }
        });


        this.setTitle("添加学生信息");
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