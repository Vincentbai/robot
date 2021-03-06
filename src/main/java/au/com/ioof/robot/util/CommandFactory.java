package au.com.ioof.robot.util;

import java.util.ArrayList;

import au.com.ioof.robot.exception.CommandWrongException;

public class CommandFactory {
	
	public ArrayList<Command> getCommandArray(String[] commandStringArray) throws CommandWrongException {
		
		ArrayList<Command> cmdQueue = new ArrayList<Command>();
		
		for(String commandString: commandStringArray){
			cmdQueue.add(this.createCommand(commandString));
		}
		
		return cmdQueue;
		
	}
	
	public Command createCommand(String commandString) throws CommandWrongException{
		
		switch(commandString){
			case "MOVE": 
				return Command.MOVE;
			case "LEFT":
				return Command.LEFT;
			case "RIGHT": 
				return Command.RIGHT;
			case "REPORT": 
				return Command.REPORT;
			case "STOP":
				return Command.STOP;
			default:
				throw new CommandWrongException("Wrong Command!!!");
		}
	}

}
