package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;

public class Change extends JFrame {
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

    JButton buttonchange = new JButton("修改");
    JButton buttonreturn = new JButton("返回");


    public Change() {
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

        jpforbutton.add(buttonchange);
        jpforbutton.add(buttonreturn);

        buttonchange.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String number = jtnumber.getText();
                String name = jtname.getText();
                String sex = jtsex.getText();
                String birthday = jtbirthday.getText();
                String department = jtdepartment.getText();

                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;

                String sql = "SELECT number,name,sex,birthday,department FROM studentmanage;";
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                }catch(Exception d){
                    System.out.println("jdbc fall");
                    d.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","123");
                    stat=conn.createStatement();
                    res=stat.executeQuery(sql);
                    while (res.next())
                    {
                        //change
                        if (res.getString(1).equals(jtnumber.getText()))
                        {
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                            }catch(Exception d){
                                System.out.println("jdbc fall");
                                d.printStackTrace();
                            }

                            String sql2="UPDATE studentmanage SET name='"+name+"'  WHERE number='"+jtnumber.getText()+"'";
                            String sql3="UPDATE studentmanage SET sex='"+sex+"'  WHERE number='"+jtnumber.getText()+"'";
                            String sql4="UPDATE studentmanage SET birthday='"+birthday+"'  WHERE number='"+jtnumber.getText()+"'";
                            String sql5="UPDATE studentmanage SET department='"+department+"'  WHERE number='"+jtnumber.getText()+"'";
                            try {
                                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
                                stat=conn.createStatement();
                                stat.executeUpdate(sql2);
                                stat.executeUpdate(sql3);
                                stat.executeUpdate(sql4);
                                stat.executeUpdate(sql5);
                            } catch (SQLException g) {
                                // TODO Auto-generated catch block
                                g.printStackTrace();
                            }try{
                            stat.close();
                            conn.close();
                        }catch(SQLException ar){
                            ar.printStackTrace();
                        }

                            break;
                        }

                        //change end
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

                }

            }


        });


        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();
            }
        });

        this.setTitle("修改学生信息");
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