package com.bitwise.parking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ParkingLot {
	private int capacity;
	private int freespace;
	List<Car> al=new ArrayList<Car>();
	Iterator it=al.iterator(); 
	List<ParkingLotObserver> observer=new ArrayList<ParkingLotObserver>();
	public ParkingLot(int i) {
		freespace=i;
		capacity=freespace;
	}
	public void ParktheCar(Car car) {
		if(IsLotFull())
			throw new ParkingLotIsFullSorry();
		if(isitDuplicateCar(car))
			throw new DuplicateCarFoundException(); 
		ParkingCar(car);
		notifyOwners();
	}
	private void notifyOwners() {
		if(isObserverRegistered())
			if(IsLotFull())
				observer.stream().forEach(e ->e.notifyFull());
	}
	private boolean isObserverRegistered() {
		return this.observer != null;
	}
	private void ParkingCar(Car car) {
		this.al.add(car);
		this.freespace--;
	}
	private boolean isitDuplicateCar(Car car) {
		return al.contains(car);
	}
	public boolean IsLotFull() {
		return(freespace==0);
	}
	public class ParkingLotIsFullSorry extends RuntimeException{

		public ParkingLotIsFullSorry(){
			System.out.println("ParkingLotIsAlreadyFull Sorry ");
		}
	}
	public class  DuplicateCarFoundException extends RuntimeException{

		public  DuplicateCarFoundException(){
			System.out.println("Duplicate Car Found");
		}
	}
	public class YouCantUnparkACarWhichIsNotParked extends RuntimeException {
		public YouCantUnparkACarWhichIsNotParked(){
			System.out.println("YouCantUnparkACarWhichIsNotParked");
		}
	}
	public void UnParkCar(Car car) {
		if(isCarParked(car)){
			this.al.remove(car);
			freespace++;
			notifyOwnerstoFullSignUnset();
		}
		else{
			throw new YouCantUnparkACarWhichIsNotParked();
		}
	}
	private void notifyOwnerstoFullSignUnset() {
		observer.stream().forEach(e ->e.notifyFree());
	}
	public boolean isCarParked(Car car) {
		return this.al.contains(car);
	}
	public int FreeSlots() {
		return freespace;
	}
	public void registerObserver(ParkingLotObserver owner) {
		this.observer.add(owner);
	}
	public int capacity() {
		return capacity;
	}}
