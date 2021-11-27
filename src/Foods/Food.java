package Foods;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import manage.Factory;
import manage.Manageable;

public class Food implements Manageable {
    Scanner scan=new Scanner(System.in);
    String code;
    String name;
    int price;
    ArrayList<Food> foodList = new ArrayList<>();

    public Food(String code)
    {
        this.code=code;
    }
    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub
        name = scan.next();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[%s] %s\t", code, name);
        System.out.printf("%5d원\n", price);
    }

    boolean matches(String[] kwdArr) {
        for (String kwd: kwdArr) {
            if (!matches(kwd))
                return false;
        }
        return true;
    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (kwd.length() > 2 && code.contains(kwd))
            return true;
        if (name.contains(kwd))
            return true;
        if (kwd.contentEquals(""))
            return true;
        return false;
    }

}
