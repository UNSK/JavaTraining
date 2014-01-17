package ex04_01;

/**
 *
 */
public class GasTank implements EnergySource {
	
	private double gasRemains;
	
	@Override
	public boolean empty() {
		if (gasRemains < 10.0) {
			return true;
		}
		return false;
	}

	@Override
	public void fillUp() {
		gasRemains = 100;
	}

	/**
	 * @return the gasRemains
	 */
	@Override
	public double getRemains() {
		return gasRemains;
	}

	/**
	 * @param gasRemains the gasRemains to set
	 */
	@Override
	public void setRemains(double gasRemains) {
		this.gasRemains = gasRemains;
	}

}
