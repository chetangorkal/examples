package me.example.deck;

import java.util.Scanner;

public class DeckClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Suit input = Suit.valueOf(sc.next());
		System.out.println(input);
		sc.close();

	}

}
