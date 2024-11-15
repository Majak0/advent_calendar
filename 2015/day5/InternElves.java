package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InternElves {
    public static void main(String[] args) {
        String path = "2015/day5/input.txt";
        //System.out.println(partOne(path));
        System.out.println(partTwo(path));
    }

    static int partOne(String file){
        int total = 0;
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                if (!data.contains("ab") && !data.contains("cd") && !data.contains("pq") && !data.contains("xy")){
                    int nbVowels = 0;
                    boolean hasDoubleLetter = false;
                    // Check if at least 3 vowels in string
                    for (int index=0; index<data.length(); index++){
                        if (data.charAt(index)=='a' || data.charAt(index)=='e' || data.charAt(index)=='i' || data.charAt(index)=='o' || data.charAt(index)=='u'){
                            nbVowels++;
                        } // Check double letters
                        if (index != data.length()-1 && data.charAt(index) == data.charAt(index+1)){
                            hasDoubleLetter = true;
                        }
                    }
                    System.out.println(nbVowels + " - " + hasDoubleLetter + " : " + total + "\n\n---");
                    total += nbVowels>=3 && hasDoubleLetter ? 1 : 0;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return total;
    }

    public static int partTwo(String file) {
        int total = 0;
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("Checking: " + data);

                boolean hasDoublePair = false;
                boolean hasRepeatingLetterWithGap = false;

                // Map pour stocker la première apparition de chaque paire
                Map<String, Integer> pairPositions = new HashMap<>();

                // Vérification de chaque condition
                for (int i = 0; i < data.length() - 1; i++) {
                    // Condition 1: Vérifie les paires de lettres
                    String pair = data.substring(i, i + 2);
                    if (pairPositions.containsKey(pair)) {
                        if (i - pairPositions.get(pair) > 1) {
                            hasDoublePair = true;
                        }
                    } else {
                        pairPositions.put(pair, i);
                    }

                    // Condition 2: Vérifie la lettre répétée avec une lettre entre les deux
                    if (i < data.length() - 2 && data.charAt(i) == data.charAt(i + 2)) {
                        hasRepeatingLetterWithGap = true;
                    }

                    // Si les deux conditions sont remplies, on peut arrêter la vérification
                    if (hasDoublePair && hasRepeatingLetterWithGap) {
                        break;
                    }
                }

                System.out.println("Double Pair: " + hasDoublePair + ", Repeating Letter with Gap: " + hasRepeatingLetterWithGap);

                if (hasDoublePair && hasRepeatingLetterWithGap) {
                    total++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return total;
    }
}