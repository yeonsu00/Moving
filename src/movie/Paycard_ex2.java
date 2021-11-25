package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Paycard_ex2 extends JFrame {
    JScrollPane scrollPane;
    JButton b1,b2,b3;
    ImageIcon icon,imgBack;
    JPanel panel2;
    public Paycard_ex2() {
      ImageIcon icon = new ImageIcon("image/paycard.png");
      ImageIcon imgBack = new ImageIcon("image/back.png");

      //이미지를 실제로 갖고 있는 Image객체 뽑아오기
      Image card = icon.getImage();
      //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
      Image card2 = card.getScaledInstance(700, 400, Image.SCALE_DEFAULT);
      //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
      ImageIcon cardImage2 = new ImageIcon(card2);

      /*뒤로가기 이미지
      //이미지를 실제로 갖고 있는 Image객체 뽑아오기
      Image back = imgBack.getImage();
      //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
      Image back2 = back.getScaledInstance(30, 20, Image.SCALE_DEFAULT);
      //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
      ImageIcon Back2 = new ImageIcon(back2);
      */

        JPanel panel=new JPanel(){
          public void paintComponent(Graphics g){
              g.drawImage(cardImage2.getImage(),0,0,null);
              setOpaque(false);
              super.paintComponent(g);
          }

      };
      scrollPane=new JScrollPane(panel);
      setContentPane(scrollPane);
      /*버튼 추가
      panel2=new JPanel( new GridLayout(0,3));
      b1 = new JButton("직접입력");
      b2=  new JButton("결제");
      b3 = new JButton(Back2);
      //b2.setContentAreaFilled(false);
      //b2.setBorderPainted(false);
      b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PayCard();
                setVisible(false);
            }
      });
      b3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
               try {
                   new pay();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
               setVisible(false);
           }
      });

      //panel.setBounds(0,0,700,350);
      panel2.setBounds(0,320,700,40);
      panel2.add(b1);panel2.add(b2);panel2.add(b3);  add(panel2);*/
      setTitle("카드 결제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(700,400);
      setVisible(true);
      setLocationRelativeTo(null);

    }


    public static void main(String[] args){
        new Paycard_ex2();

    }

}
