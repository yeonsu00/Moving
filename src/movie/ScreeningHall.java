package movie;

import java.util.Scanner;

public class ScreeningHall {
    String hallName;
    section seat;

    public void read(Scanner scan) {
        hallName = scan.next();
        //seat = Kiosk.findSeat(hallName);
    }

    public void print() {
        seat.print();
    }

    public boolean matches(String kwd) {
        if (hallName.equals(kwd))
            return true;
        return false;
    }
}