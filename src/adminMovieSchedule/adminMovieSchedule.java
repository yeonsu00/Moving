package adminMovieSchedule;

import java.util.Scanner;

public class adminMovieSchedule {
    String code;
    int StartHour;
    int StartMinute;
    int EndHour;
    int EndMinute;

    adminMovieSchedule() {
    }

    public adminMovieSchedule(Object[] row) {
        code = (String) row[0];
        StartHour = Integer.parseInt((String) row[1]);
        StartMinute = Integer.parseInt((String) row[2]);
        EndHour = Integer.parseInt((String) row[3]);
        EndMinute = Integer.parseInt((String) row[4]);
    }

    void read(Scanner scan) {
        code = scan.next();
        StartHour = scan.nextInt();
        StartMinute = scan.nextInt();
        EndHour = scan.nextInt();
        EndMinute = scan.nextInt();


    }

    String[] getTexts() {
        return new String[] { code,""+StartHour, ""+StartMinute, ""+EndHour, ""+EndMinute};
    }

    void print() {
        System.out.printf("[%2s] %d %d %d %d \n", code,StartHour,StartMinute,EndHour,EndMinute );
    }

    boolean matches(String kwd) {
        if (code.contains(kwd))
            return true;
        if (kwd.equals(""+StartHour))
            return true;
        if(kwd.equals(""+StartMinute))
            return true;
        if(kwd.equals(""+EndMinute))
            return true;
        if(kwd.equals(""+EndMinute))
            return true;
        return code.equals(kwd);

    }

}