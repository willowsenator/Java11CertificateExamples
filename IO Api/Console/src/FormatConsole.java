import java.io.Console;
import java.util.Locale;

public class FormatConsole {
    public static void main(String[] args){
        Console console = System.console();

        if(console == null){
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to Our Zoo!");
            console.format("It has %d animals and employs %d people", 391, 25);
            console.writer().println();
            console.printf("The zoo span %5.1f acres%n", 128.91);

            // Locale
            console.writer().format(new Locale("es", "ES"), "Hello World!");
        }
    }
}
