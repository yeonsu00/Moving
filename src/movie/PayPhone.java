package movie;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
//인증번호 존재해야 결제가능(텍스트파일내에)
class PayPhone extends JFrame implements ActionListener {

    JPanel panel;
    JLabel lblwords, lblname,lblnumber;
    JButton b1, b2;
    JTextField txtwords, txtname,txtnumber;

    PayPhone() {
        setTitle("Pay phone");
        setSize(300,300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        lblname = new JLabel("NAME");
        lblnumber = new JLabel("Phone Num");
        lblwords = new JLabel("Word(4자리)");


        txtname = new JTextField(10);
        txtnumber = new JTextField(12);
        txtwords = new JTextField(4);

        b1 = new JButton("결제");
        b2 = new JButton("취소");

        panel.add(lblname);
        panel.add(txtname);
        panel.add(lblnumber);
        panel.add(txtnumber);
        panel.add(lblwords);
        panel.add(txtwords);

        panel.add(b1);
        panel.add(b2);

        add(panel);

        b1.addActionListener(this);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new pay();
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String s = null;
            boolean isOk = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter("words.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("words.txt"));

            if (e.getSource() == b1) {
                while ((s = br.readLine()) != null) {
                    // 비밀번호 중복확인
                    String[] array = s.split("/");
                    if (array[2].equals(txtwords.getText())) {
                        isOk = true;
                        break;
                    }

                }
                // 정보 입력시 중복이 없으면 데이터 보냄
                if (isOk) {

                    bw.write(txtname.getText() + "/");
                    bw.write(txtnumber.getText() + "/");
                    bw.write(txtwords.getText() + "\n");
                    bw.close();

                    JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "결제에 실패하였습니다.");
                }

            } else if (e.getSource() == b2) {
                dispose();
                txtname.setText("");
                txtnumber.setText("");
                txtwords.setText("");

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }



}

