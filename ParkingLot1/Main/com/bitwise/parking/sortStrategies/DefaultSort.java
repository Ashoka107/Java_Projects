package com.bitwise.parking.sortStrategies;

import java.util.Comparator;

import com.bitwise.parking.ParkingLot;
public class DefaultSort implements Comparator<ParkingLot> {
	@Override
	public int compare(ParkingLot o1, ParkingLot o2) {
		if(o1.FreeSlots()>0)
			return 1;
		return -1;
	}
}
