package movie;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Login extends JFrame {
    Font f1;

    public Login() {
        setTitle("로그인");
//    	출처: https://msource.tistory.com/3 [MLog]
//        f1 = new Font("", Font.PLAIN, 15);
        super.setPreferredSize(new Dimension(300, 230));
        setLayout(new GridLayout(3, 1));
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(1, 2));
        JLabel lb2 = new JLabel("Name:");
        lb2.setHorizontalAlignment(JLabel.CENTER);
        namePanel.add(lb2);
        JTextField tf1 = new JTextField();
        namePanel.add(tf1);
        add(namePanel);

        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new GridLayout(1, 2));
        JLabel lb3 = new JLabel("Phone Number:");
        lb3.setHorizontalAlignment(JLabel.CENTER);
        phonePanel.add(lb3);
        JTextField tf2 = new JTextField();
        phonePanel.add(tf2);
        add(phonePanel);

        JPanel panel1 = new JPanel();
        JButton bt1 = new JButton("Login");
        JButton bt2 = new JButton("Register");
        panel1.add(bt1);
        panel1.add(bt2);
        add(panel1);

        super.pack();

//        JLabel lb1 = new JLabel();
//        lb1.setBounds(20, 200, 300, 50);
//        lb1.setFont(f1);
//
//        JLabel lb2 = new JLabel("Name:");
//        lb2.setBounds(20, 50, 80, 30);
//        lb2.setFont(f1);
//
//        JTextField tf1 = new JTextField();
//        tf1.setBounds(170, 50, 100, 30);
//        tf1.setFont(f1);
//
//        JLabel lb3 = new JLabel("Phone number:");
//        lb3.setBounds(20, 100, 160, 30);
//        lb3.setFont(f1);
//
//        JTextField pw1 = new JTextField();
//        pw1.setBounds(170, 100, 100, 30);
//        pw1.setFont(f1);
//
//        JButton bt1 = new JButton("Login");
//        bt1.setBounds(100, 150, 160, 30);
//        bt1.setFont(f1);
//
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] userIdInfo = new String[2];
                userIdInfo[0] = tf1.getText();
                userIdInfo[1] = tf2.getText();
//                System.out.println(userIdInfo[0]);
//                System.out.println(userIdInfo[1]);
                compare(userIdInfo);
            }

        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Members();
            }
        });
//
//        add(lb1);
//        add(pw1);
//        add(lb2);
//        add(tf1);
//        add(lb3);
//        add(bt1);
//        setTitle("Login");
//        setSize(320, 320);
//        setLayout(new GridLayout(2, 2));
//        setLayout(null);
        setVisible(true);
    }

    public void compare(String[] userIdInfo) {
        try {
            String s = null;
            boolean isOk = false;
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));

            while ((s = br.readLine()) != null) {
                // 핸드폰번호 중복확인
                String[] array = s.split("/");
                System.out.println(array[1]);
                if (array[1].equals(userIdInfo[1])) {
                    System.out.println("번호 매칭");
                    if (array[0].equals(userIdInfo[0])) {
                        isOk = true;
                        break;
                    }
                }

            }
            // 정보 입력시 중복이 없으면 데이터 보냄
            if (isOk) {
                JOptionPane.showMessageDialog(null, "로그인에 성공");
                dispose();
                //new Kiosk().run();
                new Kiosk2(1);

            } else {
                JOptionPane.showMessageDialog(null, "아이디가 없습니다. 회원가입이 필요합니다.");
                new Members();
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}