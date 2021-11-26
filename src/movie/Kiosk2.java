package movie;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Kiosk2 extends JFrame {
    Kiosk2() {
        setTitle("키오스크");
        super.setPreferredSize(new Dimension(300, 230));
        setLayout(new GridLayout(3, 1));
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(1, 2));

        JPanel panel2 = new JPanel();
        JButton button1 = new JButton("영화예매");
        JButton button2 = new JButton("매점");
        panel2.add(button1);
        panel2.add(button2);
        add(panel2);

        super.pack();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new movieReservation1().setFrame();
                dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new Snack().setFrame();
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new Kiosk2();
    }

}
