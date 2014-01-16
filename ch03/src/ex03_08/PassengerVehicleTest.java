package ex03_08;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class PassengerVehicleTest {
	
	private PassengerVehicle testPassengerVehicle;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		testPassengerVehicle = new PassengerVehicle();
		testPassengerVehicle.setDirection(60.0);
		testPassengerVehicle.setOwner("test owner");
		testPassengerVehicle.setPassenger_num(4);
		testPassengerVehicle.setSeat_num(5);
		testPassengerVehicle.setSpeed(100.0);
	}

	@Test
	public void cloneTest() {
		PassengerVehicle clonePassengerVehicle = testPassengerVehicle.clone();
		assertThat(clonePassengerVehicle.getDirection(), is(testPassengerVehicle.getDirection()));
		assertThat(clonePassengerVehicle.getOwner(), is(testPassengerVehicle.getOwner()));
		assertThat(clonePassengerVehicle.getPassenger_num(), is(testPassengerVehicle.getPassenger_num()));
		assertThat(clonePassengerVehicle.getSeat_num(), is(testPassengerVehicle.getSeat_num()));
		assertThat(clonePassengerVehicle.getSpeed(), is(testPassengerVehicle.getSpeed()));
		assertThat(clonePassengerVehicle.getVehicleID(), is(testPassengerVehicle.getVehicleID()));
		
	}

}
