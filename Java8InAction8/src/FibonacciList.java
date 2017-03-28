import java.util.stream.Stream;

public class FibonacciList {

	public static void main(String[] args) {
		// list having first no as second no of preceding list and second no as
		// sum of preceding list
		Stream.iterate(new int[] { 0, 1 }, arr -> new int[] { arr[1], arr[0] + arr[1] }).limit(20)
				.forEach(entry -> System.out.println(entry[0] + "   " + entry[1]));

		// fibonacci nos
		Stream.iterate(new int[] { 0, 1 }, fib -> new int[] { fib[1], fib[0] + fib[1] }).map(t -> t[0]).limit(10)
				.forEach(System.out::println);

		// generate method (No func for subsequent nos)
		Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
	}

}
