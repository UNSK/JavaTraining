package ex02_11;


/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 */
public class LinkedList {
	public Vehicle vehicle;
	public LinkedList next; 
	
	public LinkedList(Vehicle vehcle_data, LinkedList nextlist) {
		vehicle = vehcle_data;
		next = nextlist;
	}
	
	/** 表示用にtoStringをオーバライド */
	@Override
	public String toString() {
		String str_tmp = vehicle.toString();
		if (next != null) {
			str_tmp += "\n" + next;
		}
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
		
		/* LinkedListを作成 */
		LinkedList list2 = new LinkedList(train, null);
		LinkedList list1 = new LinkedList(car, list2);
		
		/* 表示 */
		System.out.println(list1);
	}

}
