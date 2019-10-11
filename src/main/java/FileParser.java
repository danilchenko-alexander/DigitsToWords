import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    public FileParser() {
    }

    public final String filename = "words.txt";
    String[] str;
    List<String[]> list = new LinkedList<String[]>();
    public List<String[]> readFile(){
        try {
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine()){
                str = sc.nextLine().split(" ");
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file doesn't exists");
        } catch (IOException e) {
            System.out.println();
        }
        return list;
    }
}
