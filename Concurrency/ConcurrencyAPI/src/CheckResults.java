import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CheckResults {
    private static int counter;

    public static void main(String[] args) throws Exception{
        ExecutorService service = null;

        try{
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(()->{
                for(int i=0; i <500; i++) counter++;
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");

        } catch(InterruptedException ex){
            System.out.println("Not reached in time");
        }
        finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}
