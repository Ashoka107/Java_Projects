package com.bitwise.parking.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Test;

import com.bitwise.parking.Car;
import com.bitwise.parking.ParkingLot;
import com.bitwise.parking.ParkingLot.YouCantUnparkACarWhichIsNotParked;

public class ParkingTest {

	public void ItShouldAbleToParkACarOnlyIfTheLotHasFreeSpace(){
		
		ParkingLot parkinglot=new ParkingLot(2);
		Car car=new Car("101");
		parkinglot.ParktheCar(car);
		
		assertTrue(parkinglot.isCarParked(car));
	}
	
	
	@Test(expected=ParkingLot.ParkingLotIsFullSorry.class)
	public void ItShouldParkACarifthelothasfreespace()
	{
		ParkingLot parkinglot=new ParkingLot(5);
			parkinglot.ParktheCar(new Car("107"));
			parkinglot.ParktheCar(new Car("101"));
			parkinglot.ParktheCar(new Car("102"));
			parkinglot.ParktheCar(new Car("104"));
			parkinglot.ParktheCar(new Car("106"));
			parkinglot.ParktheCar(new Car("105"));
		}

	@Test(expected=ParkingLot.DuplicateCarFoundException.class)
	public void ItShouldNotParkADuplicateCar(){
		
		ParkingLot parkinglot=new ParkingLot(3);
		parkinglot.ParktheCar(new Car("101"));
		parkinglot.ParktheCar(new Car("102"));
		parkinglot.ParktheCar(new Car("101"));
	}
	@Test
	public void ItShouldFreedUpSpaceInLotWhenUnParkACar(){
		ParkingLot parkinglot=new ParkingLot(2);
		parkinglot.ParktheCar(new Car("101"));
		parkinglot.ParktheCar(new Car("102"));
		
	    int beforeUnparkfreespace	=parkinglot.FreeSlots();
		parkinglot.UnParkCar(new Car("102"));
		int afterUnparkfreespace= parkinglot.FreeSlots();
		assertTrue(afterUnparkfreespace>beforeUnparkfreespace);
	}
	@Test(expected=ParkingLot. YouCantUnparkACarWhichIsNotParked.class)
	public void ItShouldNotUnparkACarWhichIsNotParked(){
		ParkingLot parkinglot=new ParkingLot(2);
		parkinglot.ParktheCar(new Car("101"));
		parkinglot.ParktheCar(new Car("102"));
		parkinglot.UnParkCar(new Car("103"));
	}
}
