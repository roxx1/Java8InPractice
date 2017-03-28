import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupingByPartitionByDepthEx {

	public static boolean isPrime(int candidate) {
		return IntStream.range(2, candidate).noneMatch(i -> candidate % 2 == 0);
	}

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT), new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER), new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER), new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH), new Dish("salmon", false, 450, Type.FISH));

		Map<Type, List<Dish>> groupDishByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));

		groupDishByType.entrySet().stream().forEach(System.out::println);

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;

			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}

		));

		Map<Integer, Long> countOfDishCalories = menu.stream()
				.collect(Collectors.groupingBy(Dish::getCalories, Collectors.counting()));

		Map<Type, Optional<Dish>> mostCalorieByType = menu.stream().collect(
				Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));

		Map<Type, Dish> collectMostCalorieByType = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), dish -> dish.get())));

		System.out.println("--------------------------------");

		collectMostCalorieByType.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + "   " + entry.getValue()));

		// --------------------------//PartitionBy//----------------------------------------------------------------------------------------

		Map<Boolean, List<Dish>> partitionIsVegetarian = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian));

		Map<Boolean, Dish> partitionByDishNameAndFindMin = menu.stream().collect(Collectors.partitioningBy(
				Dish::isVegetarian,
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Dish::getName)), Optional::get)));

		///////////////////PRIME NO/////////////////////////////////////////////////////////////////////////////
		
		Map<Boolean, List<Integer>> primeOrNot = IntStream.rangeClosed(2, 100).boxed()
				.collect(Collectors.partitioningBy(entry -> isPrime(entry)));

	}

}
