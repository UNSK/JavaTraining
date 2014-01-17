package ex04_01;

/**
 *
 */
public class Battery implements EnergySource {

	private double batteryRemain;
	
	@Override
	public boolean empty() {
		if (batteryRemain < 10.0) {
			return true;
		}
		return false;
	}

	@Override
	public void fillUp() {
		batteryRemain = 100;
	}

	/**
	 * @return the batteryRemain
	 */
	@Override
	public double getRemains() {
		return batteryRemain;
	}

	/**
	 * @param batteryRemain the batteryRemain to set
	 */
	@Override
	public void setRemains(double batteryRemain) {
		this.batteryRemain = batteryRemain;
	}

}
