package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.UnaryOperator;

public enum RelativeDate {
	/**
	 * 今天
	 */
	TODAY(ChronoUnit.DAYS, UnaryOperator.identity()),
	/**
	 * 昨天
	 */
	YESTERDAY(ChronoUnit.DAYS, DateUtils::minusDay),
	/**
	 * 明天
	 */
	TOMORROW(ChronoUnit.DAYS, DateUtils::plusDay),
	/**
	 * 本周
	 */
	THE_WEEK(ChronoUnit.WEEKS, DateUtils::startOfWeek),
	/**
	 * 上周
	 */
	LAST_WEEK(ChronoUnit.WEEKS, date -> DateUtils.minusWeek(DateUtils.startOfWeek(date))),
	/**
	 * 下周
	 */
	NEXT_WEEK(ChronoUnit.WEEKS, date -> DateUtils.plusWeek(DateUtils.startOfWeek(date))),
	/**
	 * 本月
	 */
	THE_MONTH(ChronoUnit.MONTHS, DateUtils::startOfMonth),
	/**
	 * 上月
	 */
	LAST_MONTH(ChronoUnit.MONTHS, date -> DateUtils.minusMonth(DateUtils.startOfMonth(date))),
	/**
	 * 下月
	 */
	NEXT_MONTH(ChronoUnit.MONTHS, date -> DateUtils.plusMonth(DateUtils.startOfMonth(date))),
	/**
	 * 今年
	 */
	THE_YEAR(ChronoUnit.YEARS, DateUtils::startOfYear),
	/**
	 * 去年
	 */
	LAST_YEAR(ChronoUnit.YEARS, date -> DateUtils.minusYear(DateUtils.startOfYear(date))),
	/**
	 * 明年
	 */
	NEXT_YEAR(ChronoUnit.YEARS, date -> DateUtils.plusYear(DateUtils.startOfYear(date)));

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
