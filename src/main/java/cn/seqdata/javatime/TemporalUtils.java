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
		return size(seconds(interval), seconds(unit.getDuration()));
	}

	public static int size(TemporalAmount interval, TemporalAmount period) {
		return size(seconds(interval), seconds(period));
	}

	public static int size(ReadableInterval<?> interval, TemporalUnit unit) {
		return size(interval.toDuration(), unit.getDuration());
	}

	public static int size(ReadableInterval<?> interval, TemporalAmount period) {
		return size(interval.toDuration(), period);
	}

	public static int idx(Instant base, Instant curr, TemporalUnit unit) {
		return size(new InstantInterval(base, curr), unit.getDuration());
	}

	public static int idx(Instant base, Instant curr, TemporalAmount period) {
		return size(new InstantInterval(base, curr), period);
	}

	public static int idx(LocalDateTime base, LocalDateTime curr, TemporalUnit unit) {
		return size(new DateTimeInterval(base, curr), unit.getDuration());
	}

	public static int idx(LocalDateTime base, LocalDateTime curr, TemporalAmount period) {
		return size(new DateTimeInterval(base, curr), period);
	}

	public static int idx(LocalDate base, LocalDate curr, TemporalUnit unit) {
		return size(new DateInterval(base, curr), unit.getDuration());
	}

	public static int idx(LocalDate base, LocalDate curr, TemporalAmount period) {
		return size(new DateInterval(base, curr), period);
	}

	public static int idx(LocalTime time, TemporalUnit unit) {
		return size(new TimeInterval(LocalTime.MIDNIGHT, time), unit.getDuration());
	}

	public static int idx(LocalTime time, TemporalAmount period) {
		return size(new TimeInterval(LocalTime.MIDNIGHT, time), period);
	}

	public static long seconds(TemporalAmount value) {
		if(value instanceof Duration) {
			return value.get(ChronoUnit.SECONDS);
		} else if(value instanceof ChronoPeriod) {
			return value.get(ChronoUnit.DAYS) * DateTimeConstants.SECONDS_PER_DAY;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	private static int size(long interval, long period) {
		return (int) (interval / period);
	}
}
