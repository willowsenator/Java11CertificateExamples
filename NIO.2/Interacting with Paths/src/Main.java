
import com.sun.nio.file.ExtendedCopyOption;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // Default System
        Path path = FileSystems.getDefault().getPath("pandas/algo.txt");
        System.out.println(path);


        // Remote File System
        //FileSystem fileSystem = FileSystems.getFileSystem(new URI("https://www.selikoff.net/"));

        // Resolve
        Path p = Paths.get("/whale");
        Path p2 = p.resolve("/krill");
        System.out.println("Resolve with absolute path in argument: " + p2);

        // getName(int index), getNameCount()
        Path path1 = Path.of("/land/hippo/harry.happy");
        System.out.println(path1);
        for(int i=0; i < path1.getNameCount(); i++){
            System.out.println(" Element " + i + " is: " + path1.getName(i));
        }

        // Subpath
        var p3 = Paths.get("/mammal/omnivore/raccoon.image");
        System.out.println("Path is: " + p3);
        for(int i=0; i<p3.getNameCount(); i++){
            System.out.println("    Element " + i + " is: " + p3.getName(i));
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p3.subpath(0, 3));
        System.out.println("subpath(1,2): " + p3.subpath(1,2));
        System.out.println("subpath(1,3): " + p3.subpath(1, 3));


        // AbsolutePath
        Path p4 = Path.of("C:\\birds\\egret.txt");
        System.out.println("p4 is Absolute? " + p4.isAbsolute());
        System.out.println("Absolute p4: " + p4.toAbsolutePath());

        Path p5 = Path.of("birds/condor.txt");
        System.out.println("p5 is Absolute? " + p5.isAbsolute());
        System.out.println("Absolute p5: " + p5.toAbsolutePath());

        // Relativize
        var p6 = Path.of("fish.txt");
        var p7 = Path.of("friendly/birds.txt");
        System.out.println(p6.relativize(p7));
        System.out.println(p7.relativize(p6));

        // Cleaning Up
        var p8 = Path.of("./armadillo/../shells.txt");
        System.out.println("Without normalize: " + p8);
        System.out.println("Normalize path : " + p8.normalize());


    }
}
