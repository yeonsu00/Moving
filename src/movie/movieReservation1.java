package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
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
    String[] time = new String[100];
    ImageIcon changeIcon1;
    ImageIcon changeIcon2;
    ImageIcon changeIcon3;
    ImageIcon changeIcon4;
    ImageIcon changeIcon5;
    ImageIcon changeIcon6;
    ImageIcon changeIcon7;
    ImageIcon changeIcon8;
    ImageIcon changeIcon9;
    ImageIcon changeIcon10;
    ImageIcon changeIcon11;

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

        setSize(1920, 1080);
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
    public String readMovie() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("movie.txt")
            );
            String str;
            int count=0;
            while ((str = reader.readLine()) != null) {
//                if(str.contentEquals("A1001")) {
//                    time[count] = str;
//                    count++;
//                    System.out.print(str);
//                }
                time[count] = str;
                System.out.print(str);
                System.out.println();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    void bringImage() {
        ImageIcon image1 = new ImageIcon("image/1001.png");
        Image im1 = image1.getImage();
        Image changeImg1 = im1.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon1 = new ImageIcon(changeImg1);

        ImageIcon image2 = new ImageIcon("image/1002.png");
        Image im2 = image2.getImage();
        Image changeImg2 = im2.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon2 = new ImageIcon(changeImg2);

        ImageIcon image3 = new ImageIcon("image/1003.png");
        Image im3 = image3.getImage();
        Image changeImg3 = im3.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon3 = new ImageIcon(changeImg3);

        ImageIcon image4 = new ImageIcon("image/1004.png");
        Image im4 = image4.getImage();
        Image changeImg4 = im4.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon4 = new ImageIcon(changeImg4);

        ImageIcon image5 = new ImageIcon("image/1005.png");
        Image im5 = image5.getImage();
        Image changeImg5 = im5.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon5 = new ImageIcon(changeImg5);

        ImageIcon image6 = new ImageIcon("image/1006.png");
        Image im6 = image6.getImage();
        Image changeImg6 = im6.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon6 = new ImageIcon(changeImg6);

        ImageIcon image7 = new ImageIcon("image/1007.png");
        Image im7 = image7.getImage();
        Image changeImg7 = im7.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon7 = new ImageIcon(changeImg7);

        ImageIcon image8 = new ImageIcon("image/1008.png");
        Image im8 = image8.getImage();
        Image changeImg8 = im8.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon8 = new ImageIcon(changeImg8);

        ImageIcon image9 = new ImageIcon("image/1009.png");
        Image im9 = image9.getImage();
        Image changeImg9 = im9.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon9 = new ImageIcon(changeImg9);

        ImageIcon image10 = new ImageIcon("image/1010.png");
        Image im10 = image10.getImage();
        Image changeImg10 = im10.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon10 = new ImageIcon(changeImg10);

        ImageIcon image11 = new ImageIcon("image/1011.png");
        Image im11 = image11.getImage();
        Image changeImg11 = im11.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        changeIcon11 = new ImageIcon(changeImg11);
    }
    JPanel centerPanel() {

        bringImage();

        JPanel jpanel = new JPanel();

        JLabel la1 = new JLabel(changeIcon1);
        JLabel la2 = new JLabel(changeIcon2);
        JLabel la3 = new JLabel(changeIcon3);
        JLabel la4 = new JLabel(changeIcon4);
        JLabel la5 = new JLabel(changeIcon5);
        JLabel la6 = new JLabel(changeIcon6);
        JLabel la7 = new JLabel(changeIcon7);
        JLabel la8 = new JLabel(changeIcon8);
        JLabel la9 = new JLabel(changeIcon9);
        JLabel la10 = new JLabel(changeIcon10);
        JLabel la11 = new JLabel(changeIcon11);
        JLabel jbutton1 = new JLabel();

        jpanel.add(jbutton1);
        jpanel.add(la1);
        jpanel.add(la2);
        jpanel.add(la3);
        jpanel.add(la4);
        jpanel.add(la5);
        jpanel.add(la6);
        jpanel.add(la7);
        jpanel.add(la8);
        jpanel.add(la9);
        jpanel.add(la10);
        jpanel.add(la11);

        la1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1001");
                String code = readMovie();
                new movieReservation2("1001").setFrame();
                dispose();
            }
        });
        la2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1002");
                new movieReservation2("1002").setFrame();
                dispose();
            }
        });
        la3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1003");
                new movieReservation2("1003").setFrame();
                dispose();
            }
        });
        la4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1004");
                new movieReservation2("1004").setFrame();
                dispose();
            }
        });
        la5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1005");
                new movieReservation2("1005").setFrame();
                dispose();
            }
        });
        la6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1006");
                new movieReservation2("1006").setFrame();
                dispose();
            }
        });
        la7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1007");
                new movieReservation2("1007").setFrame();
                dispose();
            }
        });
        la8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1008");
                new movieReservation2("1008").setFrame();
                dispose();
            }
        });
        la9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1009");
                new movieReservation2("1009").setFrame();
                dispose();
            }
        });
        la10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1010");
                new movieReservation2("1010").setFrame();
                dispose();
            }
        });
        la11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                message("A1011");
                new movieReservation2("1011").setFrame();
                dispose();
            }
        });

        return jpanel;

    }
    public void message(String code) {
        readMovie();
        String age = "";
        JOptionPane.showMessageDialog(null, "이 영화는 " + age + "세 이상 관람가입니다.");
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