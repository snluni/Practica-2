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
		
		assertEquals(lineBreaker.breakText("",2), "");
	}

	@Test
	void lineExample2() {
		assertEquals(lineBreaker.breakText("test", 4), "test");
	}

	@Test
	void lineExample3() {
		assertEquals(lineBreaker.breakText("test", 5), "test");
	}

	@Test
	void lineExample4() {
		assertEquals(lineBreaker.breakText("test test", 4), "test\ntest");
	}
	
	@Test
	void lineExample5() {
		assertEquals(lineBreaker.breakText("test test", 5), "test\ntest");
	}

	@Test
	void lineExample6() {
		assertEquals(lineBreaker.breakText("test test", 6), "test\ntest");
	}
}
