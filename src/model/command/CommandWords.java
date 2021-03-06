package model.command;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognise commands as they are typed in.
 * 
 */

public class CommandWords {
	// a constant array that holds all valid command words
	private static final String[] validCommands = { "quit", "help", "undo",
			"redo", "straight", "load", "save", "new" };

	private final static HashMap<String, String> reversibleCommands = new HashMap<String, String>();
	static {
		reversibleCommands.put("pick", "drop");
		reversibleCommands.put("drop", "pick");
		reversibleCommands.put("attack", "heal");
		reversibleCommands.put("heal", "attack");
		reversibleCommands.put("go", "go");
		reversibleCommands.put("turn", "turn");
		reversibleCommands.put("eat", "unEat");
    	reversibleCommands.put("unEat", "eat");
	}

	public final static HashMap<String, String> reverseSecondWord = new HashMap<String, String>();
	static {
		reverseSecondWord.put("north", "south");
		reverseSecondWord.put("south", "north");
		reverseSecondWord.put("east", "west");
		reverseSecondWord.put("west", "east");
		reverseSecondWord.put("left", "right");
		reverseSecondWord.put("right", "left");
	}

	/**
	 * Constructor - initialise the command words.
	 */
	public CommandWords() {
		// nothing to do at the moment...
	}

	/**
	 * Check whether a given String is a valid command word.
	 * 
	 * @return true if a given string is a valid command, false if it isn't.
	 */
	public boolean isCommand(String aString) {
		// Check to see if the string is in the reversible commands
		if (reversibleCommands.containsKey(aString)) {
			return true;
		}

		// Check to see if the string is in the array of other commands
		for (int i = 0; i < validCommands.length; i++) {
			if (validCommands[i].equals(aString))
				return true;
		}
		// if we get here, the string was not found in the commands
		return false;
	}

	/**
	 * returns string of all valid commands
	 */
	public String getCommandList() {
		String commandList = "";
		for (String command : validCommands) {
			commandList += (command + " ");
		}
		String[] x = (String[]) reversibleCommands.values().toArray(
				new String[0]);
		for (String command : x) {
			commandList += (command + " ");
		}
		return commandList;
	}

	public boolean isReversible(String s) {
		return reversibleCommands.containsKey(s);
	}

	public Command getReverse(Command c) {
		// If command is non-reversible, return a null Command
		if (!isReversible(c.getCommandWord()))
			return null;

		// If first words reverse is equal to itself (such as go)
		// Return a command with original first word and reverse second word
		if (c.getCommandWord().equals(
				reversibleCommands.get(c.getCommandWord()))) {
			return new Command(c.getCommandWord(), reverseSecondWord.get(c
					.getSecondWord()));
		}

		// Return a command with reversed first word and original second word
		return new Command(reversibleCommands.get(c.getCommandWord()),
				c.getSecondWord());
	}

}