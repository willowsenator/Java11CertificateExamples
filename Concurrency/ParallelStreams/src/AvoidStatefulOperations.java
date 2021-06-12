import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvoidStatefulOperations {
    private static List<Integer> addValueStateful(IntStream source) {
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0)
                .forEach(i->{data.add(i);}); // STATEFUL: DON'T DO THIS!
        return data;
    }

    private static List<Integer> addValueNonStateful(IntStream source) {
        return source.filter(s->s%2 == 0).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args){
        // serial Stream stateful operation
        System.out.println(addValueStateful(IntStream.range(1,11)));

        // parallel Stream stateful operation
        System.out.println(addValueStateful(IntStream.range(1,11).parallel()));

        // parallel Stream non statefull operation
        System.out.println(addValueNonStateful(IntStream.range(1, 11).parallel()));

    }
}
