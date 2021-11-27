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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Seat extends JFrame implements Manageable{
    String[] curSeat = new String[16];
    JButton[][] seatArray;
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
        goForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new pay();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
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

        seatArray = new JButton[10][16];

        for (int i = 0; i < seatArray.length; i++) {
            for (int j = 0; j < 16; j++) {
                seatArray[i][j] = new JButton(Integer.toString(j + 1));
                seatArray[i][j].setBackground(Color.CYAN);
                seatArray[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBut = (JButton) e.getSource();
                        if (srcBut.getBackground()==Color.RED)
                        {
                            srcBut.setBackground(Color.CYAN);
                        }
                        else if(srcBut.getBackground()==Color.CYAN)
                        {
                            srcBut.setBackground(Color.RED);
                        }

                    }
                });
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
//        allSeatPanel.add(radioPanel);
        add(allSeatPanel);

        super.pack();

        setVisible(true);
    }

    public static void main(String args[]) {
        Seat mSeat = new Seat();
        mSeat.readCurrentSeat();
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

    public void readCurrentSeat() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("seats.txt")
            );

        String str;
        int count=0;
        while ((str = reader.readLine()) != null) {
            curSeat[count] = str;
            count++;
            System.out.println(str);
        }

        reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        changeReserved();

    }
    public void changeReserved()
    {
        for (int i=0;i<10;i++)
        {
            for (int j = 0; j < 16; j++) {
                if (this.curSeat[i].charAt(j)=='1')
                {
                    seatArray[i][j].setBackground(Color.BLACK);
                    System.out.println(i+"  "+j);
                }
            }
        }
    }

}
