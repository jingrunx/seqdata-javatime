package cn.seqdata.javatime;

import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public final class TemporalUtils {

	private TemporalUtils() {
	}

	public static TemporalAmount multipliedBy(TemporalAmount value, int scalar) {
		if(value instanceof Duration) {
			return ((Duration) value).multipliedBy(scalar);
		} else if(value instanceof ChronoPeriod) {
			return ((ChronoPeriod) value).multipliedBy(scalar);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public static TemporalAmount dividedBy(TemporalAmount value, long divisor) {
		if(value instanceof Duration) {
			return ((Duration) value).dividedBy(divisor);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public static int size(TemporalAmount interval, TemporalUnit unit) {
		return size(value(interval), value(unit.getDuration()));
	}

	public static int size(TemporalAmount interval, TemporalAmount period) {
		return size(value(interval), value(period));
	}

	public static int size(ReadableInterval<?> interval, TemporalUnit unit) {
		return size(interval.toDuration(), unit.getDuration());
	}

	public static int size(ReadableInterval<?> interval, TemporalAmount period) {
		return size(interval.toDuration(), period);
	}

	public static int idx(Instant base, Instant curr, TemporalUnit unit) {
		return size(Duration.between(base, curr), unit.getDuration());
	}

	public static int idx(Instant base, Instant curr, TemporalAmount period) {
		return size(Duration.between(base, curr), period);
	}

	public static int idx(LocalDateTime base, LocalDateTime curr, TemporalUnit unit) {
		return size(Duration.between(base, curr), unit.getDuration());
	}

	public static int idx(LocalDateTime base, LocalDateTime curr, TemporalAmount period) {
		return size(Duration.between(base, curr), period);
	}

	public static int idx(LocalDate base, LocalDate curr, TemporalUnit unit) {
		return size(Duration.between(base, curr), unit.getDuration());
	}

	public static int idx(LocalDate base, LocalDate curr, TemporalAmount period) {
		return size(Duration.between(base, curr), period);
	}

	public static int idx(LocalTime time, TemporalUnit unit) {
		return size(Duration.between(LocalTime.MIDNIGHT, time), unit.getDuration());
	}

	public static int idx(LocalTime time, TemporalAmount period) {
		return size(Duration.between(LocalTime.MIDNIGHT, time), period);
	}

	private static int size(long interval, long period) {
		return (int) (interval / period);
	}

	private static long value(TemporalAmount amount) {
		if(amount instanceof Duration) {
			return amount.get(ChronoUnit.SECONDS);
		} else {
			return amount.get(ChronoUnit.DAYS) * DateTimeConstants.SECONDS_PER_DAY;
		}
	}
}
