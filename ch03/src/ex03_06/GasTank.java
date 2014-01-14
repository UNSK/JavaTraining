package ex03_06;

/**
 *
 */
public class GasTank extends EnergySource {
	
	@Override
	public boolean empty() {
		if (getRemain() < 10.0) {
			return true;
		}
		return false;
	}

	@Override
	public void fillUp() {
		setRemain(100.0);
	}

}
