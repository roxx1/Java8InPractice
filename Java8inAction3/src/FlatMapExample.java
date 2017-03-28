import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {

		String[] listOfWords = { "Hello", "Everyone", "This", "is", "Java8" };

		List<String> collectDistinctLetters = Arrays.stream(listOfWords).map(s -> s.split(""))
				.flatMap(arr -> Arrays.stream(arr)).distinct().collect(Collectors.toList());

		collectDistinctLetters.forEach(letter -> System.out.print(letter + " "));
		System.out.println();

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		Stream<int[]> pairingOfLists = numbers1.stream().flatMap(x -> numbers2.stream().map(y -> new int[] { x, y }));

		pairingOfLists.collect(Collectors.toList()).forEach(entry -> {
			int sum = 0;
			for (int x : entry) {
				sum += x;
				System.out.print(x + " ");
			}
			System.out.println("    sum is -> " + sum);

		});
		;

		System.out.println("-------------------------------------------------");

		List<int[]> pairingOfListsWithSumDivisibleBy3 = numbers1.stream()
				.flatMap(x -> numbers2.stream().filter(y -> (x + y) % 3 == 0).map(y -> new int[] { x, y }))
				.collect(Collectors.toList());

		pairingOfListsWithSumDivisibleBy3.stream()
				.forEach(entry -> Arrays.stream(entry).forEach(token -> System.out.print(token + "  ")));
	}

}
