package ex03_10;

import java.util.ListResourceBundle;

/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 * add 2.12 可変長の引数をとる、LinkedListを連結するmakeLinkedListメソッドを追加
 * 		また、Vehcle以外も格納できるようにObjectを格納するリストに変更
 * add 2.16 LinkedListの要素数を返すgetListLengthメソッドを追加
 * add 3.10 Cloneableの実装
 */
public class LinkedList implements Cloneable {
	private Object data_obj;
	private LinkedList next; 
	
	public LinkedList(Object data, LinkedList nextlist) {
		data_obj = data;
		next = nextlist;
	}
	
	@Override
	public LinkedList clone() {
		try {
			LinkedList clonedList = (LinkedList) super.clone();
			if (this.next != null) {
				clonedList.next = this.next.clone();
			}
			return clonedList;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
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
		for (int i = 0; i < lists.length - 1; i++) {
			if (lists[i + 1] != null) {
				lists[i].next = lists[i + 1];
			}
		}
		lists[lists.length - 1].next = null; // listの最後を設定
	}
	
	/**
	 * LinkedListの要素を返す
	 * @return 要素数
	 */
	public int getListLength() {
		if (next != null) {
			return 1 + next.getListLength();
		} else {
			return 1;
		}
	}
	
	/**
	 * @return the data_obj
	 */
	public Object getData_obj() {
		return data_obj;
	}

	/**
	 * @param data_obj the data_obj to set
	 */
	public void setData_obj(Object data_obj) {
		this.data_obj = data_obj;
	}

	/**
	 * @return the next
	 */
	public LinkedList getNext() {
		return next;
	}

	public static void main(String[] args) {
		/* 車を設定*/
		Vehicle car = new Vehicle();
		car.setSpeed(60);
		car.setDirection(180);
		car.setOwner("Souichiro Honda");
		
		/* 列車を設定 */
		Vehicle train = new Vehicle();
		train.setSpeed(100);
		train.setDirection(270);
		train.setOwner("George Stephenson");
		
		/* 自転車を設定 */
		Vehicle bike = new Vehicle();
		bike.setSpeed(15);
		bike.setDirection(90);
		bike.setOwner("John K Starley");

		/* LinkedListを作成 */
		LinkedList list1 = new LinkedList(car, null);
		LinkedList list2 = new LinkedList(train, null);
		LinkedList list3 = new LinkedList(bike, null);
		
		/* listを連結 */
		makeLinkedList(list1, list2, list3);
		
		/* 表示 */
		System.out.println("-- Original --");
		System.out.println(list1);
		
		LinkedList clonedList = list1.clone();
		
		System.out.println("-- Clone --");
		System.out.println(clonedList);
		
		/* オリジナルの順番を入れ替える */
		System.out.println("** changes to original list **");
		makeLinkedList(list3, list2, list1);
		/* list3のデータを変更する */
		bike.setDirection(0.0);
		bike.setOwner("CHANGE!");
		
		/* 表示 */
		System.out.println("-- Original --");
		System.out.println(list3);
		
		System.out.println("-- Clone --");
		System.out.println(clonedList);
	}
	
}
