package movie;

import java.util.Scanner;
import mgr.Manageable;

public class section implements Manageable {
    String Seat[][] = new String[16][16];
    Scanner s = new Scanner(System.in);

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        Seat[16][16] = scan.nextLine();
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        for (int i = 0; i < Seat.length; i++) {
            for (int j = 0; j < Seat[i].length; j++) {
                System.out.print(Seat[i][j] + " ");
            }
            System.out.println();
        }
    }

    void reservation() { //사람수에 따라 다른거 구현해야함
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

    boolean resSeat(int x, int y) {
        if (x > 0 || x < 17)
            return true;
        if (y > 0 || y < 17)
            return true;
        return false;
    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (Seat.equals(kwd))
            return true;
        return false;
    }
}