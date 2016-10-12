package net.runnerdave;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by davidajimenez on 11/10/2016.
 */
public class SumFct {
	private static Map<Long, Long> mapLong = new HashMap<>();
	private static Map<BigInteger, BigInteger> mapBigInt = new HashMap<>();

	public static BigInteger perimeter(BigInteger n) {
		int numberOfSquares = n.intValue();
		long value = 0;
		for (long i = 1; i <= numberOfSquares + 1; i++) {
			value = value + fibonacci(i);
		}

		return BigInteger.valueOf(value * 4);
	}

	public static BigInteger perimeterBigInt(BigInteger n) {
		BigInteger value = new BigInteger("0");
		BigInteger counter = BigInteger.ONE;
		while (counter.subtract(BigInteger.ONE).compareTo(n) < 1) {

			value = value.add(fibonacciBigInt(counter));
			counter = counter.add(BigInteger.ONE);
		}
		return value.multiply(new BigInteger("4"));
	}

	public static BigInteger fibonacciBigInt(BigInteger n) {
		if (n.intValue() <= 1)
			return n;
		else if (mapBigInt.containsKey(n)) {
			return mapBigInt.get(n);
		} else {
			BigInteger minusOne = fibonacciBigInt(n.subtract(BigInteger.ONE));
			BigInteger minusTwo = fibonacciBigInt(n.subtract(new BigInteger("2")));
			BigInteger fibo = minusOne.add(minusTwo);
			mapBigInt.put(n, fibo);
			return fibo;
		}
	}

	public static long fibonacci(long n) {
		if (n <= 1)
			return n;
		else if (mapLong.containsKey(n)) {
			return mapLong.get(n);
		} else {
			long fibo = fibonacci(n - 1) + fibonacci(n - 2);
			mapLong.put(n, fibo);
			return fibo;
		}
	}

	public static BigInteger perimeterGreat(BigInteger n) {

		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;

		for (int i = 0; i <= n.intValue(); i++) {
			a = b;
			b = c;
			c = a.add(b);
			sum = sum.add(a);
		}

		return sum.multiply(BigInteger.valueOf(4));
	}

	public static BigInteger perimeterCool(BigInteger n) {
		return Stream.generate(new FibonacciGenerator()::next).limit(n.longValueExact() + 1).reduce(BigInteger::add)
				.get().multiply(BigInteger.valueOf(4));
	}

	private static class FibonacciGenerator {
		private BigInteger nMinusTwo = BigInteger.ONE;
		private BigInteger nMinusOne = BigInteger.ZERO;

		public BigInteger next() {
			final BigInteger n = nMinusTwo.add(nMinusOne);
			nMinusTwo = nMinusOne;
			nMinusOne = n;

			return n;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		for (int i = 1; i <= n; i++)
			System.out.println(i + ": " + fibonacciBigInt(BigInteger.valueOf(i)));
		;
	}
}
