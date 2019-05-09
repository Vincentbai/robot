package au.com.ioof.robot;

import org.junit.Test;

import au.com.ioof.robot.util.DirectionFactory;
import junit.framework.TestCase;

public class DirectionFactoryTest extends TestCase {

	@Test
	public void testGetDirection() throws Exception {
		
		DirectionFactory df = new DirectionFactory();
		String s = "NORTH";
		assertEquals("NORTH", df.getDirection(s).toString());
		
	}

}
