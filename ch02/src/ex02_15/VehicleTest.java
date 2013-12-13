package ex02_15;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class VehicleTest {

	Vehicle test_vehicle;
	
	@Before
	public void setUp() {
		test_vehicle = new Vehicle();
		test_vehicle.setSpeed(100.0);
	}
	
	@Test
	public void changeSpeedTest() {
		test_vehicle.changeSpeed(60.0);
		assertThat(test_vehicle.getSpeed(), is(60.0));
	}
	
	@Test
	public void stopTest() {
		test_vehicle.stop();
		assertThat(test_vehicle.getSpeed(), is(0.0));
	}

}
