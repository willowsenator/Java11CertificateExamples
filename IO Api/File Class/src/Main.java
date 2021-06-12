import java.io.File;

public class Main {

    public static void main(String[] args){

        printFileProperties(new File(Utils.composePath("File Class", "src", "zoo.txt")));
        printFileProperties(new File(Utils.composePath("File Class", "src")));

    }



    private static void printFileProperties(File file){
        System.out.println("File Exists: " + file.exists());

        if(file.exists()){
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent path: " + file.getParent());

            if(file.isFile()){
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            }
            else {
                for(File subfile : file.listFiles()){
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }
}
