package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seat extends JButton implements ActionListener {
    int x;
    int y;
    boolean isChecked=false;
    Seat(int x, int y,String s){
        super(s);
        this.x=x;
        this.y=y;

        super.setBackground(Color.CYAN);
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton srcBut = (JButton) e.getSource();
        if (srcBut.getBackground()== Color.RED)
        {
            srcBut.setBackground(Color.CYAN);
            this.isChecked=false;
        }
        else if(srcBut.getBackground()==Color.CYAN)
        {
            srcBut.setBackground(Color.RED);
            this.isChecked=true;
        }
    }
}
