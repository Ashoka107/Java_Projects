package com.bitwise.MarsRover;

public class Plateau {
	private Coordinates topRightCoordinates=new Coordinates(0,0);
	private Coordinates bottomLeftCoordinates=new Coordinates(0,0); 

	public Plateau(final int topRightXCoordinate,final int topRightYCoordinate){
	 this.topRightCoordinates=this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate,topRightYCoordinate);
 }

public boolean hasWithinBounds(Coordinates coordinates) {
	return topRightCoordinates.hasWithinBounds(coordinates)&& bottomLeftCoordinates.hasOutsideBounds(coordinates);
}
} 
