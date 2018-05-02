package com.bitwise.parking;

public class Car {
	String car_number;
 public Car(String car)
 {
	car_number=car;
 }
 public boolean equals(Object obj) {
     if (obj == null) {
           return false;
     }
     Car c=(Car)obj;
     if(this.car_number.equalsIgnoreCase(c.car_number))
           return true;
     return false;
}



}
