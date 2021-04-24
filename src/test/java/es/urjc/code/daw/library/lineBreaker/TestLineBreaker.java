package es.urjc.code.daw.library.lineBreaker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLineBreaker {
	private LineBreaker lineBreaker;

	@BeforeEach
	void setUp() {
		lineBreaker = new LineBreaker();
	}

	@Test
	void lineExample1() {
		
		assertEquals("", lineBreaker.breakText("",2));
	}

	@Test
	void lineExample2() {
		assertEquals("test", lineBreaker.breakText("test", 4));
	}

	@Test
	void lineExample3() {
		assertEquals("test", lineBreaker.breakText("test", 5));
	}

	@Test
	void lineExample4() {
		assertEquals(
			"test\ntest",
			lineBreaker.breakText("test test", 4)
		);
	}

	@Test
	void lineExample5() {
		assertEquals(
			"test\ntest",
			lineBreaker.breakText("test test", 5)
		);
	}

	@Test
	void lineExample6() {
		assertEquals(
			"test\ntest",
			lineBreaker.breakText("test test", 6)
		);
	}

	@Test
	void lineExample7() {
		assertEquals(
			"test test\ntest test",
			lineBreaker.breakText("test test test test", 9)
		);
	}

	@Test
	void lineExample8() {
		assertEquals(
			"test\ntest",
			lineBreaker.breakText("test  test", 4)
		);
	}
}
