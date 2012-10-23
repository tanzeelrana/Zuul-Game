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
    private CommandWords commandWords;

    /**
     * Creates a new empty CommandStack
     */
	public CommandStack()
	{
		cStack = new Stack<Command>();
		commandWords = new CommandWords();
	}

	/**
	 * Add a command to the stack. Undo and Redo commands are ingnored
	 * @param c
	 */
	public void add(Command c)
	{
		//Do not add undo or redo commands to a command stack
		if(commandWords.isReversible(c.getCommandWord())) {
			cStack.add(c);
		}


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

		return commandWords.getReverse(old);
	}

	public void empty()
	{
		cStack.empty();
	}
}