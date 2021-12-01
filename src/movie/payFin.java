package movie;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class payFin extends JFrame {
    JScrollPane scrollPane;
    JButton b1;
    ImageIcon icon, reset;

    public payFin() {
        ImageIcon icon = new ImageIcon("image/Fin.png");
        ImageIcon reset = new ImageIcon("image/reset.jpg");

        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image card = icon.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image card2 = card.getScaledInstance(480, 300, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon cardImage2 = new ImageIcon(card2);


        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image Imgreset = reset.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image Imgreset2 = Imgreset.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon reset2 = new ImageIcon(Imgreset2);


        JPanel panel=new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(cardImage2.getImage(),0,0,null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };
        scrollPane=new JScrollPane(panel);
        setContentPane(scrollPane);

      b1 = new JButton(reset2);
      //b1.setContentAreaFilled(false);
      b1.setBorderPainted(false);
      panel.setLayout(null);
      b1.setBounds(200,200,100,50);
      panel.add(b1);


      b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
      });


        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args){
        new payFin();
    }

}

