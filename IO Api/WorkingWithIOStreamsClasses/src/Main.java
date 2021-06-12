import javax.imageio.IIOException;
import java.io.*;

public class Main {

    // Copy File without buffer
    public void copyFile(File src, File dest) throws IOException {
        try(var in = new FileInputStream(src);
            var out = new FileOutputStream(dest)){
            int b;
            while((b = in.read()) != -1){
                out.write(b);
            }
        }
    }

    // CopyFile with Buffer
    public void copyFileWithBuffer(File src, File dest) throws IOException{
        try(var in = new BufferedInputStream(new FileInputStream(src));
        var out = new BufferedOutputStream(new FileOutputStream(dest))){

            var buffer = new byte[1024];
            int lengthRead;

            while((lengthRead = in.read(buffer)) > 0){
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }


    // Reading and writing character data
    public void copyTextFile(File src, File dst) throws IOException{
        try(var reader = new FileReader(src);
        var writer = new FileWriter(dst)){
            int b;
            while((b = reader.read()) != -1){
                writer.write(b);
            }
        }
    }

    // Buffering Character Data
    public void copyTextFileWithBuffer(File src, File dest) throws IOException{
        try(var reader = new BufferedReader(new FileReader(src));
            var writer = new BufferedWriter(new FileWriter(dest))){
            String s;
            while((s = reader.readLine()) != null){
                writer.write(s);
                writer.newLine();
            }
        }
    }


}
