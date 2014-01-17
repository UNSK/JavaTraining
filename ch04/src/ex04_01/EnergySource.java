package ex04_01;

/**
 * 4.1 Vehicleの動力源を表すインターフェース
 */
interface EnergySource {
	/** 
	 * 動力源が空かどうかを判定する
	 * @return 空ならtrue
	 */
	boolean empty();
	
	/**
	 * 動力源を満タンにする
	 */
	void fillUp();
	
	double getRemains();
	void setRemains(double remain);
}
