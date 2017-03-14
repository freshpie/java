package java8.lambda;

import java.math.BigInteger;

public class LambdaTest {
	public static void main(String[] args) {
		BigInteger x_num = new BigInteger("34325");
		BigInteger y_num = new BigInteger("51");
		
		BigInteger result1 = CustomObjectClass.oneFunctionMethod( x_num, y_num, (x, y) -> x.multiply(y) );
		BigInteger result2 = CustomObjectClass.oneFunctionMethod( x_num, y_num, (x, y) -> x.add(y) );
		BigInteger result3 = CustomObjectClass.oneFunctionMethod( x_num, y_num, 
				(x, y) -> {
							BigInteger result = new BigInteger("1");
							for(int i=0; i<y.doubleValue(); i++){
								result = result.multiply(x);
							}
							return result; 
						} );
		BigInteger result4 = CustomObjectClass.oneFunctionMethod( x_num, y_num, (x, y) -> x.divide(y) );
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
}

class CustomObjectClass{
	public static BigInteger oneFunctionMethod(BigInteger x, BigInteger y, CustomFunctionalInterface cfi){
		return cfi.customMethod(x, y);
	}
}