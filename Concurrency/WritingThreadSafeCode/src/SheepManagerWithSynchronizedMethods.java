import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerWithSynchronizedMethods {
    private int sheepCount = 0;
    private synchronized void incrementAndReport(){
            System.out.print(++sheepCount + " ");
    }

    public static synchronized void printDaysWork(){
            System.out.println("Finished work");
    }

    public static void main(String[] args){
        ExecutorService service = null;

        try{
            service = Executors.newFixedThreadPool(20);
            SheepManagerWithSynchronizedMethods manager = new SheepManagerWithSynchronizedMethods();

            for(int i=0; i < 10; i++){
                    service.submit(() -> manager.incrementAndReport());
            }
            printDaysWork();

        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}
