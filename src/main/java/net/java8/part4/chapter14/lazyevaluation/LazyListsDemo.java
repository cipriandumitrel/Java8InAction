package net.java8.part4.chapter14.lazyevaluation;

public class LazyListsDemo {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>(5, new MyLinkedList<>(10, new EmptyList<>()));
        System.out.println(list.head());

        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);

        numbers = from(2);
        int primeTwo = primes(numbers).head();
        System.out.println("primeTwo: " + primeTwo);
        int primeThree = primes(numbers).tail().head();
        System.out.println("primeThree: " + primeThree);
        int primeFive = primes(numbers).tail().tail().head();
        System.out.println("primeFive: " + primeFive);

        //printAll(primes(from(2)));
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail()
                .filter(n -> n % numbers.head() != 0)));
    }

    static <T> void printAll(MyList<T> list){
        if (list.isEmpty())
            return;
        System.out.println(list.head());
        printAll(list.tail());
    }
}
