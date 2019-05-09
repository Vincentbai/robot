package au.com.ioof.robot;

import java.util.ArrayList;

import org.junit.Test;

import au.com.ioof.robot.bean.Robot;
import au.com.ioof.robot.util.Command;
import au.com.ioof.robot.util.Direction;
import junit.framework.TestCase;

public class RobotTest extends TestCase {

	@Test
	public void testExecuteCommands() {
		
		Robot robot = new Robot(2,2,Direction.EAST);
		
		ArrayList<Command> cmdQueue = new ArrayList<Command>();
		cmdQueue.add(Command.MOVE);
		cmdQueue.add(Command.LEFT);
		cmdQueue.add(Command.MOVE);
		cmdQueue.add(Command.RIGHT);
		robot.executeCommands(cmdQueue);
		
		assertEquals(3, robot.getPositionX());
		assertEquals(3, robot.getPositionY());
		assertEquals("EAST", robot.getCurrentDirection().toString());
	}

}
