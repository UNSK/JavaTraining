package ex02_10;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 * add 2.9 現在使われているIDの最大を返すstaticメソッドの実装
 * add 2.10 toStringメソッドの追加（printVehicleメソッドを削除）
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
	
	/** 表示用にtoStringメソッドをオーバライド */
	@Override
	public String toString() {
		String str_tmp = "id: " + vehicleID + "\n"
				+ "speed: "		+ speed + "\n"
				+ "direction: " + direction + "\n"
				+ "owner: " 	+ owner+ "\n";
		return str_tmp;
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
		System.out.println(car);
		System.out.println(train);
		System.out.println("MaxID: " + getMaxID());
	}
}
