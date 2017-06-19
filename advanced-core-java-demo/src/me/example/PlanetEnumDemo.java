package me.example;

public class PlanetEnumDemo {
	public static void main(String[] args) {
		// Give the weight on Earth
		double earthWeight = Double.parseDouble("68.5");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
	}

}
