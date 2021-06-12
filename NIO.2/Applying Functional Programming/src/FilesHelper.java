import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilesHelper {
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    private FilesHelper() {

    }

    public static void listDirectoryContent(Path source) throws IOException {
        try(var s = Files.list(source)){
            s.forEach(System.out::println);
        }
    }

    public static void copyPath(Path source, Path target){
        try{
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            if(Files.isDirectory(source)){
                try(var s = Files.list(source)){
                    s.forEach(p-> copyPath(
                            p, target.resolve(p.getFileName())
                    ));
                }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static long getSize(Path p){
        try{
            return Files.size(p);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return 0L;
    }

    public static long getPathSize(Path source) throws IOException{
        try(var s = Files.walk(source)){
            return s.parallel()
                    .filter(p -> !Files.isDirectory(p))
                    .mapToLong(FilesHelper::getSize)
                    .sum();

        }
    }

    public static List<Path> findJava(Path path) throws IOException {
        List<Path> result = new ArrayList<>();

        try(var s = Files.find(path, 10,
                (p, a) -> a.isRegularFile() && p.toString().endsWith(".java"))){

            result.addAll(s.collect(Collectors.toList()));
        }

        return result;
    }

    public static void printLines(Path path) throws IOException {
        try(var s = Files.lines(path)){
            s.forEach(System.out::println);
        }
    }

}
