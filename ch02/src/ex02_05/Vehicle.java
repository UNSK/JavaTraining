package ex02_05;

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
	
	/* 表示用のメソッド */
	public void printVehicle(String kind) {
		System.out.println(kind);
		System.out.println("  id: " + this.vehicleID);
		System.out.println("  speed: " + this.speed);
		System.out.println("  direction: " + this.direction);
		System.out.println("  owner: " + this.owner);
	}
	
	public static void main(String[] args) {
		/* 車を設定*/
		Vehicle car = new Vehicle();
		Vehicle.nextID++;
		car.speed = 60;
		car.direction = 180;
		car.owner = "Souichiro Honda";
		
		/* 列車を設定 */
		Vehicle train = new Vehicle();
		Vehicle.nextID++;
		train.speed = 100;
		train.direction = 270;
		train.owner = "George Stephenson";
		
		/* 表示 */
		car.printVehicle("car");
		train.printVehicle("train");
	}
}
