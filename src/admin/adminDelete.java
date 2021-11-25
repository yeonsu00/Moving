package admin;

import java.util.ArrayList;
import java.util.Scanner;

import movie.Movie;
import movie.MovieSchedule;

public class adminDelete {
    static Scanner scan = new Scanner(System.in);

    static ArrayList<MovieSchedule> movieScheduleList = new ArrayList<>();
    static ArrayList<Movie> movieList = new ArrayList<>();

    static void movieScheduleDelete() {
        System.out.println("영화코드를 입력하세요:");
        String Code = scan.next();

        for (int i = 0; i < movieScheduleList.size(); i++) {
            if (Code.equals(movieScheduleList.get(i).movieCode))
                movieScheduleList.remove(i);
        }

        System.out.println("삭제가 완료되었습니다.");
    }

    static void movieDelete() {
        System.out.println("영화 제목을 입력하세요:");
        String Title = scan.next();

        for (int i = 0; i < movieList.size(); i++) {
            if (Title.equals(movieList.get(i).movieName))
                movieList.remove(i);
        }


        System.out.println("삭제가 완료되었습니다.");
    }
}