
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BB {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		class StockData {
			int tickCount;
			double price;
			double averagePrice;
			List<Double> historyPrices = new ArrayList<>();
		}

		private java.util.concurrent.ConcurrentMap<String, StockData> stocks = new java.util.concurrent.ConcurrentHashMap<>();

		@Override
		public void putNewPrice(String symbol, double price) {
			synchronized (stocks) {

				if (stocks.keySet().contains(symbol)) {
					StockData existingData = stocks.get(symbol);
					existingData.price = price;
					existingData.historyPrices.add(price);

					DoubleSummaryStatistics stats = existingData.historyPrices.stream().mapToDouble((x) -> x)
							.summaryStatistics();
					existingData.averagePrice = stats.getAverage();
					existingData.tickCount++;
				} else {
					StockData data = new StockData();
					data.price = price;
					data.historyPrices.add(price);
					data.averagePrice = price;
					data.tickCount = 1;
					stocks.put(symbol, data);
				}
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			synchronized (stocks) {
				return ((stocks.get(symbol) == null) ? 0 : stocks.get(symbol).averagePrice);
			}
		}

		@Override
		public int getTickCount(String symbol) {
			synchronized (stocks) {
				return ((stocks.get(symbol) == null) ? 0 : stocks.get(symbol).tickCount);
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

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}