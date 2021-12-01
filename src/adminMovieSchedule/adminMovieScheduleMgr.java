package adminMovieSchedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class adminMovieScheduleMgr {
    public static void main(String[] args) {
        adminMovieScheduleMgr a = new adminMovieScheduleMgr();
        a.mymain();
    }
    Scanner scan = new Scanner(System.in);
    static ArrayList<adminMovieSchedule> movieScheduleList = new ArrayList<>();
    void mymain() {
        readAll("movieSchedule.txt");
        //songs.stream().forEach(Song::print);
    }
    Scanner openFile(String fileName) {
        Scanner fileIn = null;
        File f = new File(fileName);
        try {
            fileIn = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return fileIn;
    }

    protected void readAll(String fileName) {
        Scanner fileIn = openFile(fileName);
        adminMovieSchedule a = null;
        fileIn.nextLine();
        while (fileIn.hasNext()) {
            a = new adminMovieSchedule();
            a.read(fileIn);
            movieScheduleList.add(a);
        }
        fileIn.close();
    }
    void addSong(adminMovieSchedule a) {
        movieScheduleList.add(a);
    }
    void removeAt(int index) {
        adminMovieSchedule s = movieScheduleList.get(index);
        movieScheduleList.remove(s);
        System.out.println(s + " 삭제");
    }
    adminMovieSchedule findMovie(String kwd) {
        for (adminMovieSchedule a : movieScheduleList)
            if (a.matches(kwd))
                return a;
        return null;
    }
}
