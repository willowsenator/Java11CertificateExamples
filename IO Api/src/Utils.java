import java.util.Arrays;

public class Utils {
    private final static String WORKING_DIR = System.getProperty("user.dir");
    private  final static String FILE_SEPARATOR = System.getProperty("file.separator");

    private Utils() {
    }

    public static String composePath(String... args){
        String path = null;

        if(args.length > 0){
            path = Arrays.stream(args).reduce(WORKING_DIR, (s1, s2) -> s1 + FILE_SEPARATOR + s2);
        }

        return path;
    }
}
