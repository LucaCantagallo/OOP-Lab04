package it.unibo.oop.lab04.robot.composable;

public abstract class BasicComposable implements Composable {

	private boolean connetted;
	private boolean switchedOn;
	
	public BasicComposable () {
		this.connetted = false;
		this.switchedOn = false;
	}
	
	public void connet () {
		if (!isConnetted()) {
			this.connetted = true;
		}
	}
	
	public void disconnet () {
		if (isConnetted()) {
			this.connetted = false;
		}
	}
	
	public void switchOn () {
		if (isConnetted() && !isSwitchedOn()) {
			this.switchedOn = true;
		}
	}
	
	public void switchOff () {
		if (isConnetted() && isSwitchedOn()) {
			this.switchedOn = false;
		}
	}
	
	public boolean isConnetted() {
		return this.connetted;
	}
	
	public boolean isSwitchedOn () {
		return this.switchedOn;
	}
	
	public abstract double getConsumeOfComposable();
	
}
