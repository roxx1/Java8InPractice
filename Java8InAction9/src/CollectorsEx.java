import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsEx {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT), new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER), new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER), new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH), new Dish("salmon", false, 450, Type.FISH));

		Optional<Dish> minCalorieDish = menu.stream()
				.collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));

		Integer sumOfCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));

		Double averageOfCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

		Map<Integer, List<Dish>> groupByCalories = menu.stream().collect(Collectors.groupingBy(Dish::getCalories));

		Map<Boolean, List<Dish>> partitionByVegetarianDishes = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian));

		String dishJoinByNames = menu.stream().map(Dish::getName).collect(Collectors.joining(","));

		Integer collectSumOfCalories = menu.stream().map(Dish::getCalories)
				.collect(Collectors.reducing(0, Integer::sum));

		Optional<Integer> collectSumOfDishesOptional = menu.stream().map(Dish::getCalories)
				.collect(Collectors.reducing(Integer::sum));

		collectSumOfDishesOptional.ifPresent(System.out::println);

	}

}
