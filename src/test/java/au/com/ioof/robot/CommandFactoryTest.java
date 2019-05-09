package au.com.ioof.robot;

import org.junit.Test;

import au.com.ioof.robot.exception.CommandWrongException;
import au.com.ioof.robot.util.CommandFactory;
import junit.framework.TestCase;

public class CommandFactoryTest extends TestCase {
	
	CommandFactory cf = null;
	
	protected void setUp() throws Exception {
		 cf = new CommandFactory();
	}

	@Test
	public void testGetCommandArray() throws CommandWrongException {
		
		
		
		String[] testString = {"MOVE","LEFT","RIGHT","REPORT","STOP"};
	    
		assertEquals("[MOVE, LEFT, RIGHT, REPORT, STOP]", cf.getCommandArray(testString).toString());
		
	}
	
	@Test
	public void testCreateCommand() throws CommandWrongException{
		
		String s = "STOP";
		assertEquals("STOP", cf.createCommand(s).toString());
		
	}
	
	

}
