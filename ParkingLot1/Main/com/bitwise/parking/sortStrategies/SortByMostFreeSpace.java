package com.bitwise.parking.sortStrategies;

import java.util.Comparator;

import com.bitwise.parking.ParkingLot;

public class SortByMostFreeSpace implements Comparator<ParkingLot> {

	@Override
	public int compare(ParkingLot o1, ParkingLot o2) {
		if(o1.FreeSlots()>o2.FreeSlots())
			return -1;
		if(o1.FreeSlots()<o2.FreeSlots())
			return 1;
		return 0;
	}
	
	

}
