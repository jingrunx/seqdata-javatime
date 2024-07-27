package cn.seqdata.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public class DateTimeInterval extends ReadableInterval<LocalDateTime> {
	public static final LocalDateTime MIN = DateInterval.MIN.atTime(LocalTime.MIN);
	public static final LocalDateTime MAX = DateInterval.MAX.atTime(LocalTime.MAX);

	public DateTimeInterval(LocalDateTime start, LocalDateTime end) {
		super(LocalDateTime::compareTo,
			Objects.requireNonNullElse(start, LocalDateTime.now()),
			Objects.requireNonNullElse(end, LocalDateTime.now())
		);
	}

	public DateTimeInterval(LocalDateTime start, TemporalAmount amount) {
		this(start, start.plus(amount));
	}

	public DateTimeInterval(TemporalAmount amount, LocalDateTime end) {
		this(end.minus(amount), end);
	}

	public DateTimeInterval(LocalDateTime start, TemporalUnit unit) {
		this(start, start.plus(1, unit));
	}

	public DateTimeInterval(TemporalUnit unit, LocalDateTime end) {
		this(end.minus(1, unit), end);
	}

	public InstantInterval toInstantInterval() {
		return new InstantInterval(JavaTimeUtils.toInstant(start), JavaTimeUtils.toInstant(end));
	}

	@Override
	public DateTimeInterval withStart(LocalDateTime start) {
		return new DateTimeInterval(start, end);
	}

	@Override
	public DateTimeInterval withEnd(LocalDateTime end) {
		return new DateTimeInterval(start, end);
	}

	public DateInterval toDateInterval() {
		return new DateInterval(start.toLocalDate(), end.toLocalDate());
	}

	public TimeInterval toTimeInterval() {
		return new TimeInterval(start.toLocalTime(), end.toLocalTime());
	}

	public static DateTimeInterval from(LocalDate date) {
		return new DateTimeInterval(JavaTimeUtils.toLocalDateTime(date), Period.ofDays(1));
	}

	public static DateTimeInterval from(YearMonth ym) {
		return new DateTimeInterval(JavaTimeUtils.toLocalDateTime(ym.atDay(1)), Period.ofMonths(1));
	}

	public static DateTimeInterval from(Year year) {
		return new DateTimeInterval(JavaTimeUtils.toLocalDateTime(year.atDay(1)), Period.ofYears(1));
	}

	public static DateTimeInterval parse(String text) {
		return parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	public static DateTimeInterval parse(String text, DateTimeFormatter formatter) {
		int index = text.indexOf(SEPARATOR);
		if(index == -1) return new DateTimeInterval(MIN, MAX);
		LocalDateTime start = parseDateTime(text.substring(0, index), formatter, MIN);
		LocalDateTime end = parseDateTime(text.substring(index + 1), formatter, MAX);
		return new DateTimeInterval(start, end);
	}

	public static LocalDateTime parseDateTime(String text, LocalDateTime defaultValue) {
		return parseDateTime(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME, defaultValue);
	}

	public static LocalDateTime parseDateTime(String text, DateTimeFormatter formatter, LocalDateTime defaultValue) {
		if(null == text || text.isEmpty()) {
			return defaultValue;
		} else if("MIN".equals(text)) {
			return MIN;
		} else if("MAX".equals(text)) {
			return MAX;
		} else {
			return LocalDateTime.parse(text, formatter);
		}
	}
}
