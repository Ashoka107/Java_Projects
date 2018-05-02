package com.bitwise.MarsRover;

import java.util.List;

import com.bitwise.MarsRover.commands.ICommand;
import com.bitwise.MarsRover.parser.StringCommandParser;

public class MarsRover {
	private Coordinates currentCoordinates;
	private Direction currentDirection;
	private Plateau plateau;

	public MarsRover(final Plateau plateau,final Direction direction,final Coordinates coordinates){
		this.plateau=plateau;
		this.currentDirection=direction;
		this.currentCoordinates=coordinates;
	}
	public String currentLocation(){
		return (currentCoordinates.toString() + " " + currentDirection.toString());
	}
	public void moveLeft() {
		currentDirection=currentDirection.left();
	}
	public void moveRight() {
		currentDirection=currentDirection.right();
	}
	public void move() {
		Coordinates positionAfterMove=currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeOnXAxis(),currentDirection.stepSizeOnYAxis());
		
		if(plateau.hasWithinBounds(positionAfterMove))
			currentCoordinates=currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeOnXAxis(),currentDirection.stepSizeOnYAxis());
	}
	public void run(String commandString) {
      		List<ICommand> roverCommand=new StringCommandParser(commandString).toCommand();
      		for(ICommand command:roverCommand)
      			command.execute(this);
	}
	public void turnRight() {
		currentDirection=currentDirection.right();
	}
	public void turnLeft() {
		currentDirection=currentDirection.left();
	}

}
