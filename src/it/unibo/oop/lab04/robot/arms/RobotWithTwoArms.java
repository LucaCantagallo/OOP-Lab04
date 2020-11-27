package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	
	private final static double ONE_ARM_BUSY_DELTA_CONSUMPTION = 1.6;
	
	private BasicArm rightArm;
	private BasicArm leftArm;
	private int itemsCarried = 0;
	
	public RobotWithTwoArms (final String robotName) {
		super(robotName);
		this.rightArm = new BasicArm("rA20");
		this.leftArm = new BasicArm("lA20");
	}
	
	public boolean dropDown() { //se sono vuote -->falso
		if (this.rightArm.isGrabbing()) {
			this.rightArm.dropDown();
			this.decrementItems();
			consumeBattery(this.rightArm.getConsuptionForDropDown());
			return true;
		} else if (this.leftArm.isGrabbing()){
			this.leftArm.dropDown();
			this.decrementItems();
			consumeBattery(this.leftArm.getConsuptionForDropDown());
			return true;
		}
		return false; //empty arms
	}
	
//	private void consumePickUp() {
//		if (rightArm.isGrabbing() & leftArm.isGrabbing()) {
//			consumeBattery(this.rightArm.getConsuptionForPickUp() * 2);
//		} else if (rightArm.isGrabbing() | leftArm.isGrabbing()) {
//			consumeBattery(this.rightArm.getConsuptionForPickUp());
//		}
//	}
	
	public boolean pickUp () { //se pieno -> falso
		if (!this.rightArm.isGrabbing()) {
			this.rightArm.pickUp();
			this.incrementItems();
			consumeBattery(this.rightArm.getConsuptionForPickUp());
			return true;
		} else if (!this.leftArm.isGrabbing()){
			this.leftArm.pickUp();
			this.incrementItems();
			consumeBattery(this.leftArm.getConsuptionForPickUp());
			return true;
		}
		consumeBattery(this.leftArm.getConsuptionForPickUp() + this.rightArm.getConsuptionForPickUp());
		return false;
	}
	
	public int getCarriedItemsCount() {
		return this.itemsCarried;
	}
	
	private void incrementItems () {
		this.itemsCarried++;
	}
	
	private void decrementItems () {
		this.itemsCarried--;
	}
	
	private double getBatteryRequirementForMovementWithBusyArms(){
		return RobotWithTwoArms.ONE_ARM_BUSY_DELTA_CONSUMPTION;
	}
	
	protected double getBatteryRequirementForMovement() {
		if (getCarriedItemsCount() == 2) {
			return super.getBatteryRequirementForMovement() + getBatteryRequirementForMovementWithBusyArms() * 2;
		} else if (getCarriedItemsCount() == 1) {
			return super.getBatteryRequirementForMovement() + getBatteryRequirementForMovementWithBusyArms();
		}
        return super.getBatteryRequirementForMovement();
    }
	
}
