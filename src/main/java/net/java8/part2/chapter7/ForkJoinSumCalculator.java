package net.java8.part2.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by Ciprian on 10/24/2017.
 * Sum calculator using the Fork/Join framework
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private long[] numbers; //the array of numbers to be summed

    //the initial and final positions of the portion of the array processed by this sub-task.
    private int start;
    private int end;

    //the size of the array under which this task is no longer split into sub-tasks
    public static final long THRESHOLD = 10_000;

    //private constructor used to recursively create subtasks of the main task
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    //public constructor used to create the main task
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        else{

            //Create a subtask to sum the first half of the array.
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);

            //Asynchronously execute the newly created subtask using another thread of the ForkJoinPool.
            leftTask.fork();

            //Create a subtask to sum the second half of the array.
            ForkJoinSumCalculator rightTask =
                    new ForkJoinSumCalculator(numbers, start + length/2, end);

            //Execute this second subtask synchronously, potentially allowing further recursive splits.
            Long rightResult = rightTask.compute();

            //Read the result of the first subtask or wait for it if it isn’t ready.
            Long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }

    //Simple algorithm calculating the result of a sub-task when it's no longer divisible
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        System.out.println(forkJoinSum(100));
    }
}
