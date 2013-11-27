package Ex01_14;

public class TwoJacksWalkman extends Walkman {
	private Object sub_jack_;
	
	public void setSubJack(Object sub_jack) {
		this.sub_jack_ = sub_jack;
	}
	
	public Object getSubjack() {
		return this.sub_jack_;
	}
	
	@Override
	public void playMusic() {
		super.playMusic();
		this.sub_jack_ = "now playing (sub_jack)";
	}
}
