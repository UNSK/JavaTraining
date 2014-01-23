package ex06_04;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.awt.Color;

import org.junit.Test;

public class TrafficLightTest {

	@Test
	public void test() {
		Color red = TrafficLight.RED.getColor();
		Color yellow = TrafficLight.YELLOW.getColor();
		Color green = TrafficLight.GREEN.getColor();
		
		assertThat(red, is(Color.RED));
		assertThat(yellow, is(Color.YELLOW));
		assertThat(green, is(Color.GREEN));
	}

}
