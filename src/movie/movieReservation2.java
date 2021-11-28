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
        jpanel.setBackground(Color.WHITE);
//        for(MovieSchedule m: movie.scheduleList){
//            String title = m.movieStartHour + ":" + m.movieStartMinute;
//            JLabel la = new JLabel(title);
//            jpanel.add(la);
//        }
        for(MovieSchedule m: movie.scheduleList){
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

            String title = hour + ":" + min;
            JLabel la = new JLabel(title);
            JPanel jp = new JPanel();
           // jp.setSize(100,100);
            jp.setBackground(Color.gray);
            jp.add(la);
            jpanel.add(jp);
        }
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
