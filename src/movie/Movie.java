package movie;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;

public class Movie implements Manageable {
    //A1001 장르만로맨스 15 113 14000
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
        if (kwd.length() > 2 && movieCode.equals(kwd))
            return true;
        if(movieName.contains("kwd"))
            return true;
        if(ageLimit.equals("kwd"))
            return true;
        if(kwd.equals(""+time))
            return true;
        return false;
    }

    void addMovieSchedule(MovieSchedule movieSchedule){
        scheduleList.add(movieSchedule);
    }
}
