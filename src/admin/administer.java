package admin;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;
import movie.Movie;
import movie.MovieSchedule;

public class administer {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Movie> movieList = new ArrayList<>();
    static ArrayList<MovieSchedule> movieScheduleList = new ArrayList<>();

    static Manager<Movie>movieMgr=new Manager();
    static Manager<MovieSchedule>movieScheduleMgr=new Manager();


    static void run() {
        movieMgr.readAll("movie.txt", new Factory<Movie>() {
            public Movie create() {
                return new Movie();
            }
        });

        movieScheduleMgr.readAll("movieSchedule.txt", new Factory<MovieSchedule>() {
            public MovieSchedule create() {
                return new MovieSchedule();
            }
        });
        menu();
    }

    static void menu()
    {
        while (true) {
            System.out.println("1.영화 목록");
            System.out.println("2.영화 추가");
            System.out.println("3.영화 삭제");
            System.out.println("4.영화 상영시간표");
            System.out.println("5.영화 시간표 추가");
            System.out.println("6.영화 시간표 삭제");
            System.out.println("7.영화 예매 내역");

            int num = scan.nextInt();
            switch (num) {
                case 1:
                    movieMgr.printAll();
                    adminInsert.printmovietList();
                    break;
                case 2:
                    adminInsert.movieInsert();
                    break;
                case 3:
                    adminDelete.movieDelete();
                    break;
                case 4:
                    movieScheduleMgr.printAll();
                    adminInsert.printmovieScheduletList();
                    break;
                case 5:
                    adminInsert.movieScheduleInsert();
                    break;
                case 6:
                    adminDelete.movieScheduleDelete();
                    break;
                default:
                    break;
            }
        }
    }


    static Movie findMovie(String kwd) {
        return (Movie) movieMgr.find(kwd);
    }

    static MovieSchedule findMovieSchedule(String kwd) {
        return (MovieSchedule) movieScheduleMgr.find(kwd);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        administer m = new administer();
        m.run();
    }

}