package other;

import java.lang.reflect.Array;
import java.util.Stack;

public class Palindromes {

	public boolean isPalindrome(String word) {

		Stack<Character> stack = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		boolean Space = false;
		boolean Comma = false;
		boolean Exclamation = false;
		int length = word.length();
		String clearedword;
		word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			Space = false;
			Comma = false;
			Exclamation = false;
			Character a = word.charAt(i);
			if (a.equals(' ')) {
				length -= 1;
				Space = true;
			}
			if (a.equals(',')) {
				length -= 1;
				Comma = true;
			}
			if (a.equals('!')) {
				length -= 1;
				Exclamation = true;
			}
			if (Exclamation == false && Comma == false && Space == false) {
				stack.push(word.charAt(i));
			} else {

			}
		}
		String reverse = "";
		String original = "";
		for (int i = 0; i < length; i++) {
			reverse += stack.pop();

		}
		for (int i = 0; i < length; i++) {
			stack.push(reverse.charAt(i));
		}
		for (int i = 0; i < length; i++) {
			original += stack.pop();
		}

		String newreverse = reverse.toLowerCase();
		String newword = original.toLowerCase();
		System.out.println(newreverse);
		System.out.println(newword);
		if (newreverse.equals(newword)) {
			return true;
		}

		else {
			return false;
		}
	}
}
