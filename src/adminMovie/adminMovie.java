package adminMovie;

import java.util.Scanner;

public class adminMovie {
    String code;
    String title;
    String age;
    int runningTime;
    int price;

    adminMovie() {
    }

    public adminMovie(Object[] row) {
        code = (String) row[0];
        title = (String) row[1];
        age = (String) row[2];
        runningTime = Integer.parseInt((String) row[3]);
        price = Integer.parseInt((String) row[4]);
    }

    void read(Scanner scan) {
        code = scan.next();
        title = scan.next();
        age = scan.next();
        runningTime = scan.nextInt();
        price = scan.nextInt();
    }

    String[] getTexts() {
        return new String[] { code, title, "" + age, "" + runningTime, "" + price };
    }

    void print() {
        System.out.printf("[%2d] %s %s %d %d \n", code, title, age, runningTime, price);
    }

    boolean matches(String kwd) {
        if (code.contains(kwd))
            return true;
        if (title.contains(kwd))
            return true;
        if(age.equals(kwd))
            return true;
        if(kwd.equals(""+runningTime))
            return true;
        if(kwd.equals(""+price))
            return true;
        return title.equals(kwd);

    }

    @Override
    public String toString() {
        return String.format("%s(%s)", code,title);
    }
}