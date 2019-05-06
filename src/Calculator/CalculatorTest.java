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
	public void testCalConstructor() {
		Calculator cal2 = new Calculator("1+1");
	}
	@Test
	public void testAdd() {
		assertEquals(cal.drive("1+2").run(), "3.0");
		assertEquals(cal.drive("(1+3)+4").run(), "8.0");
		assertEquals(cal.drive("2pow2+2").run(), "error");
	}
	
	@Test
	public void testDIYLIB() {
		assertEquals(cal.drive("1+2").run(), "3.0");
		assertEquals(cal.drive("1-2").run(), "-1.0");
		assertEquals(cal.drive("1*2").run(), "2.0");
		assertEquals(cal.drive("1/2").run(), "0.5");
	}

	@Test
	public void testInitCover() {
		assertEquals(cal.drive("1+2").run(), "3.0");
		assertEquals(cal.drive("cos(0)").run(), "1.0");
		assertEquals(cal.drive("1+(2[+0)").run(), "error");
	}
	
	@Test
	public void testInitLoop() {
		// keep outer loop 2~4, test inner loop times
		// due to inner loop for method para, times <= 2
		assertEquals(cal.drive("()").run(), "error");   	// inner 0, fix bug
		assertEquals(cal.drive("cos(0)").run(), "1.0");		// inner 1
		assertEquals(cal.drive("(2*2)").run(), "4.0");  	// inner 2
		// keep inner loop 0~1, test outer loop times
		assertEquals(cal.drive("").run(), "error"); 		// outer 0
		assertEquals(cal.drive("1").run(), "1");			// outer 1
		assertEquals(cal.drive("cos(1)*").run(), "error"); 	// outer 2
		assertEquals(cal.drive("2+cos(0)").run(), "3.0");	// outer 3
		assertEquals(cal.drive("0+cos(0)*2-3/6").run(), "1.5");	// outer N
	}
	@Test
	public void test_doit() {
		assertEquals(cal.drive("1").run(), "1");
		assertEquals(cal.drive("1+2").run(), "3.0");
		assertEquals(cal.drive("cos(0)").run(), "1.0");
		assertEquals(cal.drive("cos(5.0)").run(), "error");
		assertEquals(cal.drive("cos(0)+1").run(), "2.0");
		assertEquals(cal.drive("5+").run(), "error");
		assertEquals(cal.drive("[1+34").run(), "error");
		assertEquals(cal.drive("a+4").run(), "error");
		assertEquals(cal.drive("a1+4").run(), "error");
	}
	@Test
	public void testPrepare() {
		assertEquals(cal.drive("()").run(), "error");//inner 0 outer 0
		assertEquals(cal.drive("1").run(), "1");//inner 1 outer 1 
		assertEquals(cal.drive("123").run(), "123");//inner 3 outer 1 
		assertEquals(cal.drive("a+").run(), "error");//inner 1 outer 2
		assertEquals(cal.drive("abc+").run(), "error");//inner 3 outer 2
		assertEquals(cal.drive("cos(0)").run(), "1.0");//inner 3 outer 3
		assertEquals(cal.drive("[{(c+").run(), "error");//inner 4 outer 5 
		assertEquals(cal.drive("0+cos(0)*2-3/6").run(), "1.5");//inner M outer N 
		
	}
}
