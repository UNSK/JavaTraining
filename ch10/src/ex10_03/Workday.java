package ex10_03;

public class Workday {
	
	public static boolean isWorkdayIf(DayOfWeek day) {
		if (day == DayOfWeek.SATURDAY 
				|| day == DayOfWeek.SUNDAY) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isWorkdaySw(DayOfWeek day) {
		switch (day) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			return true;
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
