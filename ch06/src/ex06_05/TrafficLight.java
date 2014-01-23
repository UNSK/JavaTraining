package ex06_05;

import java.awt.Color;

/**
 * Colors of traffic light
 * 6.4 Expand that each enum has a Color object 
 * 		can be retrieve with getColor method;
 * 6.5 change getColor as abstract method and 
 * 		each enum define constant-specific method
 */
public enum TrafficLight {
	RED {
		Color getColor() {
			return Color.RED;
		}
	},
	YELLOW {
		Color getColor() {
			return Color.YELLOW;
		}
	},
	
	GREEN {
		Color getColor() {
			return Color.GREEN;
		}
	};
	
	/** @return java.awt.Color */
	abstract Color getColor(); 
}
