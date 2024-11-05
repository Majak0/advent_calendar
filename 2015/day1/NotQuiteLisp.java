package day1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class NotQuiteLisp {
    public static void main(String[] args) {
        String filename = "2015/day1/input.txt";
        System.out.println(partOne(filename));
        System.out.println(partTwo(filename));
    }

    private static int partOne(String filename){
        int result = 0;
        try {
            String line = Files.readString(Paths.get(filename));
            for (char caractere : line.toCharArray()) {
                result = caractere == '(' ? result+1 : result-1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int partTwo(String filename){
        int result = 0;
        int index = 0;
        try {
            String line = Files.readString(Paths.get(filename));
            for (char caractere : line.toCharArray()) {
                result = caractere == '(' ? result+1 : result-1;
                index++;
                if (result == -1) {
                    return(index);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}