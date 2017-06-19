
public class A {

	private void m1(Float f) {
		System.out.println("float");
	}

	private void m1(Double d) {
		System.out.println("d");
	}

	public static void main(String[] args) {
		A a = new A();
		a.m1(0.1f);
		a.m1(0.1);
	}
}
