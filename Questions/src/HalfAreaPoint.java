import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class HalfAreaPoint {
	public double findHalfAreaPoint(Curve curve, double p) {
		double area = curve.areaUnderCurve(p);
		double h = BigDecimal.valueOf(p).setScale(3, RoundingMode.HALF_UP).doubleValue();
		while (h > 0 && curve.areaUnderCurve(h) != area / 2) {
			h--;
		}
		return h;
	}

	// DO NOT MODIFY CODE BELOW THIS LINE
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Curve c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "EXP":
				c = new Exp();
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			HalfAreaPoint t = new HalfAreaPoint();
			double p = 10.0d;
			double h = t.findHalfAreaPoint(c, p);
			System.out.println(Math.round(h * 1000d));
		}

		scanner.close();
	}
}

interface Curve {
	double areaUnderCurve(double x);
}

class Line implements Curve {
	private double m;
	private double c;

	public Line(double m, double c) {
		this.m = m;
		this.c = c;
	}

	@Override
	public double areaUnderCurve(double x) {
		return m * x + c;
	}
}

class Exp implements Curve {
	@Override
	public double areaUnderCurve(double x) {
		return Math.exp(x);
	}
}

class Power implements Curve {
	private double power;

	public Power(double power) {
		this.power = power;
	}

	@Override
	public double areaUnderCurve(double x) {
		return Math.pow(x, power);
	}
}