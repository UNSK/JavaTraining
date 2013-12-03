package ex02_04;

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
}
