package cn.seqdata.javatime;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

public final class JavaTimeUtils {
	private JavaTimeUtils() {
	}

	//epochMilli
	public static Instant toInstant(long epochMilli) {
		return map(epochMilli, Instant::ofEpochMilli);
	}

	public static OffsetDateTime toOffsetDateTime(long epochMilli) {
		return map(epochMilli, x -> OffsetDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
	}

	public static ZonedDateTime toZonedDateTime(long epochMilli) {
		return map(epochMilli, x -> ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
	}

	public static LocalDateTime toLocalDateTime(long epochMilli) {
		return map(epochMilli, x -> LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
	}

	public static LocalDate toLocalDate(long epochMilli) {
		return map(epochMilli, x -> toLocalDateTime(x).toLocalDate());
	}

	public static LocalTime toLocalTime(long epochMilli) {
		return map(epochMilli, x -> toLocalDateTime(x).toLocalTime());
	}

	//Date
	public static Instant toInstant(Date date) {
		return map(date, Date::toInstant);
	}

	public static OffsetDateTime toOffsetDateTime(Date date) {
		return map(date, x -> OffsetDateTime.ofInstant(x.toInstant(), ZoneId.systemDefault()));
	}

	public static ZonedDateTime toZonedDateTime(Date date) {
		return map(date, x -> ZonedDateTime.ofInstant(x.toInstant(), ZoneId.systemDefault()));
	}

	public static LocalDateTime toLocalDateTime(Date date) {
		return map(date, x -> LocalDateTime.ofInstant(x.toInstant(), ZoneId.systemDefault()));
	}

	public static LocalDate toLocalDate(Date date) {
		return map(date, x -> toLocalDateTime(x).toLocalDate());
	}

	public static LocalTime toLocalTime(Date date) {
		return map(date, x -> toLocalDateTime(x).toLocalTime());
	}

	public static LocalDateTime toLocalDateTime(java.sql.Timestamp timestamp) {
		return map(timestamp, java.sql.Timestamp::toLocalDateTime);
	}

	public static LocalDate toLocalDate(java.sql.Date date) {
		return map(date, java.sql.Date::toLocalDate);
	}

	public static LocalTime toLocalTime(java.sql.Time time) {
		return map(time, java.sql.Time::toLocalTime);
	}

	//Instant
	public static long toEpochMilli(Instant instant) {
		return instant.toEpochMilli();
	}

	public static Timestamp toTimestamp(Instant instant) {
		return map(instant, Timestamp::from);
	}

	public static OffsetDateTime toOffsetDateTime(Instant instant) {
		return map(instant, x -> OffsetDateTime.ofInstant(x, ZoneId.systemDefault()));
	}

	public static ZonedDateTime toZonedDateTime(Instant instant) {
		return map(instant, x -> ZonedDateTime.ofInstant(x, ZoneId.systemDefault()));
	}

	public static LocalDateTime toLocalDateTime(Instant instant) {
		return map(instant, x -> LocalDateTime.ofInstant(x, ZoneId.systemDefault()));
	}

	public static LocalDate toLocalDate(Instant instant) {
		return map(instant, x -> toLocalDateTime(x).toLocalDate());
	}

	public static LocalTime toLocalTime(Instant instant) {
		return map(instant, x -> toLocalDateTime(x).toLocalTime());
	}

	//OffsetDateTime
	public static long toEpochMilli(OffsetDateTime odt) {
		return toEpochMilli(toInstant(odt));
	}

	public static Instant toInstant(OffsetDateTime odt) {
		return map(odt, OffsetDateTime::toInstant);
	}

	public static ZonedDateTime toZonedDateTime(OffsetDateTime odt) {
		return map(odt, OffsetDateTime::toZonedDateTime);
	}

	public static LocalDateTime toLocalDateTime(OffsetDateTime odt) {
		return map(odt, OffsetDateTime::toLocalDateTime);
	}

	public static LocalDate toLocalDate(OffsetDateTime odt) {
		return map(odt, OffsetDateTime::toLocalDate);
	}

	public static LocalTime toLocalTime(OffsetDateTime odt) {
		return map(odt, OffsetDateTime::toLocalTime);
	}

	//LocalDateTime
	public static Timestamp toTimestamp(LocalDateTime ldt) {
		return map(ldt, Timestamp::valueOf);
	}

	public static long toEpochMilli(LocalDateTime ldt) {
		return toEpochMilli(toInstant(ldt));
	}

	public static Instant toInstant(LocalDateTime ldt) {
		return map(ldt, x -> toZonedDateTime(x).toInstant());
	}

	public static OffsetDateTime toOffsetDateTime(LocalDateTime ldt) {
		return map(ldt, x -> toZonedDateTime(x).toOffsetDateTime());
	}

	public static ZonedDateTime toZonedDateTime(LocalDateTime ldt) {
		return map(ldt, x -> x.atZone(ZoneId.systemDefault()));
	}

	public static LocalDate toLocalDate(LocalDateTime ldt) {
		return map(ldt, LocalDateTime::toLocalDate);
	}

	public static LocalTime toLocalTime(LocalDateTime ldt) {
		return map(ldt, LocalDateTime::toLocalTime);
	}

	//LocalDate
	public static java.sql.Date toDate(LocalDate date) {
		return map(date, java.sql.Date::valueOf);
	}

	public static long toEpochMilli(LocalDate date) {
		return toEpochMilli(toInstant(date));
	}

	public static Instant toInstant(LocalDate date) {
		return map(date, x -> toZonedDateTime(x).toInstant());
	}

	public static OffsetDateTime toOffsetDateTime(LocalDate date) {
		return map(date, x -> toZonedDateTime(x).toOffsetDateTime());
	}

	public static ZonedDateTime toZonedDateTime(LocalDate date) {
		return map(date, x -> ZonedDateTime.of(x, LocalTime.MIDNIGHT, ZoneId.systemDefault()));
	}

	public static LocalDateTime toLocalDateTime(LocalDate date) {
		return map(date, x -> x.atTime(LocalTime.MIDNIGHT));
	}

	//LocalTime
	public static Time toTime(LocalTime time) {
		return map(time, Time::valueOf);
	}

	public static long toEpochMilli(LocalTime time) {
		return time.toNanoOfDay() / 1_000_000L;
	}

	private static <T, R> R map(T value, Function<T, R> mapper) {
		return Objects.nonNull(value) ? mapper.apply(value) : null;
	}
}
