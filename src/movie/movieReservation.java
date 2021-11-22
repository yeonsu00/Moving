package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class movieReservation extends JFrame {

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

        setSize(500, 500);
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
    void bringImage() {
        ImageIcon image1 = new ImageIcon("image/image1.png");
        //JButton jbutton1 = new JButton(new ImageIcon("image/image1.png"));
        Image im1 = image1.getImage();
        Image changeImg1 = im1.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        //changeIcon1 = new ImageIcon(changeImg1);
        changeIcon1 = new ImageIcon(changeImg1);
        //ButtonImage = new
        JButton button1 = new JButton("");
        button1.setIcon(new ImageIcon("image/image1.png"));
        add(button1);

        ImageIcon image2 = new ImageIcon("image/image2.png");
        Image im2 = image2.getImage();
        Image changeImg2 = im2.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon2 = new ImageIcon(changeImg2);

        ImageIcon image3 = new ImageIcon("image/image3.png");
        Image im3 = image3.getImage();
        Image changeImg3 = im3.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon3 = new ImageIcon(changeImg3);

        ImageIcon image4 = new ImageIcon("image/image4.png");
        Image im4 = image4.getImage();
        Image changeImg4 = im4.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon4 = new ImageIcon(changeImg4);

        ImageIcon image5 = new ImageIcon("image/image5.png");
        Image im5 = image5.getImage();
        Image changeImg5 = im5.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon5 = new ImageIcon(changeImg5);

        ImageIcon image6 = new ImageIcon("image/image6.png");
        Image im6 = image6.getImage();
        Image changeImg6 = im6.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon6 = new ImageIcon(changeImg6);

        ImageIcon image7 = new ImageIcon("image/image7.png");
        Image im7 = image7.getImage();
        Image changeImg7 = im7.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon7 = new ImageIcon(changeImg7);

        ImageIcon image8 = new ImageIcon("image/image8.png");
        Image im8 = image8.getImage();
        Image changeImg8 = im8.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon8 = new ImageIcon(changeImg8);

        ImageIcon image9 = new ImageIcon("image/image9.png");
        Image im9 = image9.getImage();
        Image changeImg9 = im9.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon9 = new ImageIcon(changeImg9);

        ImageIcon image10 = new ImageIcon("image/image10.png");
        Image im10 = image10.getImage();
        Image changeImg10 = im10.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        changeIcon10 = new ImageIcon(changeImg10);

        ImageIcon image11 = new ImageIcon("image/image11.png");
        Image im11 = image11.getImage();
        Image changeImg11 = im11.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
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
                //new Kiosk2(); 여기에 키오스크 말고 영화 시간 고르는 창으로 ㄱ
            }
        });

        return jpanel;

    }


    public static void main(String[] args) {
        movieReservation mFrame = new movieReservation();
        mFrame.movieReservation();
    }
    private void movieReservation() {
        // TODO Auto-generated method stub
        setTitle("MovieChoose");
    }
}