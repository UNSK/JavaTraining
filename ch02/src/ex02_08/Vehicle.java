package ex02_08;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 */
public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	private static long nextID = 0;
	public final long vehicleID;
	public String kind; // 表示用に追加

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
	
	/* 表示用のメソッド */
	public void printVehicle() {
		System.out.println(kind);
		System.out.println("  id: " + this.vehicleID);
		System.out.println("  speed: " + this.speed);
		System.out.println("  direction: " + this.direction);
		System.out.println("  owner: " + this.owner);
	}
	
}
