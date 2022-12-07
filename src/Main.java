import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws Throwable {

        partOne();
        partTwo();

    }

    private static void partTwo() throws Throwable {
        Scanner infile = new Scanner(new File("test.dat"));



        long totalScore = 0L;
        while(infile.hasNext()){
            String next = infile.nextLine();


        }

        out.println(totalScore);
    }

    private static void partOne() throws Throwable {
        Scanner infile = new Scanner(new File("test.dat"));

        long totalScore = 0L;
        while(infile.hasNext()){
            String next = infile.nextLine();

        }

        out.println(totalScore);

    }
}
