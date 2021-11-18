package movie;

import java.util.Scanner;
import mgr.Manageable;

public class Seat implements Manageable {

    String Seats[][] = new String[16][16];

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        Seats[16][16] = scan.nextLine();
    }

    @Override
    public void print() {
        for (int i = 0; i < Seats.length; i++) {
            for (int j = 0; j < Seats[i].length; j++) {
                System.out.print(Seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    //
    @Override
    public boolean matches(String kwd) {
        return true;
    }
}