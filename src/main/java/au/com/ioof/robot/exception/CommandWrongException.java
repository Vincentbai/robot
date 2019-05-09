package au.com.ioof.robot.exception;

public class CommandWrongException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CommandWrongException(String msg){
		super(msg);
	}

}
