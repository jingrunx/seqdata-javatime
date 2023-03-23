package cn.seqdata.javatime;

import java.time.*;
import java.time.temporal.TemporalUnit;

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

	public DateInterval(LocalDate start, TemporalUnit unit) {
		this(start, start.plus(1, unit));
	}

	public DateInterval(TemporalUnit unit, LocalDate end) {
		this(end.minus(1, unit), end);
	}

	@Override
	public Duration toDuration() {
		return toDateTimeInterval().toDuration();
	}

	@Override
	public DateInterval withStart(LocalDate start) {
		return new DateInterval(start, end);
	}

	@Override
	public DateInterval withEnd(LocalDate end) {
		return new DateInterval(start, end);
	}

	public Period toPeriod() {
		return Period.between(start, end);
	}

	public DateTimeInterval toDateTimeInterval() {
		return new DateTimeInterval(start.atTime(LocalTime.MIDNIGHT), end.atTime(LocalTime.MIDNIGHT));
	}

	public static DateInterval from(Year year) {
		return new DateInterval(year.atDay(1), Period.ofYears(1));
	}

	public static DateInterval from(YearMonth ym) {
		return new DateInterval(ym.atDay(1), Period.ofMonths(1));
	}
}
