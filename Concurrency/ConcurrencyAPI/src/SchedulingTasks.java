import java.util.concurrent.*;

public class SchedulingTasks {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = null;

        try{
            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> System.out.println("R1");
            Callable<String> task2 = () -> "R2";
            Runnable task3 = () -> System.out.println("R3");
            Runnable task4 = () -> System.out.println("R4");

            ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
            ScheduledFuture<String> r2 = service.schedule(task2, 1, TimeUnit.MINUTES);
            service.scheduleAtFixedRate(task3, 10, 4, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(task4, 0, 1, TimeUnit.MINUTES);


            while(!r1.isDone() && !r2.isDone()){
                Thread.sleep(1000);
            }

            System.out.println(r2.get());

        }finally{
            if(service != null){
                service.shutdown();
            }
        }
    }
}
