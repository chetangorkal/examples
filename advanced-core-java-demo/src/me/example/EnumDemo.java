package me.example;

import java.util.Arrays;

/*
 
 All enums implicitly extend java.lang.Enum. 
 Because a class can only extend one parent (see Declaring Classes), 
 the Java language does not support multiple inheritance of state (see Multiple Inheritance of State, Implementation, and Type), 
 and therefore an enum cannot extend anything else.
 
 *The constructor for an enum type must be package-private or private access. 
 *It automatically creates the constants that are defined at the beginning of the enum body. 
 *You cannot invoke an enum constructor yourself.
 */
public class EnumDemo {

	public static void main(String[] args) {
		Day day = Day.MONDAY;
		System.out.println(Arrays.toString(Day.values()));
		System.out.println(Day.valueOf("MONDAY"));
		System.out.println(day.getClass());
	}

}
