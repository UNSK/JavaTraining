package ex03_01;

/**
 * Vehicleに座席を追加したクラス
 */
public class PassengerVehicle extends Vehicle {

	private int seat_num;
	private int passenger_num;
	
	@Override
	public String toString () {
		String string = super.toString();
		string += "seat num: " + seat_num + "\n"
				+ "passengers: " + passenger_num + "\n";
		return string;
	}
	
	/**
	 * @return the seat_num
	 */
	public int getSeat_num() {
		return seat_num;
	}

	/**
	 * @param seat_num the seat_num to set
	 */
	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}

	/**
	 * @return the passenger_num
	 */
	public int getPassenger_num() {
		return passenger_num;
	}

	/**
	 * @param passenger_num the passenger_num to set
	 */
	public void setPassenger_num(int passenger_num) {
		this.passenger_num = passenger_num;
	}

	public static void main(String[] args) {
		PassengerVehicle car = new PassengerVehicle();
		car.setOwner("Souichirou Honda");
		car.setDirection(90.0);
		car.setSpeed(60.0);
		car.seat_num = 4;
		car.passenger_num = 2;
		
		PassengerVehicle train = new PassengerVehicle();
		train.setOwner("George Stephenson");
		train.setDirection(180.0);
		train.setSpeed(100.0);
		train.seat_num = 300;
		train.passenger_num = 280;
		
		System.out.println(car);
		System.out.println(train);
		

	}

}
