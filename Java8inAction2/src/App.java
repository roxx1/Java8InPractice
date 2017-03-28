import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

	private static List<Dish> collectDishByLowCalories, collectVegetarianDishes, collectDishByHighCalorie,
			collectDishByHighCalorieSkip2, collectDishByTypeMeat;
	private static List<String> dishNames;
	private static List<Integer> collectLengthOfdishNames;

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT), new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER), new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER), new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH), new Dish("salmon", false, 450, Type.FISH));

		collectDishByLowCalories = menu.stream().filter(dish -> dish.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories)).collect(Collectors.toList());

		collectDishByLowCalories.forEach(entry -> System.out.println(entry.getName()));

		collectVegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

		collectDishByHighCalorie = menu.stream().limit(3).filter(dish -> dish.getCalories() > 300)
				.collect(Collectors.toList());

		collectDishByHighCalorieSkip2 = menu.stream().skip(2).filter(dish -> dish.getCalories() > 300)
				.collect(Collectors.toList());

		collectDishByTypeMeat = menu.stream().filter(dish -> dish.getType() == Type.MEAT).limit(2)
				.collect(Collectors.toList());

		dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());

		collectLengthOfdishNames = dishNames.stream().map(String::length).collect(Collectors.toList());

		
		
	}

}
