package com.bitwise.MarsRover.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bitwise.MarsRover.commands.ICommand;
import com.bitwise.MarsRover.commands.MoveCommand;
import com.bitwise.MarsRover.commands.RotateLeftCommand;
import com.bitwise.MarsRover.commands.RotateRightCommand;

public class StringCommandParser {

	public static final String BY_EACH_CHARACTER="";
	public static final int START_INDEX=1;
	private String commandString;
	private static Map<String,ICommand> stringToCommandMap= new HashMap<String,ICommand> () {{
		put("R",new RotateRightCommand());
	    put("L",new RotateLeftCommand());
		put("M",new MoveCommand());
	}};
	
	public StringCommandParser(final String commandString) {
	this.commandString=commandString;	
	}
	public List<ICommand> toCommand(){
	if(isNullOrEmpty(commandString))return new ArrayList<ICommand>();	
	return buildCommandsList(commandString);			
	}
	private List<ICommand> buildCommandsList(final String commandString) {
		List<ICommand> commands=new ArrayList<>();
		for(String commandsCharacter:commandsCharacterFrom(commandString)){
			ICommand mappedCommand=lookUpEquivalentCommand(commandsCharacter.toUpperCase());
			commands.add(mappedCommand);
		}
		return commands;
	}
	private ICommand lookUpEquivalentCommand(final String commandsString) {
		return stringToCommandMap.get(commandsString);
	}
	private String[] commandsCharacterFrom(final String commandString) {
		return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER),START_INDEX,commandString.length()+1);
	}
	private boolean isNullOrEmpty(final String commandString) {
		return commandString==null || commandString.trim().length()==0;
	}

}
