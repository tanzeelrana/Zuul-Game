import java.util.*;

/**
 * This class holds a stack of commands that were entered by the user. This class is used
 * with the Undo and Redo commands, and provides functionality for reversing commands
 * @author Ethan
 *
 */
public class CommandStack {
	//A stack of all commands said before
	private Stack<Command> cStack;
	
	public final static String GO = "go";
	public final static String UNDO = "undo";
	public final static String REDO = "redo";
	

	private static HashMap<String, String> reverseCommand;
    public final static HashMap<String, String> reverseDirection = new HashMap<String, String>();
    static {
    	reverseDirection.put("north", "south");
    	reverseDirection.put("south", "north");
    	reverseDirection.put("east", "west");
    	reverseDirection.put("west", "east");
	}
    private CommandWords commandWords;
	
    /**
     * Creates a new empty CommandStack
     */
	public CommandStack()
	{
		cStack = new Stack<Command>();
		commandWords = new CommandWords();
		reverseCommand = commandWords.getReversibleCommands();
	}

	/**
	 * Add a command to the stack. Undo and Redo commands are ingnored
	 * @param c
	 */
	public void add(Command c)
	{
		//Do not add undo or redo commands to a command stack
		if(c.getCommandWord().equals(UNDO)||c.getCommandWord().equals(REDO)) {
			return;
		}
		
		cStack.add(c);
	}
	
	/**
	 * Pop a command from the stack, and reverse the command
	 * @return
	 */
	public Command pop()
	{
		//If the stack is empty, return a null pointer
		if(cStack.isEmpty())return null;
		
		//Last command taken off the stack
		Command old  = cStack.pop();
		
		//If word is GO, reverse direction
		if(old.getCommandWord().equals(GO))
		{
			//return command with go and opposite direction of last go in commandStack
			return new Command(old.getCommandWord(), reverseDirection.get(old.getSecondWord()));
		}
		//return reverse of first word and same second word of last command in commandStack
		return new Command(reverseCommand.get(old.getCommandWord()), old.getSecondWord());
	}
}
