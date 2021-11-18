package movie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import mgr.Factory;
import mgr.Manager;

public class Kiosk {

    Scanner scan = new Scanner(System.in);
    static Manager<User> userMgr = new Manager();
    static Manager<Movie> movieMgr = new Manager();
    static Manager<MovieSchedule> scheduleMgr = new Manager();
    //static Manager<ScreeningHall> hallMgr = new Manager();
    static Manager<Seat> seatMgr = new Manager();

    void run() {
        userMgr.readAll("user.txt", new Factory<User>() {
            public User create() {
                return new User();
            }
        });
        movieMgr.readAll("movie.txt", new Factory<Movie>() {
            public Movie create() {
                return new Movie();
            }
        });
        scheduleMgr.readAll("movieSchedule.txt", new Factory<MovieSchedule>() {
            public MovieSchedule create() {
                return new MovieSchedule();
            }
        });
//        hallMgr.readAll("ScreeningHall.txt", new Factory<ScreeningHall>() {
//			public ScreeningHall create() {
//				return new ScreeningHall();
//			}
//		});
//		orderMgr.readAll("seats.txt", new Factory<Order>() {
//			public Order create() {
//				return new Order();
//			}
//		});
        menu();
    }

    void menu() {
        int num;
        while (true) {
            System.out.print("(1)고객정보 (2)영화 (3)상영관좌석보기 (4)상영시간표보기 (기타) 종료 ");
            num = scan.nextInt();
            if (num < 1 || num > 4)
                break;
            switch (num) {
//			case 1:
//				itemMgr.printAll();
//				break;
                case 2:
                    movieMgr.printAll();
                    break;
                case 3:
                    scheduleMgr.printAll();
                    break;
                case 4:
                    scheduleMgr.printAll();
                    break;
                default:
                    break;
            }
        }
    }

    void searchMenu() {
        int num;
        while (true) {
            System.out.print("(1)영화검색 (2)사용자검색 (3)예약검색 (기타) 종료 ");
            num = scan.nextInt();
            if (num < 1 || num > 3)
                break;
            switch (num) {
//			case 1:
//				itemMgr.search(scan);
//				break;
//			case 2:
//				userMgr.search(scan);
//				break;
//			case 3:
//				orderMgr.search(scan);
//				break;
                default:
                    break;
            }
        }
    }

    static Seat findSeat(String kwd) {
        return seatMgr.find(kwd);
    }

    static MovieSchedule findSchedule(String kwd) {
        return scheduleMgr.find(kwd);
    }

//	static Item findItem(String kwd) {
//		return (Item) itemMgr.find(kwd);
//	}
//
//	static User findUser(String kwd) {
//		return (User) userMgr.find(kwd);
//	}
//
//	static Order findOrder(String kwd) {
//		return (Order) orderMgr.find(kwd);
//	}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Kiosk k = new Kiosk();
        k.run();
    }
}
