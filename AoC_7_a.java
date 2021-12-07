import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AoC_7_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        System.out.println(list.toString());
        for (int i = 0; i < list.get(0).lastIndexOf(","); i++) {
            int indexOfComma = list.get(0).indexOf(",", i);
            vals.add(Integer.parseInt(list.get(0).substring(i, indexOfComma)));
            i = indexOfComma;
        }
        vals.add(Integer.parseInt(list.get(0).substring(list.get(0).lastIndexOf(",") + 1, list.get(0).length())));
        int sum = 99999999;
        for (int i = 0; i < 2000; i++) {
            int temp = 0;
            for (int j = 0; j < vals.size(); j++){
                temp+= Math.abs(vals.get(j) - i);
            }
            if(temp<sum){
                sum = temp;
            }
        }
        System.out.println(sum);
    }
}
