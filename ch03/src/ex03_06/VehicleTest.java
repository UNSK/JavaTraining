package ex03_06;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 3.6 startTest追加
 */
public class VehicleTest {

	Vehicle test_vehicle;
	
	@Before
	public void setUp() {
		test_vehicle = new Vehicle();
		test_vehicle.setSpeed(100.0);
		test_vehicle.setDirection(90);
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
	
	@Test
	public void turnAngleTest() {
		test_vehicle.turn(30.0);
		assertThat(test_vehicle.getDirection(), is(120.0));
	}
	
	@Test 
	public void turnLRTest() {
		test_vehicle.turn(Vehicle.TURN_LEFT);
		assertThat(test_vehicle.getDirection(), is(180.0));
		test_vehicle.turn(Vehicle.TURN_RIGHT);
		assertThat(test_vehicle.getDirection(), is(90.0));
	}

	@Test
	public void startTest() {
		test_vehicle.setEnergy(new GasTank());
		test_vehicle.start();
		assertThat(test_vehicle.isEnergyEmpty(), is(false));
		
		test_vehicle.setEnergy(new Battery());
		test_vehicle.start();
		assertThat(test_vehicle.isEnergyEmpty(), is(false));
	}
}
