import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class AoC_14 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Map<String, String> dict = new HashMap<String, String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        String template = list.get(0);
        list.remove(0);
        list.remove(0);

        int steps = 10;
        list.forEach(e -> {
            dict.put(e.substring(0, 2), e.substring(e.length() - 1));
        });
        Map<String, Long> count = new HashMap<String, Long>();
        for (int i = 0; i < template.length() - 1; i++) {
            if (count.containsKey(template.substring(i, i + 2))) {
                count.put(template.substring(i, i + 2), count.get(template.substring(i, i + 2)) + 1);
            } else
                count.put(template.substring(i, i + 2), (long) 1);
        }

        while (steps > 0) {
            Map<String, Long> countDif = new HashMap<String, Long>();
            for (Entry<String, Long> entry : count.entrySet()) {
                countDif.put(entry.getKey(), entry.getValue());
            }
            for (String s : dict.keySet()) {
                if (count.containsKey(s)) {
                    if (countDif.containsKey(s.charAt(0) + dict.get(s))) {

                        countDif.put(s.charAt(0) + dict.get(s), countDif.get(s.charAt(0) + dict.get(s)) + count.get(s));

                    } else {

                        countDif.put(s.charAt(0) + dict.get(s), count.get(s));

                    }
                    if (countDif.containsKey(dict.get(s) + s.charAt(1))) {

                        countDif.put(dict.get(s) + s.charAt(1), countDif.get(dict.get(s) + s.charAt(1)) + count.get(s));

                    } else {

                        countDif.put(dict.get(s) + s.charAt(1), count.get(s));

                    }
                    countDif.put(s, (countDif.get(s)) - count.get(s));
                }
            }

            for (Entry<String, Long> entry : countDif.entrySet()) {
                count.put(entry.getKey(), entry.getValue());
            }
            for (Entry<String, Long> entry : countDif.entrySet()) {
                if (entry.getValue() < 1) {
                    count.remove(entry.getKey());
                }
            }
            steps--;
        }
        String comb = "";
        for (String s : count.keySet()) {
            comb += s;
        }
        Set<String> set = new HashSet<String>(Arrays.asList(comb.split("")));
        Map<String, Long> map = new HashMap<String, Long>();
        set.forEach(e -> {
            map.put(e, (long) 0);
        });
        for (String s : count.keySet()) {
            map.put(s.substring(0, 1), map.get(s.substring(0, 1)) + count.get(s));
            map.put(s.substring(1), map.get(s.substring(1)) + count.get(s));
        }
        ArrayList<Long> vals = new ArrayList<Long>(map.values());
        Collections.sort(vals);
        System.out.println(((vals.get(vals.size() - 1) - vals.get(0)) / 2) - 1);
    }
}