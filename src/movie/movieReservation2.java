package movie;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class movieReservation2 extends JFrame {

    ImageIcon changeIcon;
    String[] time = new String[100];

    public void readSchedule() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("movieSchedule.txt")
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
                if(str.contentEquals("A1001")) {

                }
                System.out.println();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
        jpanel.setBackground(Color.WHITE);

        return jpanel;
    }

    JPanel centerPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.YELLOW);

        return jpanel;
    }

    JPanel eastPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.WHITE);

        return jpanel;
    }

    public void readCurrentSeat() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("movieSchedule.txt")
            );

            String str;
            int count=0;
//            while ((str = reader.readLine()) != null) {
//                curSeat[count] = str;
//                count++;
//                System.out.println(str);
//            }

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        movieReservation2 mFrame2 = new movieReservation2();
        mFrame2.readSchedule();
        mFrame2.setFrame();
    }
    private void movieReservation2(String movie) {
        // TODO Auto-generated method stub
    }
}
