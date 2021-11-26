package movie;

import javax.swing.*;
import java.awt.*;

public class movieReservation2 extends JFrame {

    ImageIcon changeIcon;

    public void setFrame() {
        setTitle("MovieChoose");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(northPanel(), BorderLayout.NORTH);
        //c.add(centerPanel(), BorderLayout.CENTER);

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
    protected JButton setBtnMovie(String name, String time, String seatCnt, int x, int y) {
        JButton btn = new JButton("<html>" + time + "<br/>" + seatCnt + "</html>");

        btn.setBackground(new Color(230, 236, 240));
        btn.setForeground(new Color(114, 114, 114));
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 90, 70);

        //backgroundPanel.add(btn);
        btn.setName(name);

        return btn;
    }

    public static void main(String[] args) {
        movieReservation2 mFrame2 = new movieReservation2();
        mFrame2.movieReservation2();
    }
    private void movieReservation2() {
        // TODO Auto-generated method stub
    }
}
