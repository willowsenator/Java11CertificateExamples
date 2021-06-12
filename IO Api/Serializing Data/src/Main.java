import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Ishmael", 8, true));

        File dataFile = new File(Utils.composePath("Serializing Data", "src", "gorilla.data"));

        FileUtils.saveToFile(gorillas, dataFile, Gorilla.class);

        var gorillasFromDisk = FileUtils.readFromFile(dataFile, Gorilla.class);
        System.out.println(gorillasFromDisk);

        var chimpazees = new ArrayList<Chimpazee>();
        chimpazees.add(new Chimpazee("Ham", 2, 'A'));
        chimpazees.add(new Chimpazee("Enos", 4, 'B'));
        File dataFile2 = new File(Utils.composePath("Serializing Data", "src", "chimpazee.data"));

        FileUtils.saveToFile(chimpazees, dataFile2, Chimpazee.class);

        var chimpazeesFromDisk = FileUtils.readFromFile(dataFile2, Chimpazee.class);
        System.out.println(chimpazeesFromDisk);
    }
}
