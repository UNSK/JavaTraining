package ex06_04;

import java.awt.Color;

/**
 * Colors of traffic light
 * 6.4 Expand that each enum has a Color object 
 * 		can be retrieve with getColor method;
 */
public enum TrafficLight {
	RED(Color.RED),
	YELLOW(Color.YELLOW),
	GREEN(Color.GREEN);
	
	/** java.awt.Color */
	private Color color_;
	
	/** @param color set to the color_ */
	TrafficLight(Color color) {
		this.color_ = color;
	};
	
	/** @return the color_ */
	Color getColor() {
		return color_;
	}
}
