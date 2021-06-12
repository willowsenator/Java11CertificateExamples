import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        invokeAllTasks(); // Execute all tasks and returns a List of ordered Future instances
        invokeAnyTask(); // Execute a collection of tasks and returns the result of one of the tasks with success
    }

    private static void invokeAllTasks() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            System.out.println("begin");
            Callable<String> task = () -> "result";
            List<Future<String>> list = service.invokeAll(List.of(task, task, task));
            for(Future<String> future : list){
                System.out.println(future.get());
            }
            System.out.println("end");
        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }

    private static void invokeAnyTask() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            System.out.println("begin");
            Callable<String> task = () -> "result";
            String data = service.invokeAny(List.of(task, task, task));
            System.out.println(data);
            System.out.println("end");
        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}
