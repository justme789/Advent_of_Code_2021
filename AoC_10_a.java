import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AoC_10_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textFile = new Scanner(new File("aoc.txt"));
        while (textFile.hasNextLine()) {
            String line = textFile.nextLine();
            list.add(line);
        }
        int error = 0;
        Stack<String> stack = new Stack<String>();
        for(String s: list) {
            for(int i=0; i<s.length()-1; i++) {
                String current = s.substring(i,i+1);
                if(current.equals(")")){
                    if(!stack.pop().equals("(")){
                        error+=checker(current);
                        break;
                    }
                }
                else if(current.equals("]")){
                    if(!stack.pop().equals("[")){
                        error+=checker(current);
                        break;
                    }
                }
                else if(current.equals("}")){
                    if(!stack.pop().equals("{")){
                        error+=checker(current);
                        break;
                    }
                }
                else if(current.equals(">")){
                    if(!stack.pop().equals("<")){
                        error+=checker(current);
                        break;
                    }
                }
                else stack.push(current);
            }
        }
        System.out.println(error);
    }
    public static int checker(String s) {
        if(s.equals(")")){
            return 3;
        }
        if(s.equals("]")){
            return 57;
        }
        if(s.equals("}")){
            return 1197;
        }
        else return 25137;
    }
}
