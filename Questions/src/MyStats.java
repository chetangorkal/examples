
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyStats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		private java.util.concurrent.ConcurrentMap<String, Integer> tickCounts = new java.util.concurrent.ConcurrentHashMap<>();
		private volatile java.util.concurrent.ConcurrentMap<String, Double> prices = new java.util.concurrent.ConcurrentHashMap<>();
		private volatile java.util.concurrent.ConcurrentMap<String, Double> averagePrices = new java.util.concurrent.ConcurrentHashMap<>();

		// TODO: map with symbol and DS {count, price, avgPrice}.
		@Override
		public void putNewPrice(String symbol, double price) {
			synchronized (averagePrices) {
				System.out.println("prices:" + prices);
				prices.put(symbol, price);
				tickCounts.put(symbol, tickCounts.get(symbol) + 1);
				if (averagePrices.keySet().contains(symbol)) {
					double currentAveragePrice = averagePrices.get(symbol);
					averagePrices.put(symbol, (currentAveragePrice + price) / 2);
				} else {
					averagePrices.put(symbol, price);
				}
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			synchronized (averagePrices) {
				System.out.println("avg prices:" + averagePrices);
				return averagePrices.get(symbol);
			}

		}

		@Override
		public int getTickCount(String symbol) {
			synchronized (tickCounts) {
				return tickCounts.get(symbol);
			}
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 1,IBM 22.22,AAPL 33.33,IBM 44.44,AAPL 55.55,IBM 66.66

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}