package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.RobotEnvironment;
import it.unibo.oop.lab04.robot.base.RobotPosition;

public class BorderNavigator extends BasicComposable {	

	private static final double CONSUME_OF_BATTERY = 1.4;
	private static final int MOVEMENT_DELTA = 1;
	
	private RobotPosition pos;
	private RobotPosition firstBorderPosition;
	
	public BorderNavigator () {
		super();
		this.pos = new RobotPosition(0, 0);
		this.firstBorderPosition = new RobotPosition(0, 0);
	}
	
	public RobotPosition getPosition () {
		return this.pos;
	}
	
	public void up(final RobotPosition stop) {
		while(pos.getY() < RobotEnvironment.Y_UPPER_LIMIT | this.pos == stop) {
			this.pos.sumVector(0, MOVEMENT_DELTA);
		}
	}
	
	public void right(final RobotPosition stop) {
		while(pos.getX() < RobotEnvironment.X_UPPER_LIMIT | this.pos == stop) {
			this.pos.sumVector(MOVEMENT_DELTA, 0);
		}
	}
	
	public void down(final RobotPosition stop) {
		while(pos.getY() > RobotEnvironment.Y_LOWER_LIMIT | this.pos == stop) {
			this.pos.sumVector(0, -MOVEMENT_DELTA);
		}
	}
	
	public void left(final RobotPosition stop) {
		while(pos.getX() > RobotEnvironment.X_LOWER_LIMIT | this.pos == stop) {
			this.pos.sumVector(-MOVEMENT_DELTA, 0);
		}
	}
	
	public boolean wholePath() {
		this.firstBorderPosition = this.pos;
		while (true) {
			this.up(this.firstBorderPosition);
			if (this.pos == firstBorderPosition) {
				return true;
			}
			this.right(this.firstBorderPosition);
			if (this.pos == firstBorderPosition) {
				return true;
			}
			this.down(this.firstBorderPosition);
			if (this.pos == firstBorderPosition) {
				return true;
			}
			this.left(this.firstBorderPosition);
			if (this.pos == firstBorderPosition) {
				return true;
			}
		}	
	}
	
	public double getConsumeOfComposable() {
		return CONSUME_OF_BATTERY;
	}
	
/*	if (this.pos.getX() == RobotEnvironment.X_UPPER_LIMIT |  
			this.pos.getX() == RobotEnvironment.X_LOWER_LIMIT |
			this.pos.getY() == RobotEnvironment.Y_UPPER_LIMIT |
			this.pos.getY() == RobotEnvironment.Y_UPPER_LIMIT ) */
	
	
	
}
