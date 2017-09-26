package net.java8.part2.chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class BuildingStreams {

    public static void main(String[] args) {
        //Streams from values
        Stream<String> streams = Stream.of("Cipica ", "este ", "gushter!!!");
        streams.map(String::toUpperCase).forEach(System.out::print);
        //Stream<String> emptyStream = Stream.empty();

        //Streams from Arrays
        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("\nSum is " + sum);

        //Streams from Files
        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("D:\\coding\\Java8\\src\\main\\resources\\chapter5\\data.txt"),
                             Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Unique words: " + uniqueWords);

        //Streams from Functions
        Stream.iterate(0, n -> n + 2).limit(10).forEach(i -> System.out.print(i + " "));
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
