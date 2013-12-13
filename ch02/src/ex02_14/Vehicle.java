package ex02_14;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 * add 2.9 現在使われているIDの最大を返すstaticメソッドの実装
 * add 2.10 toStringメソッドの追加（printVehicleメソッドを削除）
 * add 2.13 アクセサの作成
 */
public class Vehicle {
	private double speed;
	private double direction;
	private String owner;
	
	private static long nextID = 0;
	private final long vehicleID;
	
	/**　引数なしコンストラクタ　VehcleIDを初期化する */
	public Vehicle() {
		vehicleID = nextID++;
	}
	
	/**
	 * @param owner_name　初期化する所有者名
	 */
	public Vehicle(String owner_name) {
		this();
		owner = owner_name;
	}
	
	/** IDの最大を返すstaticメソッド */
	static public long getMaxID() {
		return (nextID - 1);
	} 
	
	/** 表示用にtoStringメソッドをオーバライド */
	@Override
	public String toString() {
		String str_tmp = "id: " + vehicleID + "\n"
				+ "speed: "		+ speed + "\n"
				+ "direction: " + direction + "\n"
				+ "owner: " 	+ owner+ "\n";
		return str_tmp;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the vehicleID
	 */
	public long getVehicleID() {
		return vehicleID;
	}

}
