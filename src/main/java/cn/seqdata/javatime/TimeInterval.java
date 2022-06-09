package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

public class TimeInterval extends ReadableInterval<LocalTime> {

	public TimeInterval(LocalTime start, LocalTime end) {
		super(LocalTime::compareTo, start, end);
	}

	public TimeInterval(LocalTime start, TemporalAmount amount) {
		this(start, start.plus(amount));
	}

	public TimeInterval(TemporalAmount amount, LocalTime end) {
		this(end.minus(amount), end);
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
}
