import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_3_b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        System.out
                .println(Integer.valueOf(loopStuff('0', '1', list), 2) * Integer.valueOf(loopStuff('1', '0', list), 2));

    }

    public static String loopStuff(char val1, char val2, ArrayList<String> list) {
        int ones = 0;
        int zeros = 0;
        char mostCom = '0';
        ArrayList<String> tempMost = new ArrayList<String>();
        for (int k = 0; k < list.get(0).length(); k++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).charAt(k) == '1') {
                    ones++;
                } else if (list.get(i).charAt(k) == '0') {
                    zeros++;
                }
            }

            if (zeros > ones) {
                mostCom = val1;
            } else {
                mostCom = val2;
            }
            ones = 0;
            zeros = 0;

            for (int l = 0; l < list.size(); l++) {
                if (list.get(l).charAt(k) == mostCom) {
                    tempMost.add(list.get(l));
                }
            }
            list = new ArrayList<String>(tempMost);
            tempMost.clear();
            if (list.size() == 1) {
                return list.get(0);
            }
        }
        return null;
    }
}
