package adminMovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class adminMovieMgr {
    public static void main(String[] args) {
        adminMovieMgr a = new adminMovieMgr();
        a.mymain();
    }
    Scanner scan = new Scanner(System.in);
    static ArrayList<adminMovie> movieList = new ArrayList<>();
    void mymain() {
        readAll("movie.txt");
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
        adminMovie m = null;
        fileIn.nextLine();
        while (fileIn.hasNext()) {
            m = new adminMovie();
            m.read(fileIn);
            movieList.add(m);
        }
        fileIn.close();
    }
    void addSong(adminMovie a) {
        movieList.add(a);
    }
    void removeAt(int index) {
        adminMovie s = movieList.get(index);
        movieList.remove(s);
        System.out.println(s + " 삭제");
    }
    adminMovie findMovie(String kwd) {
        for (adminMovie a : movieList)
            if (a.matches(kwd))
                return a;
        return null;
    }
}
