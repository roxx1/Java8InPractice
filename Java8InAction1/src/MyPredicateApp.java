import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyPredicateApp {

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<Apple>();

		for (Apple apple : inventory)
			if (p.test(apple))
				result.add(apple);

		return result;
	}

	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(new Apple("green", 80), new Apple("blue", 140), new Apple("green", 30),
				new Apple("red", 160));

		List<Apple> filterGreenApples = filterApples(inventory, (Apple a) -> a.getColor().equals("green"));
		List<Apple> filterHeavyWeightApples = filterApples(inventory, (Apple a) -> a.getWeight() > 150);

		inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		
		inventory.stream().forEach((Apple a)->System.out.println(a.getWeight()));
		
	}

}
