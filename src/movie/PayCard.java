package movie;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
//카드번호 존재해야 결제가능(텍스트파일내에)
class PayCard extends JFrame implements ActionListener {
    JComboBox<String> listcards;
    JPanel panel,box;
    JLabel lblcard, lblname, lblcards;
    JButton b1, b2;

    JTextField txtcard, txtname;



    PayCard() {
        setTitle("Card");

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box=new JPanel(new FlowLayout());
        listcards=new JComboBox();
        listcards.setModel(new DefaultComboBoxModel(new String[] {"KB", "NH", "Woori", "Shinhan"}));
        lblcards = new JLabel("CARDS");
        box.add(lblcards);
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));


        lblname = new JLabel("NAME");
        lblcard = new JLabel("Card NUMBER");


        txtname = new JTextField(20);
        txtcard = new JTextField(20);

        b1 = new JButton("결제");
        b2 = new JButton("취소");

        panel.add(lblname);
        panel.add(txtname);
        panel.add(lblcard);
        panel.add(txtcard);

        panel.add(b1);
        panel.add(b2);

        box.add(listcards);
        add(box,BorderLayout.NORTH);

        add(panel,BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new pay();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    new FileOutputStream("tempSeatInfo.txt").close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                setVisible(false);
            }
        });
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String s = null;
            boolean isOk = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter("cards.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("cards.txt"));

            if (e.getSource() == b1) {
                while ((s = br.readLine()) != null) {
                    // 카드번호 중복확인
                    String[] array = s.split("/");
                    if (array[1].equals(txtcard.getText())) {
                        isOk = true;
                        break;
                    }

                }
                // 정보 입력시 중복이 없으면 데이터 보냄
                if (isOk) {

                    bw.write(txtname.getText() + "/");
                    bw.write(txtcard.getText() + "\n");
                    bw.close();
                    new payFin();
                   // JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "결제에 실패하였습니다.");
                }

            } else if (e.getSource() == b2) {
                dispose();
                txtname.setText("");
                txtcard.setText("");

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }



}