package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class NoMath {
    public static void main(String[] args) {
        String filename = "2015/day2/input.txt";
        System.out.println(partOne(filename));
    }

    private static int partOne(String path){
        int result = 0;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] factors = data.split("x");
                result += getPaper(factors);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }

    private static int getPaper(String[] factors){
        int[] sides = new int[3]; // l x w x h
        sides[0] = 2 * Integer.valueOf(factors[0]) * Integer.valueOf(factors[1]); // 2 * l * w
        sides[1] = 2 * Integer.valueOf(factors[1]) * Integer.valueOf(factors[2]); // 2 * w * h
        sides[2] = 2 * Integer.valueOf(factors[2]) * Integer.valueOf(factors[0]); // 2 * h * l

        Arrays.sort(sides);

        int sum = IntStream.of(sides).sum() + sides[0]/2; // Add the smallest side to sum
        return sum;
    }
}
