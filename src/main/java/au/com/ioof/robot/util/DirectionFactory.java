package au.com.ioof.robot.util;

import au.com.ioof.robot.exception.DirectionWrongException;

public class DirectionFactory {
	
	public Direction getDirection(String directionString) throws Exception{
		
		switch (directionString){
		case "NORTH":
			return Direction.NORTH;
		case "SOUTH":
			return Direction.SOUTH;
		case "EAST":
			return Direction.EAST;
		case "WEST":
			return Direction.WEST;
		default:
			throw new DirectionWrongException("wrong Direction");
		}
			
		
	}

}
