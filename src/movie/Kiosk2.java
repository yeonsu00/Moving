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
        setTitle("키오스크");
        super.setPreferredSize(new Dimension(1000, 500));
        setLayout(new GridLayout(3, 1));
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(1, 2));

        JPanel panel2 = new JPanel();
//        JButton button1 = new JButton("영화예매");
//        JButton button2 = new JButton("매점");

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
        add(panel2);

        super.pack();

        la1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new movieReservation1().setFrame();
                dispose();
            }
        });


        la2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Foods();
                dispose();
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new Kiosk2();
    }

}