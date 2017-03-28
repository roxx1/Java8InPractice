import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		List<Transaction> sortingTrans2011ByValue = transactions.stream().filter(trans -> trans.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		List<String> collectUniqueCities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity)
				.distinct().collect(Collectors.toList());

		// System.out.println(collectUniqueCities);

		List<String> tradersInCambridgeSorted = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity() == "Cambridge").map(Trader::getName).distinct().sorted()
				.collect(Collectors.toList());

		System.out.println(tradersInCambridgeSorted);

		String traderNamesSorted = transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted()
				.collect(Collectors.joining("-"));

		boolean anyTraderInMilan = transactions.stream().map(Transaction::getTrader)
				.anyMatch(trader -> trader.getCity() == "Milan");

		Stream<Transaction> filterTransByCityCambridge = transactions.stream()
				.filter(trans -> trans.getTrader().getCity() == "Cambridge");

		filterTransByCityCambridge.forEach(trans -> System.out.print("---" + trans.getValue()));

		int maxValueTrans = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max).intValue();

		int minValueTrans = transactions.stream().min(Comparator.comparing(Transaction::getValue)).get().getValue();

	}

}
