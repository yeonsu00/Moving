package movie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class movieReservation1 extends JFrame {

    //    JTextArea area= new JTextArea();
//    JScrollPane scrollPane = new JScrollPane(area);  //스크롤판 추가
//    JPane.add(scrollPane); //화면에 추가
//
//    area.append(log);  // 출력로그 JTextArea 출력
//    area.setCaretPosition(txtLog.getDocument().getLength());  // 이 코드를 append 밑에 추가해주면 항상 아래로 스크롤 된다
//
//    JScrollPane scrollbar = new JScrollPane();
//    scrollbar.getViewport().setView();
//    String[] time = new String[100];
    Movie movie;
    String code;

    public void setFrame() {

        setTitle("MovieChoose");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

//		JLabel background = new JLabel(new ImageIcon("image/image1.png"));
//		JButton jbutton = new JButton(new ImageIcon("image/image2.png"));
//		JFrame J = new JFrame();
//
//		J.add(background);
//
//		J.setSize(300, 500);
//		J.setVisible(true);
//		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		J.setLayout(null);
//
//		jbutton.setBounds(200,200,200,200);
//		J.add(jbutton);
        //=================================

//		JPanel centerPanel = centerPanel();
//		JScrollPane sp = new JScrollPane(centerPanel);
//		c.add(sp);

        c.add(northPanel(), BorderLayout.NORTH);
        c.add(centerPanel(), BorderLayout.CENTER);
        c.add(southPanel(), BorderLayout.SOUTH);

        setSize(1950, 1040);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }
    JPanel northPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title = new JLabel("현재상영영화");
        title.setFont(new Font("Vernada", Font.BOLD, 30));
        jpanel.add(title);
        return jpanel;
    }

    JPanel centerPanel() {

        //JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT,100, 9));
        JPanel jpanel = new JPanel(new GridLayout(2,5,5,5));

        for (int imageName = 1001; imageName < 1011; imageName++){
            String sImageName = imageName+"";
            ImageIcon image = new ImageIcon("image/"+imageName+".png");
            Image im = image.getImage();
            Image changeImg11 = im.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
            ImageIcon changeIcon = new ImageIcon(changeImg11);

            JLabel la = new JLabel(changeIcon);
            jpanel.add(la);

            la.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    message(sImageName);
                    new movieReservation2(sImageName).setFrame();
                    dispose();
                }
            });
        }
        return jpanel;
    }

    JPanel southPanel() {
        JPanel jpanel2 = new JPanel();

        JPanel btnPanel = new JPanel();
        JButton btnBack = new JButton("이전으로");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.gray);
        btnPanel.add(btnBack);
        jpanel2.add(btnPanel);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Kiosk2();
                dispose();
            }
        });

        return jpanel2;
    }

    public void readMovie(String movieCode) {
        code = movieCode;
        movie = Kiosk.findMovie(movieCode);
    }

    public void message(String code) {
        readMovie(code);
//        String age = movie.ageLimit;
//        System.out.println(age);
//        if (age == "0") {
//            JOptionPane.showMessageDialog(null, "이 영화는 전체 관람가입니다.");
//        }
//        else {
//            JOptionPane.showMessageDialog(null, "이 영화는 전체 관람가입니다.");
//            JOptionPane.showMessageDialog(null, "이 영화는 " + age + "세 이상 관람가입니다.");
//        }
        JOptionPane.showMessageDialog(null, "이 영화는 " + movie.ageLimit + "세 이상 관람가입니다.");
        dispose();
    }

    public static void main(String[] args) {
        movieReservation1 mFrame1 = new movieReservation1();
        mFrame1.movieReservation();
    }

    private void movieReservation() {
        // TODO Auto-generated method stub
        setTitle("MovieChoose");
    }
}