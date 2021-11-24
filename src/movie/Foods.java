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
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mgr.Factory;
import mgr.Manager;

public class Foods {
    int count = 0;
    String show = "";
    Scanner scan = new Scanner(System.in);
    static Manager<Food> foodMgr = new Manager();

    void run() {
        foodMgr.readAll("food.txt", new Factory<Food>() {
            public Food create() {
                return new Food();
            }
        });
        foods();
    }

    void foods() {
        ArrayList<Food> foodList = new ArrayList<>();
        JFrame frame = new JFrame("스낵");
        frame.setBounds(0, 0, 1500, 1000);
        frame.setBackground(Color.black);

        Panel North = new Panel();
        North.setLayout(null);
        North.setSize(0, 500);

        ArrayList<Food> menu = foodList;
        JButton button[] = new JButton[menu.size()];
        TextField subject[] = new TextField[menu.size()];
        Button minus[] = new Button[menu.size()];
        Button plus[] = new Button[menu.size()];
        JButton check[] = new JButton[menu.size()];
        Label label[] =new Label[menu.size()];
        ImageIcon icon[] = new ImageIcon[menu.size()];

        // 버튼 설정 부분
        for (int i = 0; i < menu.size(); i++) {

            button[i] = new JButton(menu.get(i).name);
            if (i < 10) {
                button[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                button[i].setBounds(25 + (i - 10) * 150, 300, 100, 100);
            }
            icon[i] = new ImageIcon("C://Users//user//Desktop//객체//" + i + ".jpg");
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

            label[i] = new Label(menu.get(i).price + "원");
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

        // 중앙
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);

        // 남쪽
        Panel South = new Panel();

        Button button1 = new Button("주문");
        Button button2 = new Button("초기화");
        Button button3 = new Button("닫기");
        South.add(button1);
        South.add(button2);
        South.add(button3);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.size(); i++) {
                    button[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    subject[i].setText("0");
                    ta.setText("      상품명           단가           수량           합계\n\n");

                }
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.size(); i++) {
                    button[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    subject[i].setText("0");
                    ta.setText("   상품명        단가        수량        합계\n\n");

                }
            }
        });

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(North, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(South, BorderLayout.SOUTH);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 이벤트단
        for (int i = 0; i < menu.size(); i++) {
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
                    ta.append("   " + show + "       " + menu.get(j).price + "        " + count + "         "
                            + menu.get(j).price * count + "원" + "\n");
                    check[j].setEnabled(false);
                }
            });

        }

        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    static Food findItem(String kwd) {
        return (Food) foodMgr.find(kwd);
    }

    public static void main(String[] args) {
        Foods f = new Foods();
        f.run();
    }

}