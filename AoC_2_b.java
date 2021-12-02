import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_2_b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        long x = 0;
        long y = 0;
        int aim = 0;
        for (int i = 0; i < list.size(); i++) {
            int indexOfSpace = list.get(i).indexOf(' ');
            int val = Integer.parseInt(list.get(i).substring(indexOfSpace+1));
            if (list.get(i).charAt(0)=='f') {
                x+=val;
                y+=val*aim;
            }
            else if (list.get(i).charAt(0)=='u') {
                aim-=val;
            }
            else if (list.get(i).charAt(0)=='d') {
                aim+=val;
            }
        }
        System.out.println(x*y);
    }
}
