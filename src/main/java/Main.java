import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() *10));
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}