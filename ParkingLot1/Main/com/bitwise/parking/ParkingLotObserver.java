package com.bitwise.parking;

public interface ParkingLotObserver {
	
	boolean IsLotFullBoardSet();
		void notifyFull();
		void notifyFree();
}
