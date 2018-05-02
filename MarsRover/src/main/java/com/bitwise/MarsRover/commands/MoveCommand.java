package com.bitwise.MarsRover.commands;

import com.bitwise.MarsRover.MarsRover;

public class MoveCommand implements ICommand {
public void execute(final MarsRover marsRover){
	marsRover.move();
}
}
