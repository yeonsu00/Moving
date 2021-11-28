package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class movieReservation2 extends JFrame {

    ImageIcon changeIcon;
    String[] time = new String[100];
    Movie movie;

    public void readMovie(String movieCode) {
        movie = Kiosk.findMovie(movieCode);
    }


    public void setFrame() {
        setTitle("MovieChoose");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(northPanel(), BorderLayout.NORTH);
        c.add(westPanel(), BorderLayout.WEST);
        c.add(centerPanel(), BorderLayout.CENTER);
        c.add(eastPanel(), BorderLayout.EAST);

        setSize(1500, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    JPanel northPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title = new JLabel("영화상영시간표");
        title.setFont(new Font("Vernada", Font.BOLD, 30));
        jpanel.add(title);
        return jpanel;
    }

//    JPanel centerPanel() {
//
//        MovieSchedule movieSchedule =
//        JPanel jpanel = new JPanel();
//        JLabel la = new JLabel();
//        la.setText();
//
//        jpanel.add(la);
//        return jpanel;
//    }


    JPanel westPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);

        return jpanel;
    }

    JPanel centerPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(10,1));

          JPanel jpanel1 = new JPanel();
//        JPanel jpanel20 = new JPanel();
//        JPanel jpanel30 = new JPanel();
//        JPanel jpanel40 = new JPanel();
//        JPanel jpanel50 = new JPanel();
//        JPanel jpanel6 = new JPanel();
//        JPanel jpanel7 = new JPanel();
//        JPanel jpanel8 = new JPanel();
//        JPanel jpanel9 = new JPanel();

        jpanel.setBackground(Color.WHITE);
        String halls[] = {"상영관1", "상영관2(백신패스관)", "상영관3(백신패스관)", "상영관4(백신패스관)", "상영관5(백신패스관)",
                "상영관6", "상영관7","상영관8","상영관9"};
        int hallNumber[] = {1, 20, 30, 40, 50, 6, 7, 8, 9};
        for (int i = 0; i < halls.length; i++){
            int num = 0;
            JPanel jp1 = new JPanel();
            //jpanel.add(new JLabel(halls[i]));
            //jpanel1.add(jp1);
            //jpanel.add(jp1);
            System.out.println(halls[i]);
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
                        jpanel.add(new JLabel(halls[i]));
                        num++;
                    }
                    JPanel jp = new JPanel();
                    String title = hour + ":" + min;
                    System.out.println(title);
                    JLabel la = new JLabel(title);
                    jp.add(la);
                    jp1.add(jp);
                    jpanel.add(jp1);
                }
            }
            //jpanel.add(jpanel1);
        }

        int i1 = 0;
        int i20 = 0;
        int i30 = 0;
        int i40 = 0;
        int i50 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;

//        for(MovieSchedule m: movie.scheduleList){
//            if(m.theaterNumber == 1){
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                JPanel jp1 = new JPanel();
//                // jp.setSize(100,100);
//                while (i1 < 1){
//                    jp1.add(new JLabel("1 상영관"));
//                    i1++;
//                }
//                jp.setBackground(Color.gray);
//                jp.add(la);
//                jpanel1.add(jp1);
//                jpanel1.add(jp);
//            }
//            else if(m.theaterNumber == 20) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                JPanel jp1 = new JPanel();
//                // jp.setSize(100,100);
//                while (i20 < 1){
//                    jp1.add(new JLabel("1 상영관"));
//                    i20++;
//                }
//                jp.setBackground(Color.gray);
//                jp.add(la);
//                jpanel1.add(jp1);
//                jpanel20.add(jp);
//            }
//            else if(m.theaterNumber == 30) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("3상영관(백신패스관)"));
//                jp.add(la);
//                jpanel30.add(jp);
//            }
//            else if(m.theaterNumber == 40) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                JPanel jp1 = new JPanel();
//                // jp.setSize(100,100);
//                while (i40 < 1){
//                    jp1.add(new JLabel("4 상영관(백신패스관)"));
//                    i40++;
//                }
//                jp.setBackground(Color.gray);
//                jp.add(la);
//                jpanel40.add(jp1);
//                jpanel40.add(jp);
//            }
//            else if(m.theaterNumber == 50) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("5상영관(백신패스관)"));
//                jp.add(la);
//                jpanel50.add(jp);
//            }
//            else if(m.theaterNumber == 6) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("6상영관"));
//                jp.add(la);
//                jpanel6.add(jp);
//            }
//            else if(m.theaterNumber == 7) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("7상영관"));
//                jp.add(la);
//                jpanel7.add(jp);
//            }
//            else if(m.theaterNumber == 8) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("8상영관"));
//                jp.add(la);
//                jpanel8.add(jp);
//            }
//            else if(m.theaterNumber == 9) {
//                String title = m.movieStartHour + ":" + m.movieStartMinute;
//                JLabel la = new JLabel(title);
//                JPanel jp = new JPanel();
//                // jp.setSize(100,100);
//                jp.setBackground(Color.gray);
//                jp.add(new JLabel("9상영관(백신패스관)"));
//                jp.add(la);
//                jpanel9.add(jp);
//            }
////            String title = m.movieStartHour + ":" + m.movieStartMinute;
////            JLabel la = new JLabel(title);
////            JPanel jp = new JPanel();
////           // jp.setSize(100,100);
////            jp.setBackground(Color.gray);
////            jp.add(la);
////            jpanel.add(jp);
//            jpanel.add(jpanel1);
//            jpanel.add(jpanel20);
//            jpanel.add(jpanel30);
//            jpanel.add(jpanel40);
//            jpanel.add(jpanel50);
//            jpanel.add(jpanel6);
//            jpanel.add(jpanel7);
//            jpanel.add(jpanel8);
//            jpanel.add(jpanel9);
//        }
        JButton btnBack = new JButton("이전으로");
        jpanel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new movieReservation1().setFrame();
                dispose();
            }
        });
        return jpanel;
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
