package movie;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Foods {
    int count = 0;
    String show = "";
    Scanner scan = new Scanner(System.in);
    int sum = 0;
    int wholeMoney =0;

    public Foods() {
        JFrame frame = new JFrame("스낵");
        frame.setBounds(0, 0, 1500, 1000);
        frame.setBackground(Color.black);

        Panel North = new Panel();
        North.setLayout(null);
        North.setSize(0, 500);

        String[] menu = { "메인콤보", "더블콤보", "스몰콤보", "라지콤보", "고소팝콘(L)", "달콤팝콘(L)", "더블치즈팝콘(L)", "바질어니언팝콘(L)", "고소팝콘(M)",
                "버질어니언팝콘(M)", "달콤팝콘(M)", "더블치즈팝콘(M)", "콜라L", "사이다L", "콜라M", "사이다L", "칠리치즈나쵸", "플레인핫도그", "칠리치즈핫도그",
                "오징어" };
        int price[] = { 9000, 12000, 6500, 14000, 5000, 6000, 6000, 6000, 4500, 5500, 5500, 5500, 3000, 3000, 2500,
                2500, 4900, 4500, 5000, 3500 };
        JButton button[] = new JButton[menu.length];
        TextField subject[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton check[] = new JButton[menu.length];
        Label label[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];

        for (int i = 0; i < menu.length; i++) {

            button[i] = new JButton(menu[i]);
            if (i < 10) {
                button[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                button[i].setBounds(25 + (i - 10) * 150, 300, 100, 100);
            }
            icon[i] = new ImageIcon("image/" + i + ".jpg");
            button[i].setIcon(icon[i]);

            subject[i] = new TextField("0");
            subject[i].setBackground(Color.white);
            subject[i].setEditable(false);
            subject[i].setBounds(button[i].getX() + 30, button[i].getY() + 130, 40, 20);

            minus[i] = new Button("-");
            minus[i].setBounds(button[i].getX(), subject[i].getY(), 20, 20);
            minus[i].setEnabled(false);

            plus[i] = new Button("+");
            plus[i].setBounds(button[i].getX() + (100 - 20), subject[i].getY(), 20, 20);
            plus[i].setEnabled(false);

            label[i] = new Label(price[i] + "원");
            label[i].setBounds(button[i].getX() + 20, subject[i].getY() - 25, 100, 20);

            check[i] = new JButton("확인");
            check[i].setBounds(button[i].getX(), subject[i].getY() + 30, 100, 20);
            check[i].setEnabled(false);

            North.add(button[i]);
            North.add(subject[i]);
            North.add(minus[i]);
            North.add(plus[i]);
            North.add(label[i]);
            North.add(check[i]);
        }

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        가격        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);

        Panel South = new Panel();

        Button button1 = new Button("주문");
        Button button2 = new Button("초기화");
        Button button3 = new Button("뒤로");
        South.add(button1);
        South.add(button2);
        South.add(button3);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.length; i++) {
                    button[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    subject[i].setText("0");
                    ta.setText("      상품명           가격           수량           합계\n\n");

                }
                pay.isFood=true;
                try {
                    new pay();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    button[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    subject[i].setText("0");
                    ta.setText("   상품명        가격        수량        합계\n\n");

                }
                pay.foodMoney=0;
            }
        });

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Kiosk2();
                frame.setVisible(false);
            }
        });

        frame.add(North, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(South, BorderLayout.SOUTH);
        frame.setVisible(true);

        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;

            // 햄버그 버튼 이벤트
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    button[j].setEnabled(false);
                    check[j].setEnabled(true);

                    count = 0;
                }
            });

            // "-" 버튼 이벤트
            minus[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        subject[j].setText(count + "");
                        check[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });

            // "+" 버튼 이벤트
            plus[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    subject[j].setText(count + "");
                    check[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });

            // 확인 버튼 이벤트
            check[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    show = button[j].getActionCommand();
                    ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                            + "원" + "\n");
                    pay.foodMoney += price[j] * count;
                    check[j].setEnabled(false);
                }
            });
        }


    }

    public static void main(String[] args) {
        new Foods();
    }

}