package it.unibo.oop.lab04.robot.composable;

public class AtomicBattery extends BasicComposable {
	
	public final static double BATTERY_FULL = 100;
	private final static double CONSUME_OF_BATTERY = 0.1;
	
	public double atomicBatteryLevel;
	
	public AtomicBattery(){
		super();
		this.atomicBatteryLevel = AtomicBattery.BATTERY_FULL;
	}
	
	public double getBatteryLevel () {
		return atomicBatteryLevel;
	}

	
	public void consumeAtomicBattery (double amount) {
		if (atomicBatteryLevel >= amount) {
            this.atomicBatteryLevel -= amount;
        } else {
            this.atomicBatteryLevel = 0;
        }
		if (atomicBatteryLevel < 50) {
			this.rechargeAtomicBattery();
		}
	}
	
	private void rechargeAtomicBattery () {
		this.atomicBatteryLevel = BATTERY_FULL;
	}
	
	public double getConsumeOfComposable() {
		return CONSUME_OF_BATTERY;
	}
	
}
