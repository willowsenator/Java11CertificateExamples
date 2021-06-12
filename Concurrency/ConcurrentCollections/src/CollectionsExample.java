import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CollectionsExample {
    public static void main(String[] args){
        // ConcurrentMap
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        // ConcurrentLinkedQueue
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek()); // 31
        System.out.println(queue.poll()); // 31


        //SkipList Collections
        Set<String> gardenAnimals = new ConcurrentSkipListSet<>();
        gardenAnimals.add("rabbit");
        gardenAnimals.add("gopher");
        gardenAnimals.stream().collect(Collectors.joining(",")); //gopher, rabbit

        Map<String, String> rainForestAnimalDiet = new ConcurrentSkipListMap<>();
        rainForestAnimalDiet.put("koala", "bamboo");
        rainForestAnimalDiet.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));

        // CopyOnWrite Collections
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for(var n: favNumbers){
            System.out.print(n +  " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println("Size: " + favNumbers.size());

        Set<Character> favLetters = new CopyOnWriteArraySet<>(List.of('a', 't'));
        for(char c: favLetters){
            System.out.print(c + " ");
            favLetters.add('s');
        }
        System.out.println();
        System.out.println("Size: " + favLetters.size());

        // BlockingQueue
        try{
            var blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }

        
    }
}
