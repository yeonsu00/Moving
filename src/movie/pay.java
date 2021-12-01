package movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.io.*;
import java.util.*;
public class pay extends JFrame {
    static ArrayList<Seat> seatArr;

    public pay() throws IOException {
        setTitle("예매확인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel num,money,resulttxt,people,wholeMoney,totalMoney,seatInfo,seatInfo2;
        JPanel top,mid,bot;
        JButton txt1,txt2,txt3,txt4;
        int ticket=12000;



        top=new JPanel( new GridLayout(4,3));
        mid=new JPanel(new GridLayout(2,3));
        bot=new JPanel(new GridLayout(1,1));


        JRadioButton [] pay = new JRadioButton [4]; // 버튼 배열
        //패널 색 변경
        top.setBackground(Color.WHITE);

        mid.setBackground(Color.WHITE);
        bot.setBackground(Color.WHITE);

        //결제도구 이미지 처리
        //card 이미지 처리
        ImageIcon cardImage = new ImageIcon("image/cardButton.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image card = cardImage.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image card2 = card.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon cardImage2 = new ImageIcon(card2);

        //phone 이미지 처리
        ImageIcon phoneImage = new ImageIcon("image/phone.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image phone = phoneImage.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image phone2 = phone.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon phoneImage2 = new ImageIcon(phone2);

        //kakaopay 이미지 처리
        ImageIcon kakaoImage = new ImageIcon("image/kakao.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image kakao = kakaoImage.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image kakao2 = kakao.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon kakaoImage2 = new ImageIcon(kakao2);

        //payco 이미지 처리
        ImageIcon paycoImage = new ImageIcon("image/payco.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image payco = paycoImage.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image payco2 = payco.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon paycoImage2 = new ImageIcon(payco2);

        //결제 이미지 처리
        ImageIcon admitImage = new ImageIcon("image/admitButton.png");
        //이미지를 실제로 갖고 있는 Image객체 뽑아오기
        Image admit = admitImage.getImage();
        //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
        Image admit2 = admit.getScaledInstance(800, 40, Image.SCALE_SMOOTH);
        //새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성
        ImageIcon admitImage2 = new ImageIcon(admit2);



        //top 패널 예매결과 출력
        num=new JLabel("총 인원");
        num.setHorizontalAlignment(JLabel.CENTER);
        top.add(num);

        money=new JLabel("총 결제금액");
        money.setHorizontalAlignment(JLabel.CENTER);
        top.add(money);

        resulttxt=new JLabel("결제 필요금액");
        resulttxt.setHorizontalAlignment(JLabel.CENTER);
        top.add(resulttxt);






        String[] array =new String[10];
        //일단 여기에 추가 했습니다
        array[0] = Integer.toString(seatArr.size());
        System.out.println("===========\n"+seatArr.size());
        //System.out.println("===========\n"+seatArr);
        //여기까지

        people=new JLabel(array[0]+"명");
        people.setHorizontalAlignment(JLabel.CENTER);//가운데정렬
        top.add(people);//사람 수


        String from=array[0];
        int result=Integer.parseInt(array[0]);
        totalMoney=new JLabel(result*ticket+"원");
        totalMoney.setHorizontalAlignment(JLabel.CENTER);//가운데정렬
        top.add(totalMoney);//총 결제금액
        //money.setHorizontalAlignment(JLabel.CENTER);




        wholeMoney=new JLabel(result*ticket+"원");
        top.add(wholeMoney);//결제 필요금액
        wholeMoney.setHorizontalAlignment(JLabel.CENTER);//가운데정렬
        top.setBorder(new TitledBorder("예매확인"));//경계선 추가

        //top 패널 좌석결과 출력
        //정렬 때문에 빈공간 채우는 버튼[기능없음] 추가
        txt1=new JButton("");txt2=new JButton("");
        txt3=new JButton("");txt4=new JButton("");
        txt1.setBorderPainted(false); txt2.setBorderPainted(false);
        txt1.setContentAreaFilled(false); txt2.setContentAreaFilled(false);
        txt1.setFocusPainted(false); txt2.setFocusPainted(false);
        txt3.setBorderPainted(false); txt4.setBorderPainted(false);
        txt3.setContentAreaFilled(false); txt4.setContentAreaFilled(false);
        txt3.setFocusPainted(false); txt4.setFocusPainted(false);


        //
        top.add(txt1);
        seatInfo=new JLabel("좌석정보");
        seatInfo.setHorizontalAlignment(JLabel.CENTER);
        top.add(seatInfo);

        top.add(txt2);

        top.add(txt3);
        BufferedReader br = new BufferedReader(new FileReader("tempSeatInfo.txt"));
        String str;
        str = br.readLine();
        seatInfo2=new JLabel(str);
        seatInfo2.setHorizontalAlignment(JLabel.CENTER);
        top.add(seatInfo2);

        top.add(txt4);
        //mid 패널 결제종류선택


        mid.add(pay[0]=new JRadioButton(cardImage2));
        mid.add(pay[1]=new JRadioButton(phoneImage2));
        mid.add(pay[2]=new JRadioButton(kakaoImage2));
        mid.add(pay[3]=new JRadioButton(paycoImage2));
        // 라디오버튼 묶어줄 그룹 생성하고 add
        ButtonGroup jb = new ButtonGroup();
        jb.add(pay[0]);
        jb.add(pay[1]);
        jb.add(pay[2]);
        jb.add(pay[3]);

        //mid.setBorder(new TitledBorder("결제방법"));//테두리 꾸미기
        //최하단 패널

        //선택버튼 추가
        JButton bt = new JButton(admitImage2);
        bt.setBorderPainted(false);//버튼 경계선 안보이게
        bt.setContentAreaFilled(false);//버튼 내용채우기 안 함
        bot.add(bt);


        //각 창 추가
        add(top,BorderLayout.NORTH);
        add(mid,BorderLayout.CENTER);
        add(bot,BorderLayout.SOUTH);

        setSize(800,1000);
        setLocationRelativeTo(null);
        setVisible(true);

        //버튼 리스너
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pay[0].isSelected()) {
                    //new PayCard(); //카드정보입력
                    new Paycard_ex2(); //결제 이미지 창
                    setVisible(false);

                }
                if(pay[1].isSelected()) {
                    new PayPhone_2();
                    setVisible(false);
                }
                if(pay[2].isSelected()) {
                    new PayKaKao_2();
                    setVisible(false);
                }
                if(pay[3].isSelected()) {
                    new PayPayco_2();
                    setVisible(false);
                }
            }
        });


    }
    public static void main(String [] args) throws IOException {
        new pay();
    }

}
