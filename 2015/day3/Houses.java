package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Houses {
    public static void main(String[] args) {
        String filename = "2015/day3/input.txt";
        System.out.println(partOne(filename));
        //System.out.println(partTwo(filename));
    }

    private static int partOne(String filename){
        int totalHouses = 0;
        boolean northChecked = false;
        boolean eastChecked = false;
        boolean southChecked = false;
        boolean westChecked = false;
        try {
            String line = Files.readString(Paths.get(filename));
            for (char caractere : line.toCharArray()) {
                System.out.println(caractere);
                switch (caractere) {
                    case '>':
                        if (!eastChecked) {
                            totalHouses++;
                        }
                        eastChecked = true;
                        break;
                    case '^':
                        if (!northChecked) {
                            totalHouses++;
                        }
                        northChecked = true;
                        break;
                    case 'v':
                        if (!southChecked) {
                            totalHouses--;
                        }
                        southChecked = true;
                        break;
                    case '<':
                        if (!westChecked) {
                            totalHouses++;
                        }
                        westChecked = true;
                        break;
                }
                // System.out.println(eastChecked + " - " + northChecked + " - " + southChecked + " - " + westChecked);
                // If the house is complete, reset values and add 1 to sum
                if (northChecked && southChecked && eastChecked && westChecked) {
                    northChecked = false;
                    eastChecked = false;
                    southChecked = false;
                    westChecked = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalHouses;
    }
}
