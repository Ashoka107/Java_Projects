package com.bitwise.parking.Test;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import com.bitwise.parking.Attendant;
import com.bitwise.parking.Car;
import com.bitwise.parking.Owner;
import com.bitwise.parking.ParkingLot;
import com.bitwise.parking.ParkingLotObserver;
import com.bitwise.parking.sortStrategies.SortByMostCapacity;
import com.bitwise.parking.sortStrategies.SortByMostFreeSpace;

public class AttendantTest {

	private  ParkingLotObserver owner;
	private  ParkingLot parkinglot1;
	private  ParkingLot parkinglot2;
	private  ParkingLot parkinglot3;

	public void SetUp(){

		owner=new Owner();
		parkinglot1=new ParkingLot(2);
		parkinglot1.registerObserver(owner);
		parkinglot2=new ParkingLot(3);
		parkinglot2.registerObserver(owner);
		parkinglot3=new ParkingLot(4);
		parkinglot3.registerObserver(owner);
	}
	//@Test
	public void AttendantShouldBeAbleToParkInLotWithFreeSpace()
	{
		Attendant attendant=new Attendant(new ArrayList<ParkingLot>()

				{{add(parkinglot1);add(parkinglot2);add(parkinglot3);}});

		attendant.parkCar(new Car("101"));

		Assert.assertTrue(attendant.isCarParked(new Car("101")));
	}

	//@Test
	public void AttendantShouldBeAbleToUnParkACar(){

		Attendant attendant=new Attendant(new ArrayList<ParkingLot>()
				{{add(parkinglot1);add(parkinglot2);add(parkinglot3);}});
		attendant.parkCar(new Car("101"));
		attendant.parkCar(new Car("102"));
		attendant.parkCar(new Car("103"));
		attendant.parkCar(new Car("104"));

		attendant.unParkACar(new Car("103"));

		Assert.assertFalse(attendant.isCarParked(new Car("103")));
	}

	@Test
	public void AttendantShouldBeAbleToParkCarsInMultipleLotsWithFreeSpace(){
		this.SetUp();
		Attendant attendant=new Attendant(parkinglot1,parkinglot2);
		attendant.parkCar(new Car("101"));
		attendant.parkCar(new Car("102"));
		attendant.parkCar(new Car("103"));
		attendant.parkCar(new Car("104"));
		attendant.parkCar(new Car("105"));

		Assert.assertTrue(attendant.isCarParked(new Car("105")));
	}

	@Test
	public void AttendantShouldUnparkCarsFromMultipleLots()
	{
		this.SetUp();
		Attendant attendant=new Attendant(parkinglot1,parkinglot2);
		attendant.parkCar(new Car("101"));
		attendant.parkCar(new Car("102"));
		attendant.parkCar(new Car("103"));

		attendant.unParkACar(new Car("102"));
		attendant.unParkACar(new Car("103"));

		Assert.assertFalse(attendant.isCarParked(new Car("102")));
		//Assert.assertEquals(4,attendant.freeSpace());
	}

	@Test
	public void AttendantShouldParkCarInLotHasMostFreeSpace()
	{
		this.SetUp();
		Attendant attendant=new Attendant(parkinglot1,parkinglot2,parkinglot3);
		Comparator<ParkingLot> mostfreespace=new SortByMostFreeSpace();

		attendant.sortStrategy(mostfreespace);
		attendant.parkCar(new Car("101"));
		attendant.parkCar(new Car("102"));
		attendant.parkCar(new Car("103"));

		Assert.assertEquals(2,parkinglot1.FreeSlots());
		Assert.assertEquals(2,parkinglot2.FreeSlots());
		Assert.assertEquals(2,parkinglot3.FreeSlots());
	}
	@Test
	public void AttendantShouldParkCarsInLotWithMostCapacityFirst()
	{
		this.SetUp();
		Attendant attendant=new Attendant(parkinglot1,parkinglot2,parkinglot3);
		Comparator<ParkingLot> mostCapacity=new SortByMostCapacity();

		attendant.sortStrategy(mostCapacity);

		attendant.parkCar(new Car("101"));
		attendant.parkCar(new Car("102"));
		attendant.parkCar(new Car("103"));
		Assert.assertEquals(2,parkinglot1.FreeSlots());
		Assert.assertEquals(3,parkinglot2.FreeSlots());
		Assert.assertEquals(1,parkinglot3.FreeSlots());
	}
}