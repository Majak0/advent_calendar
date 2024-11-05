import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class NotQuiteLisp {
    public static void main(String[] args) {
        int result = 0;
        try {
            String line = Files.readString(Paths.get("2015/inputs/day1.txt"));
            for (char caractere : line.toCharArray()) {
                result = caractere == '(' ? result+1 : result-1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}