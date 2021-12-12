import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AoC_11_b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        int[][] oct = new int[10][10];
        Scanner textfile = new Scanner(new File("aoc.txt"));
        int count = 0;
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 10; j++) {
                oct[i][j] = Integer.parseInt(list.get(i).substring(j, j + 1));
            }
        }
        int steps = 0;
        while (steps < 1) {
            Set<String> history = new HashSet<String>();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    oct[i][j]++;
                }
            }
            boolean same = false;
            while (!same) {
                int[][] copy = Arrays.stream(oct).map(int[]::clone).toArray(int[][]::new);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (oct[i][j] == 10 && !history.contains(i + "" + j)) {
                            if (i + 1 < 10 && oct[i + 1][j] != 0 && oct[i + 1][j] != 10) {
                                history.add(i + "" + j);
                                oct[i + 1][j]++;
                            }
                            if (i - 1 >= 0 && oct[i - 1][j] != 0 && oct[i - 1][j] != 10) {
                                oct[i - 1][j]++;
                                history.add(i + "" + j);
                            }
                            if (j + 1 < 10 && oct[i][j + 1] != 0 && oct[i][j + 1] != 10) {
                                oct[i][j + 1]++;
                                history.add(i + "" + j);
                            }
                            if (j - 1 >= 0 && oct[i][j - 1] != 0 && oct[i][j - 1] != 10) {
                                oct[i][j - 1]++;
                                history.add(i + "" + j);
                            }
                            if (i - 1 >= 0 && j - 1 >= 0 && oct[i - 1][j - 1] != 0 && oct[i - 1][j - 1] != 10) {
                                oct[i - 1][j - 1]++;
                                history.add(i + "" + j);
                            }
                            if (i + 1 < 10 && j + 1 < 10 && oct[i + 1][j + 1] != 0 && oct[i + 1][j + 1] != 10) {
                                oct[i + 1][j + 1]++;
                                history.add(i + "" + j);
                            }
                            if (i + 1 < 10 && j - 1 >= 0 && oct[i + 1][j - 1] != 0 && oct[i + 1][j - 1] != 10) {
                                oct[i + 1][j - 1]++;
                                history.add(i + "" + j);
                            }
                            if (i - 1 >= 0 && j + 1 < 10 && oct[i - 1][j + 1] != 0 && oct[i - 1][j + 1] != 10) {
                                oct[i - 1][j + 1]++;
                                history.add(i + "" + j);
                            }
                        }
                    }

                }
                for (int i = 0; i < 10; i++) {
                    if (Arrays.equals(copy[i], oct[i])) {
                        same = true;
                    } else {
                        same = false;
                        break;
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (oct[i][j] >= 10) {
                        oct[i][j] = 0;
                    }
                }
            }
            int zeros = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (oct[i][j] == 0) {
                        zeros++;
                    }
                }
            }
            if(zeros != 100){
                steps--;
                count++;
            }
            steps++;
        }
        System.out.println(count+1);
    }
}
