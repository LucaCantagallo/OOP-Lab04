package it.unibo.oop.lab04.robot.composable;

public class GrippingArm extends BasicComposable {
	
	private final static double CONSUME_OF_BATTERY = 1.6;

	private boolean armBusy;
	
	public GrippingArm () {
		super();
		this.armBusy = false;
	}
	
	public void pick () {
		if (!this.armBusy) {
			this.armBusy = true;
		}	
	}
	
	public void drop () {
		if (this.armBusy) {
			this.armBusy = false;
		}		
	}
	
	public boolean areArmsBusy () {
		return this.armBusy;
	}
	
	public void armMovement () {
		if (this.armBusy) {
			this.drop();
		} else {
			this.pick();
		}
	}
	
	public double getConsumeOfComposable() {
		return CONSUME_OF_BATTERY;
	}

}