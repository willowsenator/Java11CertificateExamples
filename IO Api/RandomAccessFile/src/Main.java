import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static void main(String[] args) throws IOException {


        RandomAccessFile file = new RandomAccessFile(composePath("prueba.txt"), "rw");
        file.writeUTF("Hola");

        // Change file pointer to the beginning
        file.seek(0);
        System.out.println(file.readUTF());
    }

    private static String composePath(String path){
        return USER_DIR + FILE_SEPARATOR + "RandomAccessFile" + FILE_SEPARATOR + "src" + FILE_SEPARATOR + path;
    }
}
