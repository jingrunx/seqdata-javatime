package cn.seqdata.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public class DateInterval extends ReadableInterval<LocalDate> {
	public static final LocalDate MIN = LocalDate.of(1900, 1, 1);
	public static final LocalDate MAX = LocalDate.of(9999, 12, 31);

	public DateInterval(LocalDate start, LocalDate end) {
		super(LocalDate::compareTo,
			Objects.requireNonNullElse(start, LocalDate.now()),
			Objects.requireNonNullElse(end, LocalDate.now())
		);
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

	public static DateInterval parse(String text) {
		return parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	public static DateInterval parse(String text, DateTimeFormatter formatter) {
		int index = text.indexOf(SEPARATOR);
		if(index == -1) return new DateInterval(MIN, MAX);
		LocalDate start = parseLocalDate(text.substring(0, index), formatter, MIN);
		LocalDate end = parseLocalDate(text.substring(index + 1), formatter, MAX);
		return new DateInterval(start, end);
	}

	public static LocalDate parseLocalDate(String text, LocalDate defaultValue) {
		return parseLocalDate(text, DateTimeFormatter.ISO_LOCAL_DATE, defaultValue);
	}

	public static LocalDate parseLocalDate(String text, DateTimeFormatter formatter, LocalDate defaultValue) {
		if(null == text || text.isEmpty()) {
			return defaultValue;
		} else if("MIN".equals(text)) {
			return MIN;
		} else if("MAX".equals(text)) {
			return MAX;
		} else {
			return LocalDate.parse(text, formatter);
		}
	}
}
