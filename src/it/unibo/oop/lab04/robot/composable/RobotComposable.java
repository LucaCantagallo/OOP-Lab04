package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotComposable extends BaseRobot {
	
	private AtomicBattery aB;
	private BorderNavigator bN;
	private GrippingArm gA1;
	private GrippingArm gA2;
	
	public RobotComposable (final String robotName) {
		super(robotName);
		aB = new AtomicBattery();
		bN = new BorderNavigator();
		gA1 = new GrippingArm();
		gA2 = new GrippingArm();
	}

	public BasicComposable getaB() {
		return this.aB;
	}

	public BasicComposable getbN() {
		return this.bN;
	}

	public BasicComposable getgA1() {
		return this.gA1;
	}

	public BasicComposable getgA2() {
		return this.gA2;
	}
	
	public void execAll () {
		if(this.bN.isConnetted() && this.bN.isSwitchedOn()) {
			this.bN.wholePath();
			aB.consumeAtomicBattery(bN.getConsumeOfComposable());
		}
		if(this.gA1.isConnetted() && this.bN.isSwitchedOn()) {
			this.gA1.armMovement();
			aB.consumeAtomicBattery(gA1.getConsumeOfComposable());
		}
		if(this.gA2.isConnetted() && this.bN.isSwitchedOn()) {
			this.gA2.armMovement();
			aB.consumeAtomicBattery(gA2.getConsumeOfComposable());
		}
	}
	
	

}
