package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window {
    public static void main(String[] args){
        JFrame jframe = new JFrame("学生管理系统") ; //window
        Dimension d = new Dimension(400,300);
        Point p = new Point (250,350);

        jframe.setSize(d);
        jframe.setLocation(p);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        JButton button1 = new JButton("添加");
        JButton button2 = new JButton("修改");
        JButton button3 = new JButton("查询");
        JButton button4 = new JButton("删除");
        JButton button5 = new JButton("浏览");

        FlowLayout flow = new FlowLayout(FlowLayout.LEFT,10,10);
        JPanel panel = new JPanel(flow);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        jframe.add(panel);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Add add = new Add();

            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Change change = new Change();
            }
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ask ask = new Ask();
            }
        });

        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Delete delete = new Delete();
            }
        });

        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Look look = new Look();
            }
        });

    }

}