import java.util.stream.IntStream;

public class StreamsRange {

	public static void main(String[] args) {

		IntStream evenNos = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0);
		
		System.out.println(evenNos.count());
		
	}

}
