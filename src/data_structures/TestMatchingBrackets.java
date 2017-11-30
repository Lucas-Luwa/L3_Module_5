package data_structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	Stack<String> s = new Stack<String>();

	private boolean doBracketsMatch(String b) {
		Boolean x = false;
		for (int i = 0; i < b.length(); i++) {

			if (b.charAt(i) == '{') {
				s.push("{");

			}
			if (b.charAt(i) == '}') {
				s.pop();

			}
		}
		System.out.println(s);
		if (s.isEmpty()) {
			x = true;
		}

		return x;
	}
}