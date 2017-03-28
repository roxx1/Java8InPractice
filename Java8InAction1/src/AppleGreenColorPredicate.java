
public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public Boolean test(Apple a) {
		return a.getColor().equals("green");
	}

}
