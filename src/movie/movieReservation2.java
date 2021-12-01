package movie;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class movieReservation2 extends JFrame {

    ImageIcon changeIcon;
    String[] time = new String[100];
    Movie movie;
    String code;

    public void readMovie(String movieCode) {
        code = movieCode;
        movie = Kiosk.findMovie(movieCode);
    }


    public void setFrame() {
        setTitle("MovieChoose");

        Container c = getContentPane();
        c.setLayout(new BorderLayout(50,50));
        c.setBackground(Color.white);

        c.add(northPanel(), BorderLayout.NORTH);
        //c.add(westPanel(), BorderLayout.WEST);
        c.add(centerPanel(), BorderLayout.CENTER);
        //c.add(eastPanel(), BorderLayout.EAST);

        setSize(1920, 1080);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    JPanel northPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        JLabel title = new JLabel("영화상영시간표");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Vernada", Font.BOLD, 40));
        jpanel.add(title);
        return jpanel;
    }

    JPanel westPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);

        return jpanel;
    }

    Icon bringImage() {
        String sImage = code;
        ImageIcon image = new ImageIcon("image/"+code+".png");
        Image im = image.getImage();
        Image changeImg = im.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        changeIcon = new ImageIcon(changeImg);
        return changeIcon;
    }

    JPanel centerPanel() {
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout(0,50));
        bigPanel.setBackground(Color.WHITE);

        //<여기는 이미지와 영화제목>
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,80,0));
        northPanel.setBackground(Color.white);
        northPanel.setPreferredSize(new Dimension(150,150));
        String movieName = movie.movieName;
        JLabel northImage = new JLabel(bringImage());
        JLabel northName = new JLabel(movieName);
        //northName.setSize(100,100);
        northName.setFont(new Font("Vernada", Font.BOLD, 20));
        northPanel.add(northImage);
        northPanel.add(northName);

        bigPanel.add(northPanel,BorderLayout.NORTH);

        //<여기는 상영 시간표>
        JPanel cneterPanel = new JPanel();

        cneterPanel.setLayout(new GridLayout(7,2, 0, 15));
        cneterPanel.setBackground(Color.WHITE);

        String halls[] = {"상영관1", "상영관2(백신패스관)", "상영관3(백신패스관)", "상영관4(백신패스관)", "상영관5(백신패스관)",
                "상영관6", "상영관7","상영관8","상영관9"};
        int hallNumber[] = {1, 20, 30, 40, 50, 6, 7, 8, 9};
        for (int i = 0; i < halls.length; i++){
            int num = 0;
            JPanel oneLinePanel = null;

            for(MovieSchedule m: movie.scheduleList) {
                String hour = "";
                String min ="";
                if(m.movieStartMinute<10){
                    min+="0"+m.movieStartMinute;
                }
                else {
                    min+=m.movieStartMinute;
                }
                if(m.movieStartHour<10){
                    hour+="0"+m.movieStartHour;
                }
                else {
                    hour+=m.movieStartHour;
                }

                if (hallNumber[i] == m.theaterNumber){
                    if(num == 0){
                        oneLinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 7));
                        oneLinePanel.setBorder(new TitledBorder(new LineBorder(Color.gray,3), ""));

                        JPanel hallNameP = new JPanel();
                        hallNameP.setPreferredSize(new Dimension(150,50));
                        hallNameP.add(new JLabel(halls[i]));
                        oneLinePanel.add(hallNameP);
                        num++;
                    }
                    JPanel timeJp = new JPanel();
                    timeJp.setPreferredSize(new Dimension(60,55));
                    timeJp.setBackground(Color.LIGHT_GRAY);

                    String title = hour + ":" + min;
                    System.out.println(title);
                    JLabel la = new JLabel(title);
                    timeJp.add(la);
                    oneLinePanel.add(timeJp);
                    cneterPanel.add(oneLinePanel);

                    String fileName = "."+ hour +".."+ min;

                    la.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            new Seats(m.theaterNumber+fileName);
                            //new Kiosk2();
                            dispose();
                        }
                    });
                }
            }
            bigPanel.add(cneterPanel,BorderLayout.CENTER);
        }

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.white);
        JButton btnBack = new JButton("이전으로");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.gray);
        btnPanel.add(btnBack);
        cneterPanel.add(btnPanel);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new movieReservation1().setFrame();
                dispose();
            }
        });
        return bigPanel;
    }

    JPanel eastPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);

        return jpanel;
    }


//    protected JButton setBtnMovie(String name, String time, String seatCnt, int x, int y) {
//        JButton btn = new JButton("<html>" + time + "<br/>" + seatCnt + "</html>");
//
//        btn.setBackground(new Color(230, 236, 240));
//        btn.setForeground(new Color(114, 114, 114));
//        btn.setBorderPainted(false);
//        btn.setBounds(x, y, 90, 70);
//
//        //backgroundPanel.add(btn);
//        btn.setName(name);
//
//        return btn;
//    }

//    public static void main(String[] args) {
//        movieReservation2 mFrame2 = new movieReservation2();
//        mFrame2.readSchedule();
//        mFrame2.setFrame();
//    }

    movieReservation2(String movieCode) {
        // TODO Auto-generated method stub
        readMovie(movieCode);
    }
}
