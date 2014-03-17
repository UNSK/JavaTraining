package ex12_01;


/**
 * Vehicle型のフィールドと、次のLinkedListへの参照を持つクラス
 * add 2.12 可変長の引数をとる、LinkedListを連結するmakeLinkedListメソッドを追加
 * 		また、Vehcle以外も格納できるようにObjectを格納するリストに変更
 * add 2.16 LinkedListの要素数を返すgetListLengthメソッドを追加
 * add 12.1 ObjectNotFoundExceptionをthrowするfindメソッドの追加
 */
public class LinkedList {
	private Object dataObject;
	private LinkedList next; 
	
	public LinkedList(Object data, LinkedList nextlist) {
		dataObject = data;
		next = nextlist;
	}
	
	/** 表示用にtoStringをオーバライド */
	@Override
	public String toString() {
		String str_tmp = dataObject.toString();
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
	
	public LinkedList find(Object o) throws ObjectNotFoundException {
		LinkedList list = this;
		while (list != null) {
			if (list.dataObject.equals(o)) {
				return list;
			} else {
				list = list.next;
			}
		}
		throw new ObjectNotFoundException(o);
	}
	
	/**
	 * @return the data_obj
	 */
	public Object getData_obj() {
		return dataObject;
	}

	/**
	 * @param data_obj the data_obj to set
	 */
	public void setData_obj(Object data_obj) {
		this.dataObject = data_obj;
	}

	/**
	 * @return the next
	 */
	public LinkedList getNext() {
		return next;
	}
}
