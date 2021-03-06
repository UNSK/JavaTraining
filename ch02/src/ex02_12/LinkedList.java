package ex02_12;


/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 * 2.12 可変長の引数をとる、LinkedListを連結するmakeLinkedListメソッドを追加
 * 		また、Vehcle以外も格納できるようにObjectを格納するリストに変更
 */
public class LinkedList {
	public Object data_obj;
	public LinkedList next; 
	
	public LinkedList(Object data, LinkedList nextlist) {
		data_obj = data;
		next = nextlist;
	}
	
	/** 表示用にtoStringをオーバライド */
	@Override
	public String toString() {
		String str_tmp = data_obj.toString();
		if (next != null) {
			str_tmp += "\n" + next;
		}
		return str_tmp;
	}
	
	/**
	 * LinkedListを連結する
	 * @param lists　LinkedListのシーケンス、与えた順番に連結される
	 */
	public static void makeLinkedList(LinkedList...lists) {
		for(int i = 0; i < lists.length - 1 ; i++) {
			if (lists[i + 1] != null) {
				lists[i].next = lists[i + 1];
			}
		}
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
		
		/* 自転車を設定 */
		Vehicle bike = new Vehicle("John K Starley");
		bike.speed = 15;
		bike.direction = 90;
		
		/* LinkedListを作成 */
		LinkedList list1 = new LinkedList(car, null);
		LinkedList list2 = new LinkedList(train, null);
		LinkedList list3 = new LinkedList(bike, null);
		
		/* listを連結 */
		makeLinkedList(list1, list2, list3);
		
		/* 表示 */
		System.out.println(list1);
	}

}
