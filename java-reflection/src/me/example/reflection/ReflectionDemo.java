package me.example.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

class Simple {
	void m1() {
		System.out.println("Hello Java");
	}

}

public class ReflectionDemo {
	public static void main(String args[]) throws ClassNotFoundException {
		Class c = Class.forName("me.example.reflection.Simple");
		System.out.println(c.getName());

		Simple s = new Simple();
		c = s.getClass();
		System.out.println(c.getName());

		Class c2 = ReflectionDemo.class;
		System.out.println(c2.getName() + "\n----------------------");

		Method[] methods = c.getDeclaredMethods();
		System.out.println(Arrays.toString(methods));
		System.out.println(methods[0].getName());

		new ReflectionDemo().demoNewInstance();
	}

	private void demoNewInstance() {
		try {
			Class c = Class.forName("me.example.reflection.Simple");
			Simple s = (Simple) c.newInstance();
			s.m1();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}