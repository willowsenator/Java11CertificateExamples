import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //FilesHelper.listDirectoryContent(Path.of(FilesHelper.USER_DIR));
        /*FilesHelper.copyPath(
                Path.of(FilesHelper.USER_DIR),
                Path.of(FilesHelper.USER_HOME +
                        FilesHelper.FILE_SEPARATOR +
                        "Desktop" +
                        FilesHelper.FILE_SEPARATOR +
                        "copy"));*/

        //var size = FilesHelper.getPathSize(Path.of("D:\\Games"));
        //System.out.format("Total Size: %.2f MB", (size / 1_000_000.0));

        List<Path> javaFiles = FilesHelper.findJava(Path.of(FilesHelper.USER_DIR));
        javaFiles.forEach(
                p ->{
                    try {
                        System.out.println("*******************************************");
                        System.out.println(p);
                        System.out.println("*******************************************");
                        FilesHelper.printLines(p);
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        );
    }


}
