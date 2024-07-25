package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class ExcelTimeUtils {

	private ExcelTimeUtils() {
	}

	public static double toDouble(LocalTime time) {
		return (double) time.toSecondOfDay() / DateTimeConstants.SECONDS_PER_DAY;
	}

	public static LocalTime toTime(double x) {
		return LocalTime.ofSecondOfDay((long) (x * DateTimeConstants.SECONDS_PER_DAY));
	}

	public static double toDouble(LocalDate date) {
		return DateTimeConstants.DAYS_1900_1970 + date.toEpochDay();
	}

	public static LocalDate toDate(double x) {
		return LocalDate.ofEpochDay((long) (x - DateTimeConstants.DAYS_1900_1970));
	}

	public static double toDouble(LocalDateTime occur) {
		return toDouble(occur.toLocalDate()) + toDouble(occur.toLocalTime());
	}

	public static LocalDateTime toDateTime(double x) {
		return toDate(x).atTime(toTime(x));
	}
}
