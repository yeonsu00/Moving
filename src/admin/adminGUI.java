package admin;

import adminMovie.adminMovieMain;
import adminMovieSchedule.adminMovieScheduleMain;
import movie.movieReservation2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminGUI extends JFrame {

    public void adminGUI() {
        setTitle("관리자화면");

        JPanel jp = new JPanel(new FlowLayout(FlowLayout.CENTER,30, 50));

        ImageIcon image1 = new ImageIcon("image/영화관리자.png");
        Image im1 = image1.getImage();
        Image changeImg1 = im1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);

        ImageIcon image2 = new ImageIcon("image/영화스케줄관리자.png");
        Image im2 = image2.getImage();
        Image changeImg2 = im2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);

        JLabel la1 = new JLabel(changeIcon1);
        JLabel la2 = new JLabel(changeIcon2);

        jp.add(la1);
        jp.add(la2);
        add(jp);

        la1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new adminMovieMain().createAndShowGUI();
                dispose();
            }
        });
        la2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new adminMovieScheduleMain().createAndShowGUI();
                dispose();
            }
        });

        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
