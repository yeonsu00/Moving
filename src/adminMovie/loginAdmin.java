package adminMovie;

import movie.Kiosk;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
//비밀번호 존재해야 결제가능(텍스트파일내에)
class loginAdmin extends JFrame implements ActionListener {

    JPanel panel;
    JLabel lblpassword, lblid;
    JButton b1, b2;
    JTextField txtpassword, txtid;

    loginAdmin() {
        setTitle("Login Admin");
        setSize(400,400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        lblid = new JLabel("ID");
        lblpassword = new JLabel("Password(6자리)");

        txtid = new JTextField(5);
        txtpassword = new JTextField(6);

        b1 = new JButton("로그인");
        b2 = new JButton("뒤로가기");

        panel.add(lblid);
        panel.add(txtid);
        panel.add(lblpassword);
        panel.add(txtpassword);

        panel.add(b1);
        panel.add(b2);

        add(panel);

        b1.addActionListener(this);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Kiosk().run();
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String s = null;
            boolean isOk = false;

            BufferedReader br = new BufferedReader(new FileReader("adminpw.txt"));

            if (e.getSource() == b1) {
                while ((s = br.readLine()) != null) {
                    // 비밀번호 중복확인
                    String[] array = s.split("/");
                    if (array[1].equals(txtpassword.getText())) {
                        System.out.println(array[1]);
                        isOk = true;
                        break;
                    }

                }
                // 정보 입력시 중복이 없으면 데이터 보냄
                if (isOk) {
                    JOptionPane.showMessageDialog(null, "로그인이 완료되었습니다.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
                }

            } else if (e.getSource() == b2) {
                dispose();
                txtid.setText("");
                txtpassword.setText("");

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }
    public static void main(String[] args){
        new loginAdmin();
    }


}
