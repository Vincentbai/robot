package au.com.ioof.robot;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.ioof.robot.bean.Robot;
import au.com.ioof.robot.bean.Table;
import au.com.ioof.robot.exception.CommandWrongException;
import au.com.ioof.robot.exception.DirectionWrongException;
import au.com.ioof.robot.util.Command;
import au.com.ioof.robot.util.CommandFactory;
import au.com.ioof.robot.util.Direction;
import au.com.ioof.robot.util.DirectionFactory;

public class App {
	
    private static Scanner scanner;

	public static void main( String[] args ){
		
		System.out.println( "******************************WELCOME******************************");
		System.out.println("You can use PLACE, MOVE, LEFT, RIGHT, STOP to control the table robot!");
		System.out.println( "******************************WELCOME******************************");
    	
    	Robot robot = null;
    	Pattern patternPlaceCmd = Pattern.compile("^PLACE\\s(\\d),(\\d),(NORTH|SOUTH|EAST|WEST)",Pattern.CASE_INSENSITIVE);
    	Pattern patternOtherCmd = Pattern.compile("MOVE|LEFT|RIGHT|REPORT|STOP");
    	
    	while(true) {
    		try {
    			
	    		System.out.println("Please enter your command: ");
	    		scanner = new Scanner(System.in);
	    		String commandString = scanner.nextLine().toUpperCase();
	    		
	    		Matcher matcherPlaceCmd = patternPlaceCmd.matcher(commandString);
	    		
	    		//if the commandString starts with PLACE
	    		if(matcherPlaceCmd.find()){
	    			
	    			int initX = Integer.parseInt(matcherPlaceCmd.group(1));
	    			int initY = Integer.parseInt(matcherPlaceCmd.group(2));
	    			Direction initDirction = new DirectionFactory().getDirection(matcherPlaceCmd.group(3));
	    			
	    			if(initX>Table.LENGTH || initY>Table.WIDTH){
	    				System.out.println("the initial position should between [0,4]");
	    				continue;
	    			}
					
	    			robot = new Robot(initX, initY, initDirction);
	    			
	    			commandString = commandString.substring(matcherPlaceCmd.end()).trim(); 
	    			
	    			if(commandString.length()==0){
	    				continue;
	    			}
	    		}
	    	
	    		Matcher matcherOtherCmd = patternOtherCmd.matcher(commandString);
	    		
	    		if(matcherOtherCmd.matches() && robot!=null){
	    			
	    			String[] cmdStringArray = commandString.split(" ");
	    			
	    			ArrayList<Command> cmdQueue = new CommandFactory().getCommandArray(cmdStringArray);
	    			
	    			robot.executeCommands(cmdQueue);
	    			
	    		}else{
	    			
	    			if(robot==null){
	    				System.out.println("Please use PLACE command to place a robot first!");
	    			}else{
	    				System.out.println("Wrong command! Please enter again");
	    			}
	    		}
	    		
	    	}catch(CommandWrongException e){
	    		
	    		System.out.println("Wrong command! Please enter again");
	    		
	    	}catch(DirectionWrongException e){
	    		
	    		System.out.println("Wrong Dircetion! Please enter again");
	    		
	    	}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
}
