import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        // Closing Wrapped Streams
        try(var ois = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(Utils.composePath("Common IO Stream Operations","src", "zoo-banner.txt"))))){

           ois.writeObject("Hello");
        }

        // Manipulating Input Streams

        // Mark and reset
        readData(new BufferedInputStream(new ByteArrayInputStream("LION".getBytes())));
        System.out.println();

        // Skip
        skipData(new BufferedInputStream(new ByteArrayInputStream("TIGERS".getBytes())));

        // Flush
        try(var fos = new FileOutputStream(Utils.composePath("Common IO Stream Operations","src","flush-example.txt"))){
           for(var i=0; i<1000;i++){
               fos.write('a');
               if(i % 100 == 0){
                   fos.flush();
               }
           }
        }
    }

    private static void skipData(InputStream is) throws IOException{
        System.out.print((char) is.read());
        is.skip(2);
        is.read();
        System.out.print((char) is.read());
        System.out.print((char) is.read());

    }

    private static void readData(InputStream is) throws IOException{
        System.out.print((char)is.read());
        if(is.markSupported()){
            is.mark(100); // MarKs up to 100 bytes
            System.out.print((char) is.read());
            System.out.print((char)is.read());
            is.reset();

            System.out.print((char) is.read());
            System.out.print((char) is.read());
            System.out.print((char) is.read());

        }

    }
}
