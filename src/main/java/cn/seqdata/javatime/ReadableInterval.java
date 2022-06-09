package cn.seqdata.javatime;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.Objects;

public class ReadableInterval<T extends Temporal> {
	protected final Comparator<T> comparator;
	protected final T start;
	protected final T end;

	protected ReadableInterval(Comparator<T> comparator, T start, T end) {
		this.comparator = Objects.requireNonNull(comparator);
		this.start = Objects.requireNonNull(start);
		this.end = Objects.requireNonNull(end);
	}

	public T getStart() {
		return start;
	}

	public T getEnd() {
		return end;
	}

	public Duration toDuration() {
		return Duration.between(start, end);
	}

	public ReadableInterval<T> withStart(T start) {
		return new ReadableInterval<>(comparator, start, end);
	}

	public ReadableInterval<T> withEnd(T end) {
		return new ReadableInterval<>(comparator, start, end);
	}

	public boolean contains(T temporal) {
		return comparator.compare(temporal, start) >= 0
			&& comparator.compare(temporal, end) < 0;
	}

	public boolean contains(ReadableInterval<T> interval) {
		return comparator.compare(start, interval.start) <= 0
			&& comparator.compare(interval.start, end) < 0
			&& comparator.compare(interval.end, end) <= 0;
	}

	public boolean overlaps(ReadableInterval<T> interval) {
		return comparator.compare(start, interval.end) < 0 && comparator.compare(interval.start, end) < 0;
	}

	public ReadableInterval<T> overlap(ReadableInterval<T> interval) {
		if(!overlaps(interval)) {
			return null;
		}
		T start = comparator.compare(this.start, interval.start) > 0 ? this.start : interval.start;
		T end = comparator.compare(this.end, interval.end) < 0 ? this.end : interval.end;
		return new ReadableInterval<>(comparator, start, end);
	}

	public ReadableInterval<T> gap(ReadableInterval<T> interval) {
		if(comparator.compare(start, interval.start) > 0) {
			return new ReadableInterval<>(comparator, interval.end, start);
		} else if(comparator.compare(interval.start, end) > 0) {
			return new ReadableInterval<>(comparator, end, this.start);
		} else {
			return null;
		}
	}

	public boolean abuts(ReadableInterval<T> interval) {
		return Objects.equals(start, interval.end) || Objects.equals(end, interval.start);
	}

	public boolean isEqual(ReadableInterval<T> other) {
		return Objects.equals(start, other.start) && Objects.equals(end, other.end);
	}

	public boolean isBefore(T temporal) {
		return comparator.compare(end, temporal) <= 0;
	}

	public boolean isBefore(ReadableInterval<T> interval) {
		return isBefore(interval.start);
	}

	public boolean isAfter(T temporal) {
		return comparator.compare(start, temporal) > 0;
	}

	public boolean isAfter(ReadableInterval<T> interval) {
		return comparator.compare(start, interval.end) >= 0;
	}

	@Override
	public String toString() {
		return String.format("%s/%s", start, end);
	}
}
