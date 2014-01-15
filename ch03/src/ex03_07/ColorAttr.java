package ex03_07;

/**
 * 色を特定あるいは記述する文字列として色属性を保持するクラス
 * 3.7 equalsメソッド、hashCodeメソッドをオーバライド
 */
public class ColorAttr extends Attr {
	
	private ScreenColor myColor;
	
	/**
	 * @param name the name to set default
	 * @param value the value to set default
	 */
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	
	/**
	 * @param name the name to set default
	 * value is initialized transparent
	 */
	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	/**
	 * 値を記述ではなくScreenColorに設定する
	 * @param newValue the myColor to set
	 * @return old myColor 
	 */
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	/**
	 * @return 変換されたmyColor
	 */
	public ScreenColor getColor() {
		return myColor;
	}
	
	/**
	 * getValue()で得られる記述からScreenColorを設定する
	 */
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}
	
	/**
	 * @param obj 比較するオブジェクト
	 * @return 名前と値が両方正しい場合にtrueを返す。どちらか異なる、または引数がColorAttrでない場合、false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ColorAttr) {
			if (((ColorAttr) obj).getName().equals(this.getName()) &&
					((ColorAttr) obj).getValue().equals(this.getValue())) {
				return true;
			}
		} 
			return false;
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getValue().hashCode();
	}
}
