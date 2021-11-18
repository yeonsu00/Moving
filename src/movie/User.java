package movie;

import java.util.Scanner;
import mgr.Manageable;

public class User implements Manageable {
    String name;
    String phone;
    String id;
    int point;

    //스캐너로 읽고 출력
    public void read(Scanner scan) {
        id=scan.next();
        name=scan.next();
        phone=scan.next();
    }
    public void print() {
        System.out.format("ID: %d NAME: %s PHONE: %s\n", id, name, phone);
    }

    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if(id.equals("kwd"))
            return true;
        if(phone.equals("kwd"))
            return true;
        if(name.equals("kwd"))
            return true;
        return false;
    }

}