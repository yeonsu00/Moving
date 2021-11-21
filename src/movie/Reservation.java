package movie;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation extends section{
    Scanner s=new Scanner(System.in);
    ArrayList <Seat> seatList=new ArrayList<>();
    ArrayList <Movie> movieList=new ArrayList<>();

    public void res()
    {

    }

    void people()
    {
        System.out.print("몇명인가요?");
        int n=s.nextInt();
    }
    void seatReservation() { //사람수에 따라 다른거 구현해야함
        people();
        while (true) {
            System.out.print("행과열을 골라주세요>>(1~16)");
            int x = s.nextInt();
            int y = s.nextInt();
            resSeat(x, y);
            if (Seat[x - 1][y - 1].equals("O")) {
                Seat[x - 1][y - 1] = "X";
                System.out.println("예약이 완료되었습니다.");
                break;
            }
            if (Seat[x - 1][y - 1].contentEquals("X"))
                System.out.println("이미 예약된 좌석입니다.");
        }
    }
}