package movie;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

class Members extends JFrame implements ActionListener {

    JPanel panel;
    JLabel lblphone, lblname;
    JButton b1, b2;
    JTextField txtphone, txtname;

    Members() {
        setTitle("회원가입");
        setSize(300, 150);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        lblname = new JLabel("NAME");
        lblphone = new JLabel("PHONE NUMBER");

        txtname = new JTextField(10);
        txtphone = new JTextField(20);

        b1 = new JButton("가입");
        b2 = new JButton("취소");

        panel.add(lblname);
        panel.add(txtname);
        panel.add(lblphone);
        panel.add(txtphone);

        panel.add(b1);
        panel.add(b2);

        add(panel);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String s = null;
            boolean isOk = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));

            if (e.getSource() == b1) {
                while ((s = br.readLine()) != null) {
                    // 핸드폰번호 중복확인
                    String[] array = s.split("/");
                    if (array[1].equals(txtphone.getText())) {
                        isOk = true;
                        break;
                    }

                }
                // 정보 입력시 중복이 없으면 데이터 보냄
                if (!isOk) {

                    bw.write(txtname.getText() + "/");
                    bw.write(txtphone.getText() + "\n");
                    bw.close();

                    JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
                }

            } else if (e.getSource() == b2) {
                dispose();
                txtname.setText("");
                txtphone.setText("");

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }

    public static void main(String[] args) {
        new Members();
    }

}