  
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;


// reference: https://www.youtube.com/watch?v=t1-YZ6bF-g0
// code sample: https://github.com/joeyajames/Java/blob/master/Java%208%20Streams/JavaStreams.java
public class JavaStreams {
    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(IntStream.range(1, 5).sum());
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(x -> System.out.print(x));
        System.out.println();

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10}).map(x -> x * x).average().ifPresent(x -> System.out.println(x));

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);

        // 8. Stream rows from text file, sort, filter, and print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands.sorted().filter(x -> x.length() > 13).forEach(x -> System.out.println(x));
        bands.close();
        System.out.println();

        // 9. Stream rows from text file, and save to List
        List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("jit"))
            .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
        bands2.forEach(x -> System.out.println(x));
        // this won't work because map is not a stream, but forEach somehow works for List
        // bands2.map(x -> x.toLowerCase).forEach(System.out::println);

        // Other example of forEach
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        
        items.forEach((k, v) -> System.out.println(k + ", " + v));

        items.forEach((k, v) -> {
            System.out.println(k + ", " + v);
            if("E".equals(k)) {
                System.out.println("hello E");
            }
        });

        // 10. Stream rows from CSV file and count
        Stream<String> row1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int)row1.map(x -> x.split(",")).filter(x -> x.length == 3).count();
        System.out.println(rowCount + " rows.");
        row1.close();

        // 11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2.map(x -> x.split(",")).filter(x -> x.length == 3 && Integer.parseInt(x[1]) > 15)
        .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();

        // 12. Stream rows from CSV file, store fields in HashMap
        Stream<String> row3 = Files.lines(Paths.get("data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = row3.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
            .collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
        row3.close();
        map.forEach((k, v) -> System.out.println(k + ", " + v));

        // 13. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
            .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
            .summaryStatistics();
        if(summary instanceof Object) {
            System.out.println("summary is Object");
        }
    
        System.out.println(summary);
    }
}