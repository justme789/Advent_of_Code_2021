import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class AoC_10_b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textFile = new Scanner(new File("aoc.txt"));
        while (textFile.hasNextLine()) {
            String line = textFile.nextLine();
            list.add(line);
        }
        long autoC = 0;
        ArrayList<Long> tot = new ArrayList<Long>();
        Stack<String> stack = new Stack<String>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                String current = s.substring(i, i + 1);
                if (current.equals(")")) {
                    if (!stack.pop().equals("(")) {
                        stack.clear();
                        break;
                    }
                } else if (current.equals("]")) {
                    if (!stack.pop().equals("[")) {
                        stack.clear();
                        break;
                    }
                } else if (current.equals("}")) {
                    if (!stack.pop().equals("{")) {
                        stack.clear();
                        break;
                    }
                } else if (current.equals(">")) {
                    if (!stack.pop().equals("<")) {
                        stack.clear();
                        break;
                    }
                } else
                    stack.push(current);
            }
            while (!stack.isEmpty()) {
                String fix = stack.pop();
                autoC *= 5;
                if (fix.equals("(")) {
                    autoC += 1;
                } else if (fix.equals("[")) {
                    autoC += 2;
                } else if (fix.equals("{")) {
                    autoC += 3;
                } else {
                    autoC += 4;
                }
            }
            if (autoC > 0) {
                tot.add(autoC);
                autoC = 0;
            }
        }
        Collections.sort(tot);
        System.out.println(tot.get(tot.size()/2));
    }
}
