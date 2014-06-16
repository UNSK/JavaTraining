package ex22_13;

/**
 *　名前と値をの組を保持する属性クラス
 */
public class Attr {
	private final String name;
	private Object value = null;
	
	/**
	 * @param name the name to set default
	 */
	public Attr(String name) {
		this.name = name;
	}
	
	/**
	 * @param name the name to default
	 * @param value the value to default
	 */
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param newValue the value to set
	 * @return old value
	 */
	public Object setValue(Object newValue) {
		Object oldVal = value;
		this.value = newValue;
		return oldVal;
	}

	@Override
	public String toString() {
		return name + "='" + value + "'";
	}
	
}
