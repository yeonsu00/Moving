package movie;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class MovieSchedule implements Manageable {
    String movieCode;
    int movieStartHour;
    int movieStartMinute;
    static int movieEndHour;
    static int movieEndMinute;
    int runningTime;	//분단위
    int theaterNumber;	//1,2,3관 백신패스관("0")

    //A1 17 30 150 3
    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        movieCode = scan.next();
        movieStartHour = scan.nextInt();
        movieStartMinute = scan.nextInt();
        runningTime = scan.nextInt();
        theaterNumber = scan.nextInt();
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        System.out.printf("[%s] %d:%d ~ ",
                movieCode, movieStartHour, movieStartMinute);
        movieEnd(movieStartHour, movieStartMinute, runningTime);
        if(theaterNumber != 0)
            System.out.printf("%d관\n", theaterNumber);
        else
            System.out.printf("백신 패스관\n");
    }

    @Override
    public boolean matches(String kwd) {
        if (movieCode.equals(kwd))
            return true;
        return false;
    }

    static void movieEnd(int movieStartHour,
                         int movieStartMinute, int runningTime) {
        int hour;
        int minute;
        hour = runningTime / 60;
        minute = runningTime % 60;
        movieEndHour = movieStartHour + hour;
        movieEndMinute = movieEndMinute + minute;
        if (movieEndMinute >= 60) {
            movieEndHour += 1;
            movieEndMinute -= 60;
        }
        if (movieEndHour >= 24)
            movieEndHour -= 24;
        System.out.printf("%d:%d\t", movieEndHour, movieEndMinute);
    }
}
