package movie;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;

import javax.swing.*;

public class Movie implements Manageable {
    //A1001 장르만로맨스 15 113 14000
    public String movieCode;
    public String movieName;
    public String ageLimit;
    public int time;
    public int price;
    ArrayList<MovieSchedule> scheduleList = new ArrayList();
    private JTable table1;
    private JSpinner spinner1;

    public Movie(String name) {
        // TODO Auto-generated constructor stub        this.movieName=name;
    }

    public Movie() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        movieCode=scan.next();
        movieName=scan.next();
        ageLimit=scan.next();
        time=scan.nextInt();
        price=scan.nextInt();
    }

    public void readInsert(Scanner scan)
    {
        System.out.println("새로운 영화 코드를 입력해주세요:");
        movieCode = scan.next();

        System.out.println("연령제한을 입력해주세요:");
        this.ageLimit = scan.next();

        System.out.println("새로운 영화 러닝타임을 입력해주세요:");
        this.time = scan.nextInt();

        System.out.println("새로운 영화 가격을 입력해주세요:");
        this.price = scan.nextInt();
        System.out.println("저장이 완료되었습니다.");
    }

    @Override
    public void print() {
        System.out.printf("[%s] %s\t%s세\t상영시간:%d분\t가격:%d원",movieCode,movieName,ageLimit,time,price);
        System.out.println();
    }

    public void prints(int i) {
        System.out.printf("[%s] %s\t%s세\t상영시간:%d분\t가격:%d원",movieCode,movieName,ageLimit,time,price);
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (kwd.length() > 2 && movieCode.equals(kwd))
            return true;
        if(movieName.equals("kwd"))
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
