import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_8_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        String vals = "";
        int one, four, seven, eight;
        one=four=seven=eight=0;
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        for(int i = 0; i<list.size(); i++) {
           vals+=list.get(i).substring(list.get(i).indexOf("|")+1, list.get(i).length());
        }
        String[] values = vals.split(" ");
        for(int i = 0; i< values.length; i++){
            if(values[i].length()==2){
                one++;
            }
            if(values[i].length()==3){
                seven++;
            }
            if(values[i].length()==4){
                four++;
            }
            if(values[i].length()==7){
                eight++;
            }
        }
        System.out.println(one+four+seven+eight);
    }
}
