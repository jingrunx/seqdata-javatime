package cn.seqdata.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class DateTimeInterval extends ReadableInterval<LocalDateTime> {

	public DateTimeInterval(LocalDateTime start, LocalDateTime end) {
		super(LocalDateTime::compareTo, start, end);
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
		String[] split = text.split(SEPARATOR);
		return new DateTimeInterval(LocalDateTime.parse(split[0]), LocalDateTime.parse(split[1]));
	}

	public static DateTimeInterval parse(String text, DateTimeFormatter formatter) {
		String[] split = text.split(SEPARATOR);
		return new DateTimeInterval(LocalDateTime.parse(split[0], formatter), LocalDateTime.parse(split[1], formatter));
	}
}
