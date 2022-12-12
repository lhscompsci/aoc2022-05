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

 //       long totalScore = 0L;

        String[] lines = new String[8];
        for(int x=0; x<8; x++)
            lines[x] = infile.nextLine();

        Stack[] tower = new Stack[9];
        for(int x = 0; x < 9; x++)
            tower[x] = new Stack<String>();

        for(int x = 7; x>=0; x--){
            Scanner linebreaker = new Scanner(lines[x]);
            linebreaker.useDelimiter("");
            String line = "";
            while(linebreaker.hasNext()){
                String part = linebreaker.next();
                if(!part.equals("[")&&!part.equals("]"))
                    line=line+part;
            }
            linebreaker = new Scanner(line+" ");
            out.println("processed line: " + line);
            linebreaker.useDelimiter(" ");
            int y = 0;
            while(linebreaker.hasNext()){
                String pkg = linebreaker.next();
                out.println("current item to push: " + pkg);
                if(!pkg.equals(" ")) {
                    if(!pkg.equals(""))
                       tower[y].push(pkg);
                    out.println(pkg + " added to tower " + y);
//                    linebreaker.next();
                    y++;
                }

                                if(linebreaker.hasNext())
                    linebreaker.next();
            }
        }
        for(int x = 0; x < tower.length; x++)
            out.println(tower[x]);

        infile.nextLine();
        infile.nextLine();
        while(infile.hasNext()){
            String next = infile.nextLine();
            Scanner parser = new Scanner(next);
            parser.next();
            int amt = parser.nextInt();
            parser.next();
            int from = parser.nextInt()-1;
            parser.next();
            int to = parser.nextInt()-1;
            out.println("move "+amt + " from "+from+" to "+to);
            for(int i = 0; i < amt; i++){
                if(!tower[from].isEmpty())
                    tower[to].push(tower[from].pop());
            }
            for(int x = 0; x < tower.length; x++)
                out.println(tower[x]);


        }
        String answer = "";
        for(int x = 0; x < tower.length; x++) {
            out.println(tower[x]);
            if (!tower[x].isEmpty())
                answer = answer + tower[x].peek();

        }
        out.println(answer);

    }
}
