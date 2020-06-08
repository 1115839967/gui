package com.gui.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gui.model.Student;
import com.gui.service.StudentService;
import com.gui.util.DateUtil;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private String[] columnCount = {"序号", "姓名", "成绩", "生日", "城市"};
    private List<Student> list;
    public static Student stu;
    public static MainFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new MainFrame();
                    //窗口居中
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 764, 469);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 58, 692, 332);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton button = new JButton("查询");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quaryAll();
            }
        });
        button.setBounds(58, 22, 93, 23);
        contentPane.add(button);

        JButton button1 = new JButton("添加");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FromFjame().setVisible(true);
            }
        });
        button1.setBounds(205, 22, 93, 23);
        contentPane.add(button1);
        //全屏
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

        JButton button2 = new JButton("修改");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                quaryAll();
            }
        });
        button2.setBounds(357, 22, 93, 23);
        contentPane.add(button2);

        JButton button3 = new JButton("删除");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
                quaryAll();
            }
        });
        button3.setBounds(539, 22, 93, 23);
        contentPane.add(button3);

    }

    /**
     * 查询
     */
    public void quaryAll() {
        StudentService ss = new StudentService();
        list = ss.queryAll();
        if (list == null) {
            JOptionPane.showMessageDialog(null, "服务器繁忙");
            return;
        }
        Object[][] data = DateUtil.listToArray(list);
        table.setModel(new DefaultTableModel(data, columnCount));
    }

    /**
     * 删除
     */
    private void remove() {
        int i = table.getSelectedRow();
        Student s = list.get(i);
        int code = new StudentService().delete(s.getId());
        if (code == 0) {
            JOptionPane.showMessageDialog(null, "删除成功");
            return;
        } else {
            JOptionPane.showMessageDialog(null, DateUtil.errors.get(code));
        }
        quaryAll();
    }

    /**
     * 修改
     */
    private void update() {
        int i = table.getSelectedRow();
        stu = list.get(i);
        new FromFjame().setVisible(true);
    }
}
