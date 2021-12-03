import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_3_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        int ones = 0;
        int zeros = 0;
        String val = "";
        for(int k = 0; k < list.get(0).length(); k++){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).charAt(k) == '1') {
                ones++;
            }
            else if(list.get(i).charAt(k) == '0'){
                zeros++;
            }
        }
        if(zeros > ones){
            val = val +"0";
        }
        else{
            val = val +"1";
        }
        ones = 0;
        zeros = 0;
    }
        System.out.println((4095-Integer.valueOf(val,2))*Integer.valueOf(val,2));
    }
}
