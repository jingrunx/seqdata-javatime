package cn.seqdata.javatime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public final class DateUtils {
	private DateUtils() {
	}

	public static LocalDate defaultOfNow(LocalDate date) {
		return Optional.ofNullable(date)
			.orElse(LocalDate.now());
	}

	public static LocalDate defaultOfYesterday(LocalDate date) {
		return Optional.ofNullable(date)
			.orElse(minusDay(LocalDate.now()));
	}

	public static LocalDate startOfWeek(LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return minusDays(date, dayOfWeek.getValue());
	}

	public static LocalDate endOfWeek(LocalDate date) {
		return minusDay(plusWeek(startOfWeek(date)));
	}

	public static LocalDate startOfMonth(LocalDate date) {
		return date.withDayOfMonth(1);
	}

	public static LocalDate endOfMonth(LocalDate date) {
		return minusDay(plusMonth(startOfMonth(date)));
	}

	public static LocalDate startOfYear(LocalDate date) {
		return date.withDayOfYear(1);
	}

	public static LocalDate endOfYear(LocalDate date) {
		return minusDay(plusYear(startOfYear(date)));
	}

	public static LocalDate plus(LocalDate date, TemporalAmount amount) {
		return date.plus(amount);
	}

	public static LocalDate minus(LocalDate date, TemporalAmount amount) {
		return date.minus(amount);
	}

	public static LocalDate plus(LocalDate date, int amount, TemporalUnit unit) {
		return date.plus(amount, unit);
	}

	public static LocalDate minus(LocalDate date, int amount, TemporalUnit unit) {
		return date.minus(amount, unit);
	}

	//days
	public static LocalDate plusDay(LocalDate date) {
		return plusDays(date, 1);
	}

	public static LocalDate plusDays(LocalDate date, int amount) {
		return plus(date, amount, ChronoUnit.DAYS);
	}

	public static LocalDate minusDay(LocalDate date) {
		return minusDays(date, 1);
	}

	public static LocalDate minusDays(LocalDate date, int amount) {
		return minus(date, amount, ChronoUnit.DAYS);
	}

	//weeks
	public static LocalDate plusWeek(LocalDate date) {
		return plusWeeks(date, 1);
	}

	public static LocalDate plusWeeks(LocalDate date, int amount) {
		return plus(date, amount, ChronoUnit.WEEKS);
	}

	public static LocalDate minusWeek(LocalDate date) {
		return minusWeeks(date, 1);
	}

	public static LocalDate minusWeeks(LocalDate date, int amount) {
		return minus(date, amount, ChronoUnit.WEEKS);
	}

	//month
	public static LocalDate plusMonth(LocalDate date) {
		return plusMonths(date, 1);
	}

	public static LocalDate plusMonths(LocalDate date, int amount) {
		return plus(date, amount, ChronoUnit.MONTHS);
	}

	public static LocalDate minusMonth(LocalDate date) {
		return minusMonths(date, 1);
	}

	public static LocalDate minusMonths(LocalDate date, int amount) {
		return minus(date, amount, ChronoUnit.MONTHS);
	}

	//year
	public static LocalDate plusYear(LocalDate date) {
		return plusYears(date, 1);
	}

	public static LocalDate plusYears(LocalDate date, int amount) {
		return plus(date, amount, ChronoUnit.YEARS);
	}

	public static LocalDate minusYear(LocalDate date) {
		return minusYears(date, 1);
	}

	public static LocalDate minusYears(LocalDate date, int amount) {
		return minus(date, amount, ChronoUnit.YEARS);
	}
}
