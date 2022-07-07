package cn.seqdata.javatime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author jingr
 * @date 2022-06-08 20:38
 */
public class JavaTimeTest {

	@Test
	public void testDate() {
		Date date = new Date();

		System.out.println(JavaTimeUtils.toInstant(date));
		System.out.println(JavaTimeUtils.toOffsetDateTime(date));
		System.out.println(JavaTimeUtils.toZonedDateTime(date));
		System.out.println(JavaTimeUtils.toLocalDateTime(date));
		System.out.println(JavaTimeUtils.toLocalDate(date));
		System.out.println(JavaTimeUtils.toLocalTime(date));
	}

	@Test
	public void testInstant() {
		Instant instant = Instant.now();

		System.out.println(JavaTimeUtils.toTimestamp(instant));
		System.out.println(JavaTimeUtils.toOffsetDateTime(instant));
		System.out.println(JavaTimeUtils.toZonedDateTime(instant));
		System.out.println(JavaTimeUtils.toLocalDateTime(instant));
		System.out.println(JavaTimeUtils.toLocalDate(instant));
		System.out.println(JavaTimeUtils.toLocalTime(instant));
	}

	@Test
	public void testGetFields() {
		LocalDateTime ldt = LocalDateTime.now();

		for(ChronoField field : ChronoField.values()) {
			try {
				System.out.println(field.name() + ": " + ldt.getLong(field));
			} catch(RuntimeException ignored) {
			}
		}
	}

	@Test
	public void testTruncated() {
		LocalDateTime ldt = LocalDateTime.now();

		for(ChronoUnit unit : ChronoUnit.values()) {
			try {
				System.out.println(unit.name() + ": " + ldt.truncatedTo(unit));
			} catch(RuntimeException ignored) {
			}
		}
	}

	@Test
	public void testInterval() {
		LocalTime t0 = LocalTime.MIDNIGHT;
		LocalTime t1 = LocalTime.of(6, 0);
		LocalTime t2 = LocalTime.of(11, 59);
		LocalTime t3 = LocalTime.of(12, 0);
		LocalTime t4 = LocalTime.of(12, 1);
		LocalTime t5 = LocalTime.of(18, 0);

		TimeInterval i01 = new TimeInterval(t0, t1);
		TimeInterval i04 = new TimeInterval(t0, t4);
		TimeInterval i12 = new TimeInterval(t1, t2);
		TimeInterval i23 = new TimeInterval(t2, t3);
		TimeInterval i34 = new TimeInterval(t3, t4);

		System.out.println(i04.contains(t1));
		System.out.println(i04.contains(i12));
		System.out.println(i04.overlap(i12));
	}

	@Test
	public void testDateInterval() {
		LocalDate start = LocalDate.now();
		LocalDate end = start.plusDays(55);
		DateInterval interval = new DateInterval(start, end);
		System.out.println(interval);
		System.out.println(interval.toDateTimeInterval());
		System.out.println(interval.toPeriod());
	}

	@Test
	public void testTimeInterval() {
		LocalTime start = LocalTime.MIDNIGHT;
		LocalTime end = start.plusMinutes(90);
		TimeInterval interval = new TimeInterval(start, end);
		System.out.println(interval);
		System.out.println(interval.toDateTimeInterval(LocalDate.now()));
		System.out.println(interval.toDuration());
	}

	@Test
	public void testDateUnit() {
		LocalDate date = LocalDate.now();

		for(DateUnit value : DateUnit.values()) {
			System.out.println(value.toInterval(date));
		}
	}

	@Test
	public void testDuration() {
		System.out.println(Duration.ZERO);
		Instant instant = Instant.now();
		Year year = Year.of(1999);
		LocalDate date = LocalDate.of(2001, 2, 3);
		LocalDateTime ldt = LocalDateTime.of(2000, 1, 2, 12, 34, 56);
		System.out.println(year.adjustInto(ldt));
	}

	@Test
	public void testDateUtils() {
		LocalDate date = LocalDate.now();

		System.out.println(DateUtils.startOfWeek(date));
		System.out.println(DateUtils.endOfWeek(date));

		System.out.println(DateUtils.startOfMonth(date));
		System.out.println(DateUtils.endOfMonth(date));

		System.out.println(DateUtils.startOfYear(date));
		System.out.println(DateUtils.endOfYear(date));
	}
}
