package ex03_09;


/**
 * 3.9 複数のVehicleを配列に保持できるクラス
 */
public class Garage implements Cloneable {
	/** ガレージの大きさ */
	private static final int GARAGE_SIZE = 10;
	/** Vehicleを格納する配列 */
	private Vehicle[] vehicles = new Vehicle[GARAGE_SIZE];
	
	public Garage clone() {
		try {
		Garage cloneGarage = (Garage) super.clone();
		// deep copy
		cloneGarage.vehicles = new Vehicle[GARAGE_SIZE];
		for (int i = 0; i < GARAGE_SIZE; i++) {
			if (this.vehicles[i] != null) {
				cloneGarage.vehicles[i] = this.vehicles[i].clone();
			}
		}
		return cloneGarage;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
	/**
	 * ガレージに含まれるVehicleを標準出力に表示する
	 */
	public void showGarage() {
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle != null) {
				System.out.println(vehicle);
			}
		}
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.vehicles[0] = new Vehicle();
		garage.vehicles[0].setDirection(45.0);
		garage.vehicles[0].setOwner("Owner 1");
		garage.vehicles[0].setSpeed(60.0);
		
		garage.vehicles[1] = new Vehicle();
		garage.vehicles[1].setDirection(90.0);
		garage.vehicles[1].setOwner("Owner 2");
		garage.vehicles[1].setSpeed(100.0);
		
		Garage cloneGarage = garage.clone();
		
		System.out.println("-- Original --");
		garage.showGarage();
		System.out.println("-- Clone --");
		cloneGarage.showGarage();
		
		//書き換えて再表示して、cloneが独立しているか確認
		garage.vehicles[0].setDirection(180.0);
		garage.vehicles[0].setOwner("Changed Owner 1");
		garage.vehicles[0].setSpeed(30.0);
		
		System.out.println("-- Original --");
		garage.showGarage();
		System.out.println("-- Clone --");
		cloneGarage.showGarage();
	}

}
