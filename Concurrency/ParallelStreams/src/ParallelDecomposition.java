import java.util.List;

public class ParallelDecomposition {
    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return input;
    }

    private static void serialStream(){
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5).stream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start)/ 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    private static void pararellStreamUnOrdered(){
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5).parallelStream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start)/ 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    private static void pararellStreamOrdered(){
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5).parallelStream().map(w -> doWork(w)).forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start)/ 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }


    public static void main(String[] args) {
        serialStream();
        pararellStreamUnOrdered();
        pararellStreamOrdered();
    }
}
