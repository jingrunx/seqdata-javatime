package cn.seqdata.javatime;

import java.time.*;
import java.time.temporal.TemporalAmount;

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
