package me.example.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import me.example.java8.MethodReference;

public class Practise {
	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		//Predicate
		performAction(intList, n -> n>2);
		
		//Optional class
		Optional<Integer> a = Optional.of(1);
		perfromOptionalAction(a);
		
		//default methods in interface;
		AB ab = new Practise().new AB(); ab.mAB();
		
		 MyOp myOp1 = (int c, int d) -> c+d;
		 System.out.println(performAdd(1,2,myOp1));
		
	}

	private static int performAdd(int i, int j, MyOp myOp1) {
		return myOp1.myOp(i, j);
	}

	private static void perfromOptionalAction(Optional<Integer> a) {
		a.isPresent();
		
	}

	private static void performAction(List<Integer> intList, Predicate<Integer> predicate) {
		for (Integer n : intList)
		if (predicate.test(n))
			System.out.println(n);
	}

	interface iA{
		default void mA(){
			System.out.println("default mA");
		}
	}interface iB{
		default void mB(){
			System.out.println("default mB mA");
		}
	}
	class AB implements iA, iB{
		void mAB(){
			iA.super.mA();
			iB.super.mB();
			System.out.println("mAB");
		}
	}
	
	interface MyOp {
		int myOp (int a, int b);
	}
}
