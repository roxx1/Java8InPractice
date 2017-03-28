
public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public Boolean test(Apple a) {
		return a.getWeight() > 150;
	}

}
