import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_13_b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> coords = new ArrayList<String>();
        ArrayList<String> folds = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        temp = coords;
        Scanner textfile = new Scanner(new File("aoc.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            if(line.isEmpty()){
                temp = folds;
            }
            temp.add(line);
        }
        folds.remove(0);
        coords.forEach(e->{
            x.add(Integer.parseInt(e.substring(0, e.indexOf(","))));
            y.add(Integer.parseInt(e.substring(e.indexOf(",")+1)));
        });
        int bigX, bigY;
        bigX = bigY = 0;
        for(int i=0; i<x.size(); i++){
            if(x.get(i) > bigX){
                bigX = x.get(i);
            }
            if(y.get(i) > bigY){
                bigY = y.get(i);
            }
        }
        int[][] paper = new int[bigY+1][bigX+1];
        for(int i=0; i<x.size(); i++){
            paper[y.get(i)][x.get(i)] = 1;
        }
        ArrayList<String> cleanFolds = new ArrayList<String>();
        folds.forEach(e -> {
            cleanFolds.add(e.substring(e.lastIndexOf(" ")+1, e.length()));
        });
        cleanFolds.forEach(e->{
            if(e.charAt(0)=='y'){
                int xVal = Integer.parseInt(e.substring(e.indexOf("=")+1, e.length()));
                int [][] first = new int [xVal][paper[0].length];
                int [][] second = new int [xVal][paper[0].length];
                for(int i = 0; i < first.length; i++){
                    for(int j = 0; j < first[i].length; j++){
                        first[i][j] = paper[i][j];
                    }
                }
                for(int i = second.length; i > 0 ; i--){
                    for(int j = 0; j < second[xVal-i].length; j++){
                        second[xVal-i][j] = paper[i+xVal][j];
                    }
                }
                for(int i = 0; i < paper.length; i++){
                    for(int j = 0; j < paper[i].length; j++){
                        paper[i][j] = 0;
                    }
                }
                for(int i = 0; i < first.length; i++){
                    for(int j = 0; j < first[i].length; j++){
                        paper[i][j] = first[i][j] + second[i][j];
                        
                    }
                }
                
            }
            else{
                int yVal = Integer.parseInt(e.substring(e.indexOf("=")+1, e.length()));
                int [][] first = new int [paper.length][yVal];
                int [][] second = new int [paper.length][yVal];
                for(int i = 0; i < first.length; i++){
                    for(int j = 0; j < first[i].length; j++){
                        first[i][j] = paper[i][j];
                    }
                }
                for(int i = 0; i < second.length ; i++){
                    for(int j = second[i].length; j > 0  ; j--){
                        second[i][yVal-j] = paper[i][j+yVal];
                    }
                }
                for(int i = 0; i < paper.length; i++){
                    for(int j = 0; j < paper[i].length; j++){
                        paper[i][j] = 0;
                    }
                }
                for(int i = 0; i < first.length; i++){
                    for(int j = 0; j < first[i].length; j++){
                        paper[i][j] = first[i][j] + second[i][j];
                        
                    }
                }
                
            }
        });
        int lastx , lasty;
        lastx = lasty = 0;
        for(int i = 0; i<paper.length; i++){
            for(int j = 0; j< paper[i].length; j++){
                if(paper[i][j] > 0){
                    if(i> lastx){
                        lastx = i;
                    }
                    if(j> lasty){
                        lasty = j;
                    }
                }
            }
        }
        for(int i = 0; i< lastx+1; i++){
            System.out.println();
            for (int j = 0; j < lasty; j++) {
                String print = "-";
                if(paper[i][j] > 0){
                    print = "0";
                }
                else paper[i][j] = 1;
                System.out.print(print);
            }
        }
    }
}
