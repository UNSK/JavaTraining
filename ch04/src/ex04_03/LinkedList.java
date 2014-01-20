package ex04_03;

/**
 * 4.3 LinkedListをインターフェースで書き換える
 * 回答：インターフェースであるべき。例えば、LinkedListの実装で、Vehicleを拡張したクラスは、
 * LinkedListImplを使用することで、Vehicleの契約を守ったリストを作ることができる
 */
public interface LinkedList {
	
	/**
	 * @return the next
	 */
	LinkedList getNext();
	
	/**
	 * LinkedListの要素を返す
	 * @return 要素数
	 */
	int getListLength();
	
	/**
	 * @return the data_obj
	 */
	Object getData_obj();
	
	/**
	 * @param data_obj the data_obj to set
	 */
	void setData_obj(Object data_obj);
}
