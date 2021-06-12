
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitingForAllTasks {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> "result");
            service.submit(() -> "result");
            service.submit(() -> "result");
        }finally {
            if(service != null){
                service.shutdown();
            }

            if(service != null){
                service.awaitTermination(1, TimeUnit.MINUTES);

                if(service.isTerminated()){
                    System.out.println("Finished!");
                }
                else{
                    System.out.println("At least one task is still running");
                }

            }
        }
    }
}
