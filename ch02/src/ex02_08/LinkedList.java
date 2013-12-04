package ex02_08;

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
	
	public void printList() {
		vehicle.printVehicle();
		if (this.next != null) {
			next.printList();
		}
	}
	
	public static void main(String[] args) {
		/* 車を設定*/
		Vehicle car = new Vehicle("Souichiro Honda");
		car.kind = "car";
		car.speed = 60;
		car.direction = 180;
		
		/* 列車を設定 */
		Vehicle train = new Vehicle("George Stephenson");
		train.kind = "train";
		train.speed = 100;
		train.direction = 270;
		
		/* LinkedListを作成 */
		LinkedList list2 = new LinkedList(train, null);
		LinkedList list1 = new LinkedList(car, list2);
		
		/* 表示 */
		list1.printList();
	}

}
