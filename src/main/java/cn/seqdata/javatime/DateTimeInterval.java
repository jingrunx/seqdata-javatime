package cn.seqdata.javatime;

import java.time.*;
import java.time.temporal.TemporalAmount;

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
}
