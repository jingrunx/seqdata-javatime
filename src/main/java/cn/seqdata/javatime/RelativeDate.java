package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.UnaryOperator;

public enum RelativeDate {
	/**
	 * 今天
	 */
	today(ChronoUnit.DAYS, UnaryOperator.identity()),
	/**
	 * 昨天
	 */
	yesterday(ChronoUnit.DAYS, DateUtils::minusDay),
	/**
	 * 明天
	 */
	tomorrow(ChronoUnit.DAYS, DateUtils::plusDay),
	/**
	 * 本周
	 */
	theWeek(ChronoUnit.WEEKS, DateUtils::startOfWeek),
	/**
	 * 上周
	 */
	lastWeek(ChronoUnit.WEEKS, date -> DateUtils.minusWeek(DateUtils.startOfWeek(date))),
	/**
	 * 下周
	 */
	nextWeek(ChronoUnit.WEEKS, date -> DateUtils.plusWeek(DateUtils.startOfWeek(date))),
	/**
	 * 本月
	 */
	theMonth(ChronoUnit.MONTHS, DateUtils::startOfMonth),
	/**
	 * 上月
	 */
	lastMonth(ChronoUnit.MONTHS, date -> DateUtils.minusMonth(DateUtils.startOfMonth(date))),
	/**
	 * 下月
	 */
	nextMonth(ChronoUnit.MONTHS, date -> DateUtils.plusMonth(DateUtils.startOfMonth(date))),
	/**
	 * 今年
	 */
	theYear(ChronoUnit.YEARS, DateUtils::startOfYear),
	/**
	 * 去年
	 */
	lastYear(ChronoUnit.YEARS, date -> DateUtils.minusYear(DateUtils.startOfYear(date))),
	/**
	 * 明年
	 */
	nextYear(ChronoUnit.YEARS, date -> DateUtils.plusYear(DateUtils.startOfYear(date)));

	public final ChronoUnit unit;
	public final UnaryOperator<LocalDate> adjust;

	RelativeDate(ChronoUnit unit, UnaryOperator<LocalDate> adjust) {
		this.unit = unit;
		this.adjust = adjust;
	}

	public DateInterval toInterval(LocalDate date) {
		return new DateInterval(adjust.apply(date), unit);
	}
}
