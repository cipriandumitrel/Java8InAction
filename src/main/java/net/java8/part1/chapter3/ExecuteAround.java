package net.java8.part1.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ciprian on 1/30/2017.
 */

public class ExecuteAround {

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("D:\\coding\\Java8\\src\\main\\resources\\chapter3\\data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor bfp) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("D:\\coding\\Java8\\src\\main\\resources\\chapter3\\data.txt"))) {
            return bfp.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(processFileLimited());

        String oneLine = processFile(BufferedReader::readLine);
        System.out.println(oneLine);

        String twoLines = processFile(b -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }
}


