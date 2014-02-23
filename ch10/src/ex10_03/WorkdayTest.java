package ex10_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkdayTest {

	@Test
	public void test() {
		assertTrue(Workday.isWorkdayIf(DayOfWeek.FRIDAY));
		assertFalse(Workday.isWorkdayIf(DayOfWeek.SUNDAY));
		
		assertTrue(Workday.isWorkdaySw(DayOfWeek.WEDNESDAY));
		assertFalse(Workday.isWorkdaySw(DayOfWeek.SATURDAY));
	}

}
