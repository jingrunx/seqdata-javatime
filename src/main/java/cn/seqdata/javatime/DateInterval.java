package cn.seqdata.javatime;

import java.time.*;

public class DateInterval extends ReadableInterval<LocalDate> {

	public DateInterval(LocalDate start, LocalDate end) {
		super(LocalDate::compareTo, start, end);
	}

	public DateInterval(LocalDate start, Period amount) {
		this(start, start.plus(amount));
	}

	public DateInterval(Period amount, LocalDate end) {
		this(end.minus(amount), end);
	}

	public Period toPeriod() {
		return Period.between(start, end);
	}

	public DateTimeInterval toDateTimeInterval() {
		return new DateTimeInterval(start.atTime(LocalTime.MIDNIGHT), end.atTime(LocalTime.MIDNIGHT));
	}

	@Override
	public DateInterval withStart(LocalDate start) {
		return new DateInterval(start, end);
	}

	@Override
	public DateInterval withEnd(LocalDate end) {
		return new DateInterval(start, end);
	}

	public static DateInterval from(Year year) {
		return new DateInterval(year.atDay(1), Period.ofYears(1));
	}

	public static DateInterval from(YearMonth ym) {
		return new DateInterval(ym.atDay(1), Period.ofMonths(1));
	}
}
