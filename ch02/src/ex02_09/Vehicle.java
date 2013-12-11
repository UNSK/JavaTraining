package ex02_09;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 * add 2.9 現在使われているIDの最大を返すstaticメソッドの実装
 */
public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	private static long nextID = 0;
	public final long vehicleID;
	
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
	
	/** 表示用のメソッド */
	public void printVehicle(String kind) {
		System.out.println(kind);
		System.out.println("  id: " + this.vehicleID);
		System.out.println("  speed: " + this.speed);
		System.out.println("  direction: " + this.direction);
		System.out.println("  owner: " + this.owner);
	}
	
	public static void main(String[] args) {
		/* 車を設定*/
		Vehicle car = new Vehicle("Souichiro Honda");
		car.speed = 60;
		car.direction = 180;
		
		/* 列車を設定 */
		Vehicle train = new Vehicle("George Stephenson");
		train.speed = 100;
		train.direction = 270;
		
		/* 表示 */
		car.printVehicle("car");
		train.printVehicle("train");
		System.out.println("MaxID: " + getMaxID());
	}
}
