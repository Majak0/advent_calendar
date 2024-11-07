package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InternElves {
    public static void main(String[] args) {
        String path = "2015/day5/input.txt";
        System.out.println(partOne(path));
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
                        System.out.println(data.charAt(index));
                        if (data.charAt(index)=='a' || data.charAt(index)=='e' || data.charAt(index)=='i' || data.charAt(index)=='o' || data.charAt(index)=='u'){
                            nbVowels++;
                        }
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
}
