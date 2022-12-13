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

        String[] lines = new String[8];
        for(int x=0; x<8; x++)
            lines[x] = infile.nextLine();

        Stack[] tower = new Stack[9];
        for(int x = 0; x < 9; x++)
            tower[x] = new Stack<String>();

        for(int x = 7; x>=0; x--){


            char[] pieces = lines[x].toCharArray();

            ArrayList<Character> toPush = new ArrayList<>();
            for(int z = 1; z<pieces.length; z+=4){
                toPush.add(pieces[z]);
            }

            int y = 0;
            for(int z = 0; z<toPush.size(); z++){

                String pkg = "" + toPush.get(z);
                if(!pkg.equals(" ")) {
                    tower[y++].push(pkg);

                }
                else {
                    y++;
                }
            }
        }


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
            Stack<String> temp = new Stack<>();
            for(int i = 0; i < amt; i++){
                if(!tower[from].isEmpty())
                    temp.push((String) tower[from].pop());
            }
            for(int i = 0; i < amt; i++){
                if(!temp.isEmpty())
                    tower[to].push(temp.pop());
            }

        }
        String answer = "";
        for(int x = 0; x < tower.length; x++) {
            out.println(tower[x]);
            if (!tower[x].isEmpty())
                answer = answer + tower[x].peek();

        }
        out.println(answer);

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


            char[] pieces = lines[x].toCharArray();

            ArrayList<Character> toPush = new ArrayList<>();
            for(int z = 1; z<pieces.length; z+=4){
                toPush.add(pieces[z]);
            }

            int y = 0;
            for(int z = 0; z<toPush.size(); z++){

                String pkg = "" + toPush.get(z);
                 if(!pkg.equals(" ")) {
                        tower[y++].push(pkg);

                }
                else {
                    y++;
                }
            }
        }


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
