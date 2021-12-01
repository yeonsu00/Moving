package movie;

import mgr.Manageable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Seats extends JFrame implements Manageable {

    Seat[][] seatArray;
    String hallName;


    Seats(String hallName) {
        setTitle("자리 예매");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setPreferredSize(new Dimension(1000, 600));
        setResizable(false);
        setLayout(new GridLayout(2, 1));

        JPanel allScreenPanel = new JPanel(new BorderLayout());
        addScreenPanelTo(allScreenPanel);
        addOperPanelTo(allScreenPanel);
        this.add(allScreenPanel);

        JPanel allSeatPanel = makeSeatPanelTo();
        this.add(allSeatPanel);
        this.hallName = hallName;
        readCurrentSeat(this.hallName);

        super.pack();
        setVisible(true);
    }

    private JPanel makeSeatPanelTo() {
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
            seatSignPanel.add(new JLabel(Character.toString((char) ('A' + i))));
        }

        seatArray = new Seat[10][16];

        for (int i = 0; i < seatArray.length; i++) {
            for (int j = 0; j < 16; j++) {
                seatArray[i][j] = new Seat(i, j, Integer.toString(j + 1));

                if (j < 2) {
                    if (j == 0) {
                        seatPanel1.add(new JLabel(Character.toString((char) ('A' + i))));
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

        return allSeatPanel;
    }

    private void addOperPanelTo(JPanel allScreenPanel) {
        JPanel operButtonPanel = new JPanel(new FlowLayout());
        JButton goBack = new JButton("←");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new movieReservation2(movieReservation2.code).setFrame();
                dispose();

            }
        });

        JButton goForward = new JButton("→");
        goForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Seat> checkedSeat = new ArrayList<>();
                    boolean isZero = true;
                    for (Seat[] sArr : seatArray) {
                        for (Seat sArr2 : sArr) {
                            if (sArr2.isChecked == true) {
                                checkedSeat.add(sArr2);
                                isZero = false;
                                //이 부분부터 좌석정보 텍스트 저장입니다.
                                System.out.println("좌석: ["+sArr2.x+"],["+sArr2.y+"]");
                                BufferedWriter bw = new BufferedWriter(new FileWriter("tempSeatInfo.txt", true));
                                int num=sArr2.x;
                                String info="";
                                switch (num) {
                                    case 0:
                                        info="A-"+sArr2.y+" ";
                                        break;
                                    case 1:
                                        info="B-"+sArr2.y+" ";
                                        break;
                                    case 2:
                                        info="C-"+sArr2.y+" ";
                                        break;
                                    case 3:
                                        info="D-"+sArr2.y+" ";
                                        break;
                                    case 4:
                                        info="E-"+sArr2.y+" ";
                                        break;
                                    case 5:
                                        info="F-"+sArr2.y+" ";
                                        break;
                                    case 6:
                                        info="G-"+sArr2.y+" ";
                                        break;
                                    case 7:
                                        info="H-"+sArr2.y+" ";
                                        break;
                                    case 8:
                                        info="I-"+sArr2.y+" ";
                                        break;
                                    case 9:
                                        info="J-"+sArr2.y+" ";
                                        break;


                                    default: num = 10;
                                        break;
                                }

                                bw.write(info);
                                bw.close();
                            }
                        }
                    }
                    if (isZero == true) {
                        JOptionPane.showMessageDialog(null, "좌석 선택을 마치세요.");
                        return;
                    }

                    pay.selectedSeatArr = checkedSeat;
                    pay.hallName = hallName;

                    new pay();
                    dispose();
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
        allScreenPanel.add(operButtonPanel, BorderLayout.WEST); // 스크린 추가
    }

    public static void main(String args[]) {
        Seats mSeat = new Seats("seats");
    }

    @Override
    public void read(Scanner scan) {

    }


    public void print() {

    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }

    public void readCurrentSeat(String hallName) {
        BufferedReader reader = null;
        String[] curSeatTxt = new String[16];
        try {
            reader = new BufferedReader(
                    new FileReader(hallName + ".txt")
            );

            String str;
            int count = 0;
            while ((str = reader.readLine()) != null) {
                curSeatTxt[count] = str;
                count++;
                System.out.println(str);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        changeReserved(curSeatTxt);

    }

    public void changeReserved(String[] curSeatTxt) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 16; j++) {
                if (curSeatTxt[i].charAt(j) == '1') {
                    seatArray[i][j].setBackground(Color.BLACK);
                    System.out.println(i + "  " + j);
                }
            }
        }
    }

    private void addScreenPanelTo(JPanel allScreenPanel) {
        JLabel screenLabel = new JLabel("Screen");
        screenLabel.setFont(new Font("Serif", Font.BOLD, 30));
        setForeground(Color.WHITE);
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.black);

        JPanel screenPanel = new JPanel(new GridLayout());
        screenLabel.setHorizontalAlignment(JLabel.CENTER);
        screenPanel.add(screenLabel);

        allScreenPanel.add(screenPanel, BorderLayout.CENTER); // 스크린 추가


    }


}
