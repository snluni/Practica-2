package es.urjc.code.daw.library.lineBreaker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestLineBreaker {

	@Test
	void lineExample1() {
		
		assertEquals("", LineBreaker.breakText("",2));
	}

	@Test
	void lineExample2() {
		assertEquals("test", LineBreaker.breakText("test", 4));
	}

	@Test
	void lineExample3() {
		assertEquals("test", LineBreaker.breakText("test", 5));
	}

	@Test
	void lineExample4() {
		assertEquals("test\ntest", LineBreaker.breakText("test test", 4));
	}

	@Test
	void lineExample5() {
		assertEquals("test\ntest", LineBreaker.breakText("test test", 5));
	}

	@Test
	void lineExample6() {
		assertEquals("test\ntest", LineBreaker.breakText("test test", 6));
	}

	@Test
	void lineExample7() {
		assertEquals("test test\ntest test", LineBreaker.breakText("test test test test", 9));
	}

	@Test
	void lineExample8() {
		assertEquals("test\ntest", LineBreaker.breakText("test  test", 4));
	}

	@Test
	void lineExample9() {
		assertEquals("test\ntest", LineBreaker.breakText("test   test", 6));
	}

	@Test
	void lineExample10() {
		assertEquals("test-\ntest", LineBreaker.breakText("testtest", 5));
	}

	@Test
	void lineExample11() {
		assertEquals("test-\ntest-\ntest", LineBreaker.breakText("testtesttest", 5));
	}

	@Test
	void lineExample12() {
		assertEquals("te-\nst\nte-\nst", LineBreaker.breakText("test test", 3));
	}

	@Test
	void lineExample13() {
		assertEquals("test\n12345-\n67\ntest", LineBreaker.breakText("test 1234567 test", 6));
	}

	@Test
	void lineExample14() {
		assertEquals("12-\n34-\n56-\n789", LineBreaker.breakText("123456789", 3));
	}
}
