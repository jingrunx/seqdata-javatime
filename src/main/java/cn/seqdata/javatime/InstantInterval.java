package cn.seqdata.javatime;

import java.time.Instant;
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

	public DateTimeInterval toDateTimeInterval() {
		return new DateTimeInterval(JavaTimeUtils.toLocalDateTime(start), JavaTimeUtils.toLocalDateTime(end));
	}

	@Override
	public InstantInterval withStart(Instant start) {
		return new InstantInterval(start, end);
	}

	@Override
	public InstantInterval withEnd(Instant end) {
		return new InstantInterval(start, end);
	}
}
