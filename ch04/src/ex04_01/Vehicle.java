package ex04_01;

/**
 * 次の乗り物のIDと車単位のIDを持つVehicleクラス
 * vehicleIDは不変であると考えられるためfinalにする
 * add 2.9 現在使われているIDの最大を返すstaticメソッドの実装
 * add 2.10 toStringメソッドの追加（printVehicleメソッドを削除）
 * add 2.13 アクセサの作成
 * add 2.14 changeSpeedメソッド、stopメソッドの追加
 * add 2.17 turnメソッドの追加
 * add 2.18 mainメソッドの変更
 * add 3.4 stopメソッド、getVehicleIdメソッドをfinalに変更。定数を代入したり、取得するメソッドは変更されないようにすべき。stopに関しては拡張性が落ちると思うが。
 * add 3.6 EnergySourceとstartメソッドの追加
 */
public class Vehicle {
	public static final int TURN_LEFT = 0;
	public static final int TURN_RIGHT = 1;
	
	private double speed;
	private double direction;
	private String owner;
	private EnergySource energy;
	
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
	
	/**
	 * 現在の速度を変更するメソッド
	 * @param speed_after 変更後の速度
	 */
	public void changeSpeed(double speed_after) {
		speed = speed_after;
	}
	
	/**
	 * 速度を0にするメソッド
	 */
	public final void stop() {
		speed = 0;
	}
	
	/**
	 * @param angle 回転する角度
	 */
	public void turn(double angle) {
		direction += angle;
	}
	
	/**
	 * @param way_lr TURN_LEFTかTURN_RIGHTのみ
	 */
	public void turn(int way_lr) {
		switch (way_lr) {
		case TURN_LEFT:
			direction += 90; 
			break;
		case TURN_RIGHT:
			direction -= 90;
			break;
		default:
			System.err.println("turn: pass TURN_LEFT or TURN_RIGHT");
			break;
		}
	}
	
	/**
	 * 動力源が空でないことを保証する
	 * もし空であるなら、満タンにする
	 */
	public void start() {
		if(energy.empty()) {
			System.out.println("Energy is empty. Filled up.");
			energy.fillUp();
		} else {
			System.out.println("Energy remain enough.");
		}
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
	public final long getVehicleID() {
		return vehicleID;
	}
	
	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(EnergySource energy) {
		this.energy = energy;
	}
	
	/**
	 * @return the energy remain
	 */
	public double getEnergyRemain() {
		return this.energy.getRemains();
	}
	
	/**
	 * @return is energy empty
	 */
	public boolean isEnergyEmpty() {
		return this.energy.empty();
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		car.setOwner("Souichirou Honda");
		car.setDirection(90.0);
		car.setSpeed(60.0);
		car.energy = new GasTank();
		
		
		Vehicle train = new Vehicle();
		train.setOwner("George Stephenson");
		train.setDirection(180.0);
		train.setSpeed(100.0);
		train.energy = new Battery();
		train.energy.setRemains(50.0);
		
		//System.out.println(car);
		//System.out.println(train);
		
		System.out.println("car energy remain: " + car.energy.getRemains());
		System.out.println("train energy remain: " + train.energy.getRemains());
		car.start();
		train.start();
	}
}
