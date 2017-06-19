package me.example.generics;

/*
	T - Type
	E - Element
	K - Key
	N - Number
	V - Value
 */
class MyGen<T> {
	T obj;

	void set(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}

public class GenericClassDemo {
	public static void main(String[] args) {
		MyGen<Integer> m = new MyGen<Integer>();
		m.set(2);
		// m.add("vivek");//Compile time error
		System.out.println(m.get());

		MyGen<String> mStr = new MyGen<>();
		mStr.set("s1");
		// mStr.add(1);
		System.out.println(mStr.get());
	}
}