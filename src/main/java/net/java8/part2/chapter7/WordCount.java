package net.java8.part2.chapter7;

import java.util.stream.Stream;

/**
 * Created by ciprian on 10/25/17.
 */

public class WordCount {

  public static final String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " +
          "mi  ritrovai in una  selva oscura" +
          " che la  dritta via era   smarrita ";

  public static void main(String[] args) {
    System.out.println("Word count iteratively: " + countWordsIteratively(SENTENCE));
  }

  private static int countWordsIteratively(String testString) {
    int counter = 0;
    boolean lastWasSpace = true;
    for (char c : testString.toCharArray()) {
      if (Character.isWhitespace(c)) {
        lastWasSpace = true;
      } else {
        if (lastWasSpace) counter++;
        lastWasSpace = false;
      }
    }

    return counter;
  }

  private static class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
      this.counter = counter;
      this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
      if(Character.isWhitespace(c)){
        return lastSpace ? this : new WordCounter(counter, true);
      }
      else{
        return lastSpace ? new WordCounter(counter + 1, false) : this;
      }
    }

    public WordCounter combine(WordCounter wordCounter){
      return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
      return counter;
    }
  }

  private static int countWords(Stream<Character> stream) {
    WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
            WordCounter::accumulate,
            WordCounter::combine);
    return wordCounter.getCounter();
  }
}
