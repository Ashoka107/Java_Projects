package com.bitwise.parking.sortStrategies;

import java.util.Comparator;

import com.bitwise.parking.ParkingLot;

public class SortByMostCapacity implements  Comparator<ParkingLot> {

	@Override
	public int compare(ParkingLot o1, ParkingLot o2) {
		if(o1.capacity()>o2.capacity())
			return -1;
		if(o1.capacity()<o2.capacity())
			return 1;
		return 0;
	}
	
	

}
