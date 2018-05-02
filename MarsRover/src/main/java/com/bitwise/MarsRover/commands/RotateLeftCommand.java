package com.bitwise.MarsRover.commands;

import com.bitwise.MarsRover.MarsRover;

public class RotateLeftCommand implements ICommand {
public void execute(final MarsRover marsRover){
	marsRover.turnLeft();
}
}
