package com.bitwise.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.bitwise.parking.sortStrategies.DefaultSort;

public class Attendant  {
	private List<ParkingLot> parkinglots;
	private Comparator<ParkingLot> sortAlgo;
	public Attendant(ArrayList<ParkingLot> parkinglots) {
		this.parkinglots=parkinglots;
	}
	public Attendant( ParkingLot... parkingLots ) {
		parkinglots=Arrays.asList(parkingLots);
		sortAlgo=new DefaultSort();
	}
	public void parkCar(Car car) {
		parkinglots.stream().sorted(sortAlgo).filter(e -> e.FreeSlots() > 0).findFirst().get().ParktheCar(car);
	}
	public boolean isCarParked(Car car) {
		return parkinglots.stream().anyMatch(e->e.isCarParked(car));
	}
	public void unParkACar(Car car) {
		parkinglots.stream().filter(e -> e.isCarParked(car)).findFirst().get().UnParkCar(car);
	}
	public Object freeSpace() {
		return parkinglots.stream().mapToInt(e -> e.FreeSlots()).sum();
	}
	public void sortStrategy(Comparator<ParkingLot> mostfreespace) {
		this.sortAlgo=mostfreespace;
	}
}
