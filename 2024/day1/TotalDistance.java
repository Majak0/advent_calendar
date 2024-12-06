import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TotalDistance {

    static List<Integer> left = new ArrayList<>();
    static List<Integer> right = new ArrayList<>();

    public static void main(String[] args) {
        String filename = "2024/day1/input.txt";
        completeArrays(filename);
        System.out.println("First part : "+partOne());
        System.out.println("Second part : "+partTwo());
    }

    private static int partOne() {
        int result = 0;

        for (int index = 0; index < left.size(); index++) {
            if (left.get(index)>right.get(index)) result+=left.get(index)-right.get(index);
            else result+=right.get(index)-left.get(index);
        }
        return result;
    }

    private static int partTwo(){
        int result = 0;

        for (int value : left) {
            int occurrences = Collections.frequency(right, value);
            result += value * occurrences;
        }
        return result;
    }

    private static void completeArrays(String filename){
        try {
            File file = new File(filename);
            try (Scanner scan = new Scanner(file)) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] exploded = line.trim().split("\\s+");
                    if (exploded.length == 2) {
                        try {
                            left.add(Integer.valueOf(exploded[0]));
                            right.add(Integer.valueOf(exploded[1]));
                        } catch (NumberFormatException e) {
                            System.out.println("Erreur lors de la conversion : " + line);
                        }
                    } else {
                        System.out.println("Format incorrect : " + line);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}