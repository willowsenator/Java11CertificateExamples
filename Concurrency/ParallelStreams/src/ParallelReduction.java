import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.*;

public class ParallelReduction {
    public static void main(String[] args){
        // serial stream
        System.out.println(List.of(1,2,3,4,5,6).stream().findAny().get());

        // parallel stream
        System.out.println(List.of(1,2,3,4,5,6).parallelStream().findAny().get());

        // Combining Results with Reduce
        System.out.println(List.of('w','o','l','f').parallelStream().reduce("", (s1,c) -> s1+c, (s2,s3)->s2+s3));

        // PROBLEMATIC ACCUMULATOR
        System.out.println(List.of(1,2,3,4,5,6).parallelStream().reduce(0, (a,b)->a-b));
        System.out.println(List.of("w","o","l","f").parallelStream().reduce("X",String::concat));

        // Combining Results with collect
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();

        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set);

        // Performing a Parallel Reduction on a Collector
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy.collect(Collectors.toConcurrentMap(String::length,k->k,
                (s1, s2) -> s1 + "," + s2));
        System.out.println(map);
        System.out.println(map.getClass());

    }
}
