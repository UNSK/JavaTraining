package ex02_06;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 */
public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	public static long nextID = 0;
	public final long vehicleID = nextID;
	public String kind; // 表示用に追加
	
	/* 表示用のメソッド */
	public void printVehicle() {
		System.out.println(kind);
		System.out.println("  id: " + this.vehicleID);
		System.out.println("  speed: " + this.speed);
		System.out.println("  direction: " + this.direction);
		System.out.println("  owner: " + this.owner);
	}
	

}
