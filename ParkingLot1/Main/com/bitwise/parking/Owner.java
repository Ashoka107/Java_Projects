package com.bitwise.parking;

public class Owner implements ParkingLotObserver {
	private boolean IsLotFullBoardSet;
	public Owner(){
		 IsLotFullBoardSet=false;
	}
	public boolean IsLotFullBoardSet(){
		return IsLotFullBoardSet;
	}
	public void notifyFull(){
		IsLotFullBoardSet=true;
	}
	public void notifyFree() {
		IsLotFullBoardSet=false;
	}
}
