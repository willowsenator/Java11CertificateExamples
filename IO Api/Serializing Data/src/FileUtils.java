import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private FileUtils(){

    }

    public static <T> void saveToFile(List<T> data, File dataFile, Class<T> tClass) throws IOException {
        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
            for(T fact : data){
                out.writeObject(fact);
            }
        }
    }

    public static <T> List<T> readFromFile(File dataFile, Class<T> tClass) throws IOException, ClassNotFoundException{
        var primates = new ArrayList<T>();

        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
            while(true){
                var object = in.readObject();
                    primates.add((T) object);
            }
        } catch (EOFException e){
            // File end reached
        }
        return primates;
    }
}
