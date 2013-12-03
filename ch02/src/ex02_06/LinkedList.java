package ex02_06;

/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 */
public class LinkedList {
	public Vehicle vehicle;
	public LinkedList next; 
	
	public void printList() {
		vehicle.printVehicle();
		if (this.next != null) {
			next.printList();
		}
	}
	
	public static void main(String[] args) {
		/* 車を設定*/
		Vehicle car = new Vehicle();
		Vehicle.nextID++;
		car.kind = "car";
		car.speed = 60;
		car.direction = 180;
		car.owner = "Souichiro Honda";
		
		/* 列車を設定 */
		Vehicle train = new Vehicle();
		Vehicle.nextID++;
		train.kind = "train";
		train.speed = 100;
		train.direction = 270;
		train.owner = "George Stephenson";
		
		/* LinkedListを作成 */
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.vehicle = car;
		list1.next = list2;
		
		list2.vehicle = train;
		list2.next = null;
		
		/* 表示 */
		list1.printList();
	}

}
