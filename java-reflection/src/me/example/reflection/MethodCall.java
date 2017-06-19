package me.example.reflection;

import java.lang.reflect.Method;

class A {
	private void message() {
		System.out.println("hello java");
	}

	private void cube(int n, int a) {
		System.out.println(n * n * n);
		System.out.println(a);
	}
}

public class MethodCall {
	public static void main(String[] args) throws Exception {

		Class c = Class.forName("me.example.reflection.A");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("message", null);
		m.setAccessible(true);
		m.invoke(o, null);

		m = c.getDeclaredMethod("cube", new Class[] { int.class, int.class });
		m.setAccessible(true);
		m.invoke(o, 4, 2);
	}

}