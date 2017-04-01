import java.util.Optional;
import java.util.Properties;

public class OptionalEx2Practical {

	public static Optional<Integer> stringToInt(String str) {
		try {
			return Optional.ofNullable(Integer.parseInt(str));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

	public static int readValues(Properties props, String key) {
		return Optional.ofNullable(props.getProperty(key)).flatMap(OptionalEx2Practical::stringToInt)
				.filter(val -> val > 0).orElse(0);
	}

	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-3");

		Integer val = readValues(props, "a");
		System.out.println(val);
		
		Integer val2 = readValues(props, "b");
		System.out.println(val2);
		
		Integer val3 = readValues(props, "p");
		System.out.println(val3);
		
	}

}
