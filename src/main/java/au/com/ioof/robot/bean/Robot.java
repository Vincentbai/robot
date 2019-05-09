package au.com.ioof.robot.bean;

import java.util.ArrayList;

import au.com.ioof.robot.util.Command;
import au.com.ioof.robot.util.Direction;

public class Robot {
	
	public Robot (int initPositionX, int initPositionY, Direction initDirection) {
		
		this.positionX = initPositionX;
		
		this.positionY = initPositionY;
		
		this.currentDirection = initDirection;
	}
	
	
	private int positionX;
	
	private int positionY;

	private Direction currentDirection;

	public void executeCommands(ArrayList<Command> cmdQueue) {
		
		for(int i=0;i<cmdQueue.size();i++){
			
			switch(cmdQueue.get(i).toString()){
			
				case "MOVE":
					this.moveTo();
					break;
				case "LEFT":
					this.turnLeft();
					break;
				case "RIGHT":
					this.turnRight();
					break;
				case "REPORT":
					this.reportCurrentPosition();
					break;
				case "STOP":
					this.stop();
					break;
			}
			
		}
		
	}
	
	public void moveTo() {
		
		switch(this.currentDirection.toString()){
		
			case "NORTH":
				if(positionY!=4) this.positionY += 1;
				break;
			case "WEST":
				if(positionX!=0) this.positionX -= 1;
				break;
			case "SOUTH":
				if(positionY!=0) this.positionY -= 1;
				break;
			case "EAST":
				if(positionX!=4) this.positionX += 1;
				break;
		}
		
	}
	
	public void turnLeft(){
		
		switch(this.currentDirection.toString()){
			
			case "NORTH":
				this.currentDirection = Direction.WEST;
				break;
			case "WEST":
				this.currentDirection = Direction.SOUTH;
				break;
			case "SOUTH":
				this.currentDirection = Direction.EAST;
				break;
			case "EAST":
				this.currentDirection = Direction.NORTH;
				break;
		}
	}
	
	public void turnRight(){
		
		switch(this.currentDirection.toString()){
			
			case "NORTH":
				this.currentDirection = Direction.EAST;
				break;
			case "EAST":
				this.currentDirection = Direction.SOUTH;
				break;
			case "SOUTH":
				this.currentDirection = Direction.WEST;
				break;
			case "WEST":
				this.currentDirection = Direction.NORTH;
				break;
		}
	}
	
	
	
	public void reportCurrentPosition() {
		
		System.out.println("The current location is (" + positionX + ", " + positionY + ") facing " + this.currentDirection.toString());
		
	}
	
	public void stop(){
		System.out.println("Bye Bye");
		System.exit(0);
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
}
