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
    int theaterNumber;	//1,20(백신패스관),30(백신패스관),40(백신패스관),50(백신패스관),6,7,8,9관

    //A1003 8 45 100 30
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
        if(movieStartHour < 10 && movieStartMinute < 10)
            System.out.printf("[%s] 0%d:0%d ~ ",movieCode, movieStartHour, movieStartMinute);
        else if(movieStartHour < 10 && movieStartMinute > 10)
            System.out.printf("[%s] 0%d:%d ~ ",movieCode, movieStartHour, movieStartMinute);
        else if(movieStartHour > 10 && movieStartMinute < 10)
            System.out.printf("[%s] %d:0%d ~ ",movieCode, movieStartHour, movieStartMinute);
        else
            System.out.printf("[%s] %d:%d ~ ", movieCode, movieStartHour, movieStartMinute);
        movieEnd(movieStartHour, movieStartMinute, runningTime);
        if(theaterNumber % 10 != 0)
            System.out.printf("%d관\n", theaterNumber);
        else
            System.out.printf("%d관(백신 패스관)\n", theaterNumber/10);
    }

    @Override
    public boolean matches(String kwd) {
        if (movieCode.equals(kwd))
            return true;
        return false;
    }

    static void movieEnd(int movieStartHour, int movieStartMinute, int runningTime) {
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

        if(movieEndHour < 10 && movieEndMinute < 10)
            System.out.printf("0%d:0%d\t", movieEndHour, movieEndMinute);
        else if(movieEndHour < 10 && movieEndMinute > 10)
            System.out.printf("0%d:%d\t", movieEndHour, movieEndMinute);
        else if(movieEndHour > 10 && movieEndMinute < 10)
            System.out.printf("%d:0%d\t", movieEndHour, movieEndMinute);
        else
            System.out.printf("%d:%d\t", movieEndHour, movieEndMinute);
    }
}
