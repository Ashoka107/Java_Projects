package com.bitwise.parking.Test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.bitwise.parking.Car;
import com.bitwise.parking.Owner;
import com.bitwise.parking.ParkingLot;
import com.bitwise.parking.ParkingLotObserver;

public class OwnerTest {
	@Test
	public void ItShouldInformOwnerIfLotIsFull(){
		ParkingLotObserver owner=new Owner();
		ParkingLot parkinglot=new ParkingLot(2);
		parkinglot.registerObserver(owner);

		parkinglot.ParktheCar(new Car("101"));
		parkinglot.ParktheCar(new Car("102"));

		Assert.assertTrue(owner.IsLotFullBoardSet());
	}
	@Test
	public void ItShouldInformOwnerIfLotIsFree(){
		ParkingLotObserver owner=new Owner();
		ParkingLot parkinglot=new ParkingLot(2);
		parkinglot.registerObserver(owner);

		parkinglot.ParktheCar(new Car("101"));
		parkinglot.ParktheCar(new Car("102"));

		int beforeUnparkfreespace=parkinglot.FreeSlots();
		parkinglot.UnParkCar(new Car("102"));

		int afterUnparkfreespace= parkinglot.FreeSlots();
		assertTrue(afterUnparkfreespace>beforeUnparkfreespace);
	}
}
