package com.bitwise.MarsRover;

public class Coordinates {
	private int xCoordinate;
	private int yCoordinate;

	public Coordinates(final int xCoordinate,final int yCoordinate){
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}
	public Coordinates newCoordinatesFor(final int xCoordinateStepValue,final int yCoordinateStepValue){
		
		return new Coordinates(this.xCoordinate+xCoordinateStepValue,this.yCoordinate+yCoordinateStepValue);
		
	}   
	@Override
	public String toString(){
		StringBuffer coordinates=new StringBuffer();
		coordinates.append(xCoordinate);
		coordinates.append(" ");
		coordinates.append(yCoordinate);
		return coordinates.toString();
	}
	public Coordinates newCoordinatesForStepSize(final int xCoordinateStepValue,final int yCoordinateStepValue) {
		return new Coordinates((this.xCoordinate+xCoordinateStepValue),(this.yCoordinate+yCoordinateStepValue));
	}
	public boolean hasWithinBounds(Coordinates coordinates) {
		return coordinates.xCoordinate<=this.xCoordinate && coordinates.yCoordinate<=this.yCoordinate;
	}
	public boolean hasOutsideBounds(Coordinates coordinate){
		return isXCoordinateInOutsideBounds(coordinate.xCoordinate)&& isYCoordinateInOutsideBounds(coordinate.yCoordinate);
	}
	private boolean isYCoordinateInOutsideBounds(final int yCoordinate) {
		return this.yCoordinate<=yCoordinate;
	}
	private boolean isXCoordinateInOutsideBounds(final int xCoordinate) {
		return this.xCoordinate<=xCoordinate;
	}
}
