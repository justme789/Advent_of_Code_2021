import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_9_a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        int[][] heightMap = new int[100][100];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 100; j++) {
                heightMap[i][j] = Integer.parseInt(list.get(i).substring(j, j + 1));
            }
        }
        int risk = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 0 && j == 0) {
                    if (heightMap[i][j + 1] > heightMap[i][j] && heightMap[i + 1][j] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (i == 0 && j == heightMap[i].length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && heightMap[i + 1][j] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (i == heightMap.length - 1 && j == 0) {
                    if (heightMap[i][j + 1] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (i == heightMap.length - 1 && j == heightMap[i].length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (i == 0) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && heightMap[i + 1][j] > heightMap[i][j]
                            && heightMap[i][j + 1] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (i == heightMap.length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]
                            && heightMap[i][j + 1] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (j == 0) {
                    if (heightMap[i + 1][j] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]
                            && heightMap[i][j + 1] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else if (j == heightMap.length - 1) {
                    if (heightMap[i + 1][j] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]
                            && heightMap[i][j - 1] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                } else {
                    if (heightMap[i + 1][j] > heightMap[i][j] && heightMap[i - 1][j] > heightMap[i][j]
                            && heightMap[i][j - 1] > heightMap[i][j] && heightMap[i][j + 1] > heightMap[i][j]) {
                        risk += (1 + heightMap[i][j]);
                    }
                }
            }
        }
        System.out.println(risk);
    }
}
