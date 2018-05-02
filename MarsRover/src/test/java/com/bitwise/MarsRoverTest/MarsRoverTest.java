package com.bitwise.MarsRoverTest;



import org.junit.Test;
import org.junit.Assert;

import com.bitwise.MarsRover.Coordinates;
import com.bitwise.MarsRover.Direction;
import com.bitwise.MarsRover.MarsRover;
import com.bitwise.MarsRover.Plateau;

public class MarsRoverTest {

	//@Test
	public void itShouldProvideCurrentLocationAsString(){
		//given
		Plateau plateua=new Plateau(5,5);
		Coordinates startingPosition=new Coordinates(3,3);
		//when
		MarsRover marsRover=new MarsRover(plateua,Direction.N,startingPosition);
		//then
		Assert.assertEquals("3 3 N", marsRover.currentLocation());
	}
	//@Test
	public void itShouldRotateLeft(){
		//given
		Plateau plateau=new Plateau(5,5);
		Coordinates startingPosition=new Coordinates(3,3);
		MarsRover marsRover=new MarsRover(plateau, Direction.S, startingPosition);
		//when
		marsRover.moveLeft();
		//then
		Assert.assertEquals("3 3 E",marsRover.currentLocation());
		} 
	//@Test
	public void itShouldMoveRight(){
		//given
		Plateau plateau=new Plateau(5,5);
		Coordinates startingPosition=new Coordinates(3,3);
		MarsRover marsRover=new MarsRover(plateau, Direction.E, startingPosition);
		//when
		marsRover.moveRight();
		//then
		Assert.assertEquals("3 3 S",marsRover.currentLocation());
	}
	//@Test
	public void itShouldMove(){
		//given
		Plateau plateau=new Plateau(5,5);
		Coordinates startingPosition=new Coordinates(3,4);
		MarsRover marsRover=new MarsRover(plateau, Direction.N, startingPosition);
		//when
		marsRover.move();
		//then
		Assert.assertEquals("3 5 N",marsRover.currentLocation());
	}
	@Test
	public void itShouldRunCommandToRotateRight(){
		//given
		Plateau plateau=new Plateau(5,5);
		Coordinates startingPosition=new Coordinates(3,4);
		MarsRover marsRover=new MarsRover(plateau, Direction.N, startingPosition);
		//when
		marsRover.run("R");
		//then
		Assert.assertEquals("3 4 E",marsRover.currentLocation());
	}
              
}