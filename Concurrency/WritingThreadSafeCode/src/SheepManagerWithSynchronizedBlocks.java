import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerWithSynchronizedBlocks {
    private int sheepCount = 0;
    private void incrementAndReport(){
        synchronized(this) {
            System.out.print(++sheepCount + " ");
        }
    }

    public static void printDaysWork(){
        synchronized (SheepManagerWithSynchronizedBlocks.class){
            System.out.println("Finished work");
        }
    }

    public static void main(String[] args){
        ExecutorService service = null;

        try{
            service = Executors.newFixedThreadPool(20);
            SheepManagerWithSynchronizedBlocks manager = new SheepManagerWithSynchronizedBlocks();

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
