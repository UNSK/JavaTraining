package ex03_06;

/**
 *
 */
public class Battery extends EnergySource {

	@Override
	boolean empty() {
		if (getRemain() < 10.0) {
			return true;
		}
		return false;
	}

	@Override
	void fillUp() {
		setRemain(100.0);
	}

}
