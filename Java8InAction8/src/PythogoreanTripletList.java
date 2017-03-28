import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythogoreanTripletList {

	public static void main(String[] args) {

		// boxed() IntStream ------> Stream basically Unboxing int----->Integer
	  List<int[]> pythogoreanTripletList = IntStream.rangeClosed(1, 100)
				        .boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.boxed().map(b -> 
						 new int[] { a, b, (int) Math.sqrt(a * a + b * b) }))
				        .collect(Collectors.toList());
	  
	  pythogoreanTripletList.stream().forEach(list->Arrays.stream(list).forEach(x->System.out.print(x+"  ")));
	  
	}

	
	
}
