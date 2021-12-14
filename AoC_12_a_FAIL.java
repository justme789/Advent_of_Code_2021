import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class AoC_12_a_FAIL {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Set<String> paths = new HashSet<String>();
        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        Map<String, ArrayList<String>> sCave = new HashMap<String, ArrayList<String>>();
        Map<String, ArrayList<String>> bCave = new HashMap<String, ArrayList<String>>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            int indexOfDash = current.indexOf("-");
            String fPart = current.substring(0, indexOfDash);
            String sPart = current.substring(indexOfDash + 1);
            ArrayList<String> connect = new ArrayList<String>();
            System.out.println(fPart + "   " + fPart.length() + "    " + sPart + "   " + sPart.length());
            if (fPart.length() == 5) {
                start.add(sPart);
            }
            if (sPart.length() == 5) {
                start.add(fPart);
            }
            if (fPart.length() == 3) {
                System.out.println("i get here");
                end.add(sPart);
            }
            if (sPart.length() == 5) {
                end.add(fPart);
            }
            if (sPart.length() == 2 && fPart.length() == 2) {
                if (sCave.get(fPart) == null) {
                    connect.add(sPart);
                    sCave.put(fPart, new ArrayList<String>(connect));
                    connect.clear();
                } else {
                    connect = sCave.get(fPart);
                    connect.add(sPart);
                    sCave.put(fPart, new ArrayList<String>(connect));
                    connect.clear();
                }
                if (sCave.get(sPart) == null) {
                    connect.add(fPart);
                    sCave.put(sPart, new ArrayList<String>(connect));
                    connect.clear();
                } else {
                    connect = sCave.get(sPart);
                    connect.add(fPart);
                    sCave.put(sPart, new ArrayList<String>(connect));
                    connect.clear();
                }
            }
        }

        System.out.println(sCave.toString());
        System.out.println(start.toString());
        for (String s : start) {
            Set<String> history = new HashSet<String>();
            int counter = 0;
            int prevCounter = 0;
            Stack<String> nodes = new Stack<String>();
            Stack<Integer> counterStack = new Stack<Integer>();
            nodes.add(s);
            counterStack.push(0);
            while (!nodes.isEmpty()) {
                paths.add(nodes.toString());            
                ArrayList<String> next = sCave.get(nodes.peek());

                if (counterStack.peek() >= next.size()) {
                    String pop = nodes.pop();
                    history.remove(pop);
                    if (nodes.isEmpty()) {
                        break;
                    }
                    counterStack.pop();
                    counter = counterStack.pop() + 1;
                    counterStack.push(counter);
                    //history.clear();
                } else if (history.contains(next.get(counterStack.peek()))) {                    
                    counter = counterStack.pop() + 1;
                    counterStack.push(counter);
                } else {
                    if (next.get(counterStack.peek()).charAt(0) + next.get(counterStack.peek()).charAt(1) > 194) {
                        history.add(next.get(counterStack.peek()));
                    }
                    nodes.push(next.get(counterStack.peek()));
                    counterStack.push(0);
                }
            }
        }
        ArrayList<String> idek = new ArrayList<String>(paths);
        Collections.sort(idek);
        idek.forEach(e -> {
            System.out.println(e);
        });
        Set<String> cleaned = new HashSet<String>();
        for (String s : start) {
            if (s.charAt(0) + s.charAt(1) > 194) {
                for (String ss : paths) {
                    if (ss.indexOf("[" + s) != ss.lastIndexOf(s) - 1 && ss.substring(0, 3).equals("[" + s)) {
                        cleaned.add(ss);
                    }
                }
            }
        }
        paths.removeAll(cleaned);
        ArrayList<String> test = new ArrayList<String>();
        for (String endP : end) {
            for (String path : paths) {
                if (path.substring(path.length() - 3, path.length() - 1).equals(endP)) {
                    test.add(path);
                }
            }
        }

        Collections.sort(test);
        test.forEach(e -> {
            System.out.println(e);
        });
        System.out.println(test.size());

    }
}