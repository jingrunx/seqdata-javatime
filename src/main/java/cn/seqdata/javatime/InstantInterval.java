package cn.seqdata.javatime;

import java.time.*;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class InstantInterval extends ReadableInterval<Instant> {

	public InstantInterval(Instant start, Instant end) {
		super(Instant::compareTo, start, end);
	}

	public InstantInterval(Instant start, TemporalAmount amount) {
		this(start, start.plus(amount));
	}

	public InstantInterval(TemporalAmount amount, Instant end) {
		this(end.minus(amount), end);
	}

	public InstantInterval(Instant start, TemporalUnit unit) {
		this(start, start.plus(1, unit));
	}

	public InstantInterval(TemporalUnit unit, Instant end) {
		this(end.minus(1, unit), end);
	}

	@Override
	public InstantInterval withStart(Instant start) {
		return new InstantInterval(start, end);
	}

	@Override
	public InstantInterval withEnd(Instant end) {
		return new InstantInterval(start, end);
	}

	public DateTimeInterval toDateTimeInterval() {
		return new DateTimeInterval(JavaTimeUtils.toLocalDateTime(start), JavaTimeUtils.toLocalDateTime(end));
	}

	public static InstantInterval from(LocalDate date) {
		return new InstantInterval(JavaTimeUtils.toInstant(date), Period.ofDays(1));
	}

	public static InstantInterval from(YearMonth ym) {
		return new InstantInterval(JavaTimeUtils.toInstant(ym.atDay(1)), Period.ofMonths(1));
	}

	public static InstantInterval from(Year year) {
		return new InstantInterval(JavaTimeUtils.toInstant(year.atDay(1)), Period.ofYears(1));
	}
}
