package me.example.generics;

public class TestGenerics4 {

	public static <E> void printArray(E[] elements) {
		for (E e : elements) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Character[] charArray = { 'J', 'A', 'V', 'A', 'T', 'P', 'O', 'I', 'N', 'T' };

		System.out.println("Printing Integer Array");
		printArray(intArray);

		System.out.println("Printing Character Array");
		printArray(charArray);
	}
}