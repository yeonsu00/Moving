package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

public class pay extends JFrame {


    public pay() {
        setTitle("예매확인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel num,money,result;
        JPanel top,mid;
        top=new JPanel( new GridLayout(4,2));
        mid=new JPanel(new FlowLayout());
        JRadioButton [] pay = new JRadioButton [4]; // 라디오버튼 배열
        JButton bt = new JButton("선택");

        //top 패널 예매결과 출력
        num=new JLabel("총 인원");
        num.setHorizontalAlignment(JLabel.CENTER);
        top.add(num);
        top.add(new JLabel("1명"));

        money=new JLabel("총 결제금액");
        money.setHorizontalAlignment(JLabel.CENTER);
        top.add(money);
        top.add(new JLabel("7000원"));

        result=new JLabel("결제 필요금액");
        result.setHorizontalAlignment(JLabel.CENTER);
        top.add(result);
        top.add(new JLabel("7000원"));
        top.setBorder(new TitledBorder("예매확인"));

        //mid 패널 결제종류선택
        mid.add(pay[0]=new JRadioButton("신용카드/체크카드"));
        mid.add(pay[1]=new JRadioButton("휴대폰결제"));
        mid.add(pay[2]=new JRadioButton("카카오페이"));
        mid.add(pay[3]=new JRadioButton("페이코"));
        // 라디오버튼 묶어줄 그룹 생성하고 add
        ButtonGroup jb = new ButtonGroup();
        jb.add(pay[0]);
        jb.add(pay[1]);
        jb.add(pay[2]);
        jb.add(pay[3]);
        mid.setBorder(new TitledBorder("결제방법"));//테두리 꾸미기
        mid.add(bt);


        //각 창 추가
        add(top,BorderLayout.NORTH);
        add(mid,BorderLayout.CENTER);
        //add(bot,BorderLayout.SOUTH);

        setSize(420,240);
        setVisible(true);

        //버튼 리스너
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pay[0].isSelected()) {
                    new PayCard();
                    setVisible(false);
                }
                if(pay[1].isSelected()) {
                    new PayPhone();
                    setVisible(false);
                }
                if(pay[2].isSelected()) {
                    new PayKakao();
                    setVisible(false);
                }
                if(pay[3].isSelected()) {
                    new PayPayco();
                    setVisible(false);
                }
            }
        });


    }
    public static void main(String [] args) {
        new pay();
    }

}
