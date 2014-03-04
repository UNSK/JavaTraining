package ex11_01;

import java.util.ListResourceBundle;

/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 * add 2.12 可変長の引数をとる、LinkedListを連結するmakeLinkedListメソッドを追加
 * 		また、Vehcle以外も格納できるようにObjectを格納するリストに変更
 * add 2.16 LinkedListの要素数を返すgetListLengthメソッドを追加
 * add 3.10 Cloneableの実装
 */
public class LinkedList<E> implements Cloneable {
	private E data_obj;
	private LinkedList<E> next; 
	
	public LinkedList(E data, LinkedList<E> nextlist) {
		data_obj = data;
		next = nextlist;
	}
	
	@Override
	public LinkedList<E> clone() {
		try {
			LinkedList<E> clonedList = (LinkedList<E>) super.clone();
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
	public void setData_obj(E data_obj) {
		this.data_obj = data_obj;
	}

	/**
	 * @return the next
	 */
	public LinkedList<E> getNext() {
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
		LinkedList<Vehicle> list3 = new LinkedList<>(bike, null);
		LinkedList<Vehicle> list2 = new LinkedList<>(train, list3);
		LinkedList<Vehicle> list1 = new LinkedList<>(car, list2);
		
		System.out.println(list1);
	}
	
}
