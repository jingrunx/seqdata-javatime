package cn.seqdata.javatime;

import java.time.LocalDateTime;
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

	public DateInterval toDateInterval() {
		return new DateInterval(start.toLocalDate(), end.toLocalDate());
	}

	public TimeInterval toTimeInterval() {
		return new TimeInterval(start.toLocalTime(), end.toLocalTime());
	}

	@Override
	public DateTimeInterval withStart(LocalDateTime start) {
		return new DateTimeInterval(start, end);
	}

	@Override
	public DateTimeInterval withEnd(LocalDateTime end) {
		return new DateTimeInterval(start, end);
	}
}
