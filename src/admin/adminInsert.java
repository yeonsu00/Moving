package admin;

import java.util.ArrayList;
import java.util.Scanner;

import hw2.Contact;
import movie.Movie;
import movie.MovieSchedule;

public class adminInsert {
    static Scanner scan = new Scanner(System.in);

    static ArrayList<MovieSchedule> movieScheduleList = new ArrayList<>();
    static ArrayList<Movie> movieList = new ArrayList<>();

    static String movieCode;
    static String movieName;
    static String movieAgeLimit;
    static int runningTime;
    static int moviePrice;
    static int movieStartHour;
    static int movieStartMinute;
    static int movieEndHour;
    static int movieEndMinute;

    static void movieInsert() {
        System.out.println("새로운 영화 제목을 입력해주세요:");
        movieName = scan.next();

        if (findMovie(movieName) != null) {
            System.out.println("이미 존재하는 영화 입니다.");
            return;
        }
        Movie m = new Movie(movieName);
        m.readInsert(scan);
        movieList.add(m);
    }

    static void printmovietList() {
        int i = 0;
        for (Movie m : movieList)
            m.prints(i++);
    }

    static void movieScheduleInsert() {
        System.out.println("새로운 영화 코드를 입력해주세요:");
        movieCode = scan.next();

        if (findMovie(movieName) != null) {
            System.out.println("이미 존재하는 영화 입니다.");
            return;
        }
        MovieSchedule ms = new MovieSchedule(movieName);
        ms.readInsert(scan);
        movieScheduleList.add(ms);

    }

    static void printmovieScheduletList() {
        int i = 0;
        for (MovieSchedule ms : movieScheduleList)
            ms.prints(i++);
    }

    static Movie findMovie(String Name) {
        for (Movie m : movieList) {
            if (m.matches(Name))
                return m;
        }
        return null;
    }

    static Movie findMovieSchedule(String Code) {
        for (Movie m : movieList) {
            if (m.matches(Code))
                return m;
        }
        return null;
    }
}
