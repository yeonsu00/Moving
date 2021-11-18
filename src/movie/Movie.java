package movie;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;

public class Movie implements Manageable {
    String movieCode;
    String movieName;
    String ageLimit;
    int time;
    int price;
    ArrayList<MovieSchedule> scheduleList = new ArrayList();

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        movieCode=scan.next();
        movieName=scan.next();
        ageLimit=scan.next();
        time=scan.nextInt();
        price=scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s %s %s %d %d",movieCode,movieName,ageLimit,time,price);
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (kwd.length() > 2 && movieCode.contains(kwd))
            return true;
        if(movieName.contains("kwd"))
            return true;
        if(ageLimit.equals("kwd"))
            return true;
        if(kwd.equals(""+time))
            return true;
        if(kwd.equals(""+price))
            return true;
        return false;
    }
}
