package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public class TimeInterval extends ReadableInterval<LocalTime> {
	public static final TimeInterval ALL_DAY = new TimeInterval(LocalTime.MIN, LocalTime.MAX);
	public static final TimeInterval AM = new TimeInterval(LocalTime.MIDNIGHT, LocalTime.NOON);
	public static final TimeInterval PM = new TimeInterval(LocalTime.NOON, LocalTime.MAX);

	public TimeInterval(LocalTime start, LocalTime end) {
		super(LocalTime::compareTo,
			Objects.requireNonNullElse(start, LocalTime.MIN),
			Objects.requireNonNullElse(end, LocalTime.MAX)
		);
	}

	public TimeInterval(LocalTime start, TemporalAmount amount) {
		this(start, start.plus(amount));
	}

	public TimeInterval(TemporalAmount amount, LocalTime end) {
		this(end.minus(amount), end);
	}

	public TimeInterval(LocalTime start, TemporalUnit unit) {
		this(start, start.plus(1, unit));
	}

	public TimeInterval(TemporalUnit unit, LocalTime end) {
		this(end.minus(1, unit), end);
	}

	@Override
	public TimeInterval withStart(LocalTime start) {
		return new TimeInterval(start, end);
	}

	@Override
	public TimeInterval withEnd(LocalTime end) {
		return new TimeInterval(start, end);
	}

	public DateTimeInterval toDateTimeInterval(LocalDate date) {
		return new DateTimeInterval(date.atTime(start), date.atTime(end));
	}

	public static TimeInterval start(LocalTime time) {
		return new TimeInterval(time, LocalTime.MAX);
	}

	public static TimeInterval end(LocalTime time) {
		return new TimeInterval(LocalTime.MIN, time);
	}

	public static TimeInterval parse(String text) {
		return parse(text, DateTimeFormatter.ISO_LOCAL_TIME);
	}

	public static TimeInterval parse(String text, DateTimeFormatter formatter) {
		int index = text.indexOf(SEPARATOR);
		if(index == -1) return ALL_DAY;
		LocalTime start = parseLocalTime(text.substring(0, index), formatter, LocalTime.MIN);
		LocalTime end = parseLocalTime(text.substring(index + 1), formatter, LocalTime.MAX);
		return new TimeInterval(start, end);
	}

	public static LocalTime parseLocalTime(String text, LocalTime defaultValue) {
		return parseLocalTime(text, DateTimeFormatter.ISO_LOCAL_TIME, defaultValue);
	}

	public static LocalTime parseLocalTime(String text, DateTimeFormatter formatter, LocalTime defaultValue) {
		if(null == text || text.isEmpty()) {
			return defaultValue;
		} else if("MIN".equals(text)) {
			return LocalTime.MIN;
		} else if("MAX".equals(text)) {
			return LocalTime.MAX;
		} else if("MIDNIGHT".equals(text)) {
			return LocalTime.MIDNIGHT;
		} else if("NOON".equals(text)) {
			return LocalTime.NOON;
		} else if(text.startsWith("24:00")) {
			return LocalTime.MAX;
		} else {
			return LocalTime.parse(text, formatter);
		}
	}
}
