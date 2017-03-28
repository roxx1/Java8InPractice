import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx {

	public static void main(String[] args) {
		List<Integer> someNos = Arrays.asList(1, 2, 3, 4, 5);

		Integer noSquaredDivBy3 = someNos.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst().orElse(0);
		System.out.println(noSquaredDivBy3);

		Integer mult = someNos.stream().reduce(1, (x, y) -> x * y).intValue();
		System.out.println(mult);

		Integer sum = someNos.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		Optional<Integer> min = someNos.stream().reduce(Integer::min);

		min.ifPresent(System.out::println);

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT), new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER), new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER), new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH), new Dish("salmon", false, 450, Type.FISH));

		int dishesTotalCalories = menu.stream().mapToInt(dish -> dish.getCalories()).sum();
		
		OptionalInt minCalorieDish = menu.stream().mapToInt(Dish::getCalories).min();
		
		minCalorieDish.ifPresent(System.out::println);
		
		
	}

}
