package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class BasicArm {

	public final static double DELTA_DROP_DOWN_CONSUMPTION = 0.8;
	public final static double DELTA_PICK_UP_CONSUMPTION = 1.4;
	
	private final String name;
	private boolean armBusy;
	
	public BasicArm (final String name) {
		this.name = name;
		this.armBusy = false;
	}
	
	public boolean isGrabbing() {					
		if (this.armBusy) {
			return true;
		}
		return false;
	}
	
	public void pickUp() {							//aggiungere i consumi
		if (!isGrabbing()) {
			this.armBusy = true;
		}
	}
	
	public void dropDown () {
		if (isGrabbing()) {
			this.armBusy = false;
		}
	}
	
	public double getConsuptionForPickUp () {
		return this.DELTA_PICK_UP_CONSUMPTION;
	}
	
	public double getConsuptionForDropDown () {
		return this.DELTA_DROP_DOWN_CONSUMPTION;
	}

	public String toString() {
		return "BasicArm [name =" + this.name + "]";
	}
	
	
	
	

}
