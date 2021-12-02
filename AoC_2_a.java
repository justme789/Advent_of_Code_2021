import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_2_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < list.size(); i++) {
            int indexOfSpace = list.get(i).indexOf(' ');
            int val = Integer.parseInt(list.get(i).substring(indexOfSpace+1));
            if (list.get(i).charAt(0)=='f') {
                x+=val;
            }
            else if (list.get(i).charAt(0)=='u') {
                y-=val;
            }
            else if (list.get(i).charAt(0)=='d') {
                y+=val;
            }
        }
        System.out.println(x*y);
    }
}
