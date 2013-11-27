package Ex01_14;

public class Walkman {
	private Object jack_;
	
	public void setJack(Object jack) {
		this.jack_ = jack;
	}
	
	public Object getJack() {
		return this.jack_;
	}
	
	public void playMusic() {
		jack_ = "now playing (jack)";
	}
}
