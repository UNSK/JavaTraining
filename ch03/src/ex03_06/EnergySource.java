package ex03_06;

/**
 * 3.6 Vehicleの動力源クラス
 */
public abstract class EnergySource {
	
	/** 残量 */
	private double remain = 0.0;
	
	abstract boolean empty();
	abstract void fillUp();
	
	/**
	 * @return the remain
	 */
	public final double getRemain() {
		return remain;
	}
	/**
	 * @param remain the remain to set
	 */
	public final void setRemain(double remain) {
		this.remain = remain;
	}
}
