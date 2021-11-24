package movie;

import mgr.Manageable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat extends JFrame implements Manageable {

    Seat() {
        setTitle("자리 예매");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setPreferredSize(new Dimension(1000, 600));
        setResizable(false);
        setLayout(new GridLayout(2, 1));

        JLabel screenLabel = new JLabel("Screen");
        screenLabel.setFont(new Font("Serif", Font.BOLD, 30));
        setForeground(Color.WHITE);
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.black);

        JPanel screenPanel = new JPanel(new GridLayout());
        screenLabel.setHorizontalAlignment(JLabel.CENTER);
        screenPanel.add(screenLabel);

        JPanel allScreen = new JPanel(new BorderLayout());

        allScreen.add(screenPanel, BorderLayout.CENTER); // 스크린 추가

        JPanel operButtonPanel = new JPanel(new FlowLayout());
        JButton goBack = new JButton("←");
        JButton goForward = new JButton("→");
        goBack.setPreferredSize(new Dimension(60, 30));
        goForward.setPreferredSize(new Dimension(60, 30));
        operButtonPanel.add(goBack);
        operButtonPanel.add(goForward);
        operButtonPanel.setPreferredSize(new Dimension(70, 0));
        allScreen.add(operButtonPanel, BorderLayout.WEST); // 스크린 추가
        add(allScreen);

        JPanel allSeatPanel = new JPanel();
        allSeatPanel.setLayout(new FlowLayout());

        JPanel seatSignPanel = new JPanel(new GridLayout(10, 0));

        JPanel seatPanel1 = new JPanel(new GridLayout(0, 3));
        JPanel seatPanel2 = new JPanel(new GridLayout(0, 2));

        JPanel seatPanel3 = new JPanel(new GridLayout(0, 4));
        JPanel seatPanel4 = new JPanel(new GridLayout(0, 4));

        JPanel seatPanel5 = new JPanel(new GridLayout(0, 2));
        JPanel seatPanel6 = new JPanel(new GridLayout(0, 2));

        JPanel aisle1 = new JPanel();
        aisle1.setPreferredSize(new Dimension(70, 0));
        JPanel aisle2 = new JPanel();
        aisle2.setPreferredSize(new Dimension(70, 0));

        for (int i = 0; i < 10; i++) {
            seatSignPanel.add(new JLabel(Character.toString((char)('A' + i))));
        }

        JButton[][] seatArray = new JButton[10][16];

        for (int i = 0; i < seatArray.length; i++) {
            for (int j = 0; j < 16; j++) {
                seatArray[i][j] = new JButton(Integer.toString(j + 1));
                if (j < 2) {
                    if (j == 0) {
                        seatPanel1.add(new JLabel(Character.toString((char)('A' + i))));
                    }
                    seatPanel1.add(seatArray[i][j]);

                } else if (2 <= j && j <= 3) {
                    seatPanel2.add(seatArray[i][j]);
                } else if (4 <= j && j <= 7) {
                    seatPanel3.add(seatArray[i][j]);

                } else if (8 <= j && j <= 11) {
                    seatPanel4.add(seatArray[i][j]);

                } else if (12 <= j && j <= 13) {
                    seatPanel5.add(seatArray[i][j]);
                } else if (13 < j) {
                    seatPanel6.add(seatArray[i][j]);
                }

            }

        }

        allSeatPanel.add(seatPanel1);
        allSeatPanel.add(seatPanel2);
        allSeatPanel.add(aisle1);
        allSeatPanel.add(seatPanel3);
        allSeatPanel.add(seatPanel4);
        allSeatPanel.add(aisle2);
        allSeatPanel.add(seatPanel5);
        allSeatPanel.add(seatPanel6);

        add(allSeatPanel);

        super.pack();

//        button1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //new movieReservation();
//            }
//        });

        setVisible(true);
    }

    public static void main(String args[]) {
        new Seat();
    }

    @Override
    public void read(Scanner scan) {

    }

    @Override
    public void print() {

    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }
}
