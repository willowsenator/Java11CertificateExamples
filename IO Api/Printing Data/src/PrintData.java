import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintData {
    public static void main(String[] args) throws FileNotFoundException {
        // print
        try(var out = new PrintWriter(Utils.composePath("Printing Data", "src", "zoo.log"))){
            out.write(String.valueOf(5)); // Writer method
            out.print(5); // PrintWriter method
        }

        // println
        System.out.print(System.getProperty("line.separator") + "LineSeparator");
        System.out.println(System.lineSeparator() + "LineSeparator");

        // format
        String name = "Lindsey";
        int orderId = 5;

        System.out.format("Hello "+ name + ", order " + orderId + " is ready\n");
        System.out.format("Hello %s, order %d is ready%n", name, orderId);

        String name2 = "James";
        double score = 90.25;
        int total = 100;
        System.out.format("%s:%n      Score: %.1f out of %d%n", name2, score, total);

        var pi = 3.14159265359;
        System.out.format("[%f]%n", pi);
        System.out.format("[%12.8f]%n", pi);
        System.out.format("[%012f]%n", pi);
        System.out.format("[%12.2f]%n", pi);
        System.out.format("[%.3f]%n", pi);
    }
}
