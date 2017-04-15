package java8.stream;

import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args){
		Object[] powers = Stream.iterate(1.0, p  -> p * 2)
				//.peek(e -> System.out.println("Fetching "+ e) )
				//.limit(20).toArray();
				.filter(r -> !Double.isInfinite(r))
				.peek(e -> System.out.println("Fetching "+ e) )
				.toArray();
		
		
		
	}
}
