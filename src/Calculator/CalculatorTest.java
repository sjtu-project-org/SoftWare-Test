package Calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	private Calculator cal;

	@Before
	public void setUp() throws Exception {
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		assertEquals(cal.drive("1+2").run(), "3.0");
		assertEquals(cal.drive("(1+3)+4").run(), "8.0");
	}
	
}
