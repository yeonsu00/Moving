package movie;

import mgr.Factory;
import mgr.Manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Kiosk2 extends JFrame {
    Kiosk2() {
        //setTitle("키오스크");
        JFrame jf = new JFrame("키오스크");
        jf.setSize(1950, 1040);
       // jf.setLocation(700, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel();
        ImageIcon btnReservation = new ImageIcon("image/btnReservation.png");
        Image image1 = btnReservation.getImage();
        Image changeImg1 = image1.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);
        JLabel la1 = new JLabel(changeIcon1);

        ImageIcon btnFood = new ImageIcon("image/btnFood.png");
        Image image2 = btnFood.getImage();
        Image changeImg2 = image2.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);
        JLabel la2 = new JLabel(changeIcon2);

        panel2.add(la1);
        panel2.add(la2);
        jf.add("North", panel2);
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        JPanel loginPanel = new JPanel();
        //JPanel noPanel = new JPanel();
        JButton loginBtn = new JButton("로그인 및 회원가입");

        JPanel imgPanel = new JPanel();
        ImageIcon img = new ImageIcon("image/KioskImg.png");
        Image image3 = img.getImage();
        Image changeImg3 = image3.getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);

        JLabel la3 = new JLabel(changeIcon3);
        imgPanel.add(la3);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        JPanel jp3 = new JPanel();
        jp3.setLayout(new BorderLayout());

        loginPanel.add(loginBtn);
        jp1.add("Center", loginPanel);
        jp2.add("Center", imgPanel);

        jp3.add("North", jp1);
        jp3.add("Center", jp2);
        jp.add(jp3);
        jf.add("Center", jp);
        // jf.getContentPane().setBackground(Color.WHITE);


        la1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new movieReservation1().setFrame();
                jf.dispose();
            }
        });


        la2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Foods();
                jf.dispose();
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                jf.dispose();
            }
        });
        jf.setVisible(true);
        setLocationRelativeTo(null);
    }

    Kiosk2(int i) {
        JFrame jf2 = new JFrame("키오스크");
        jf2.setSize(1950, 1040);
       // jf2.setLocation(700, 400);
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel();
        ImageIcon btnReservation = new ImageIcon("image/btnReservation.png");
        Image image1 = btnReservation.getImage();
        Image changeImg1 = image1.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);
        JLabel la1 = new JLabel(changeIcon1);

        ImageIcon btnFood = new ImageIcon("image/btnFood.png");
        Image image2 = btnFood.getImage();
        Image changeImg2 = image2.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);
        JLabel la2 = new JLabel(changeIcon2);

        panel2.add(la1);
        panel2.add(la2);
        jf2.add("North", panel2);
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

//        JPanel loginPanel = new JPanel();
//        //JPanel noPanel = new JPanel();
//        JButton loginBtn = new JButton("로그인 및 회원가입");

        JPanel imgPanel = new JPanel();
        ImageIcon img = new ImageIcon("image/KioskImg.png");
        Image image3 = img.getImage();
        Image changeImg3 = image3.getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);

        JLabel la3 = new JLabel(changeIcon3);
        imgPanel.add(la3);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        JPanel jp3 = new JPanel();
        jp3.setLayout(new BorderLayout());

//        loginPanel.add(loginBtn);
//        jp1.add("Center", loginPanel);
        jp2.add("Center", imgPanel);

        jp3.add("North", jp1);
        jp3.add("Center", jp2);
        jp.add(jp3);
        jf2.add("Center", jp);
        // jf.getContentPane().setBackground(Color.WHITE);


        la1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new movieReservation1().setFrame();
                jf2.dispose();
            }
        });


        la2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Foods();
                jf2.dispose();
            }
        });

//        loginBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new Login();
//                dispose();
//            }
//        });
        jf2.setVisible(true);


//        setTitle("키오스크");
//        super.setPreferredSize(new Dimension(1000, 500));
//        setLayout(new GridLayout(3, 1));
//        JPanel namePanel = new JPanel();
//        namePanel.setLayout(new GridLayout(1, 2));
//
//        JPanel panel2 = new JPanel();
////        JButton button1 = new JButton("영화예매");
////        JButton button2 = new JButton("매점");
//
//        ImageIcon btnReservation = new ImageIcon("image/btnReservation.png");
//        Image image1 = btnReservation.getImage();
//        Image changeImg1 = image1.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
//        ImageIcon changeIcon1 = new ImageIcon(changeImg1);
//
//        JLabel la1 = new JLabel(changeIcon1);
//
//        ImageIcon btnFood = new ImageIcon("image/btnFood.png");
//        Image image2 = btnFood.getImage();
//        Image changeImg2 = image2.getScaledInstance(360, 200, Image.SCALE_SMOOTH);
//        ImageIcon changeIcon2 = new ImageIcon(changeImg2);
//
//        JLabel la2 = new JLabel(changeIcon2);
//
////        ImageIcon img = new ImageIcon("image/KioskImg.png");
////        Image image3 = img.getImage();
////        Image changeImg3 = image3.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
////        ImageIcon changeIcon3 = new ImageIcon(changeImg3);
////
////        JLabel la3 = new JLabel(changeIcon3);
//
//        panel2.add(la1);
//        panel2.add(la2);
//        //panel3.add(la3);
//        add(panel2);
//        //add(panel3);
//
//        super.pack();
//
//        la1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                new movieReservation1().setFrame();
//                dispose();
//            }
//        });
//
//
//        la2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                new Foods();
//                dispose();
//            }
//        });
//
//        setVisible(true);
    }

    public static void main(String[] args) {
        new Kiosk2();
    }

}