package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PayPayco_2 extends JFrame {
    JScrollPane scrollPane;
    JButton b1,b2;
    ImageIcon icon;
    JPanel panel2;
    public PayPayco_2() {
        ImageIcon icon = new ImageIcon("image/qr.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image bg = icon.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image bg2 = bg.getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon icon2 = new ImageIcon(bg2);


        JPanel panel=new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(icon2.getImage(),0,0,null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };
        scrollPane=new JScrollPane(panel);
        setContentPane(scrollPane);


        b1 = new JButton("결제확인");
        b1.setBorderPainted(false);
        panel.setLayout(null);
        b1.setBounds(300,300,100,50);

        b2 = new JButton("직접입력");
        b2.setBorderPainted(false);
        panel.setLayout(null);
        b2.setBounds(10,300,100,50);

        panel.add(b1);
        panel.add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new payFin();
                setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PayPayco();
                setVisible(false);
            }
        });
        setTitle("Payco 결제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        setVisible(true);
        setLocationRelativeTo(null);

    }



}
