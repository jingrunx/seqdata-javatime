package cn.seqdata.javatime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;

public enum RelativeTime {
	/**
	 * 最新
	 */
	PT0S(Duration.ZERO) {
		@Override
		public DateTimeInterval toInterval(LocalDateTime occur) {
			return new DateTimeInterval(occur, occur);
		}
	},
	/**
	 * 近1分钟
	 */
	PT1M(Duration.ofMinutes(1)),
	/**
	 * 近5分钟
	 */
	PT5M(Duration.ofMinutes(5)),
	/**
	 * 近15分钟
	 */
	PT15M(Duration.ofMinutes(15)),
	/**
	 * 近30分钟
	 */
	PT30M(Duration.ofMinutes(30)),
	/**
	 * 近1小时
	 */
	PT1H(Duration.ofHours(1)),
	/**
	 * 近2小时
	 */
	PT2H(Duration.ofHours(2)),
	/**
	 * 近3小时
	 */
	PT3H(Duration.ofHours(3)),
	/**
	 * 近4小时
	 */
	PT4H(Duration.ofHours(4)),
	/**
	 * 近6小时
	 */
	PT6H(Duration.ofHours(6)),
	/**
	 * 近8小时
	 */
	PT8H(Duration.ofHours(8)),
	/**
	 * 近12小时
	 */
	PT12H(Duration.ofHours(12)),
	/**
	 * 近24小时
	 */
	PT24H(Duration.ofHours(24)),
	/**
	 * 近1天
	 */
	P1D(Period.ofDays(1)),
	/**
	 * 近3天
	 */
	P3D(Period.ofDays(3)),
	/**
	 * 近1周
	 */
	P1W(Period.ofWeeks(1)),
	/**
	 * 近2周
	 */
	P2W(Period.ofWeeks(2)),
	/**
	 * 近1个月
	 */
	P1M(Period.ofMonths(1)),
	/**
	 * 近2个月
	 */
	P2M(Period.ofMonths(2)),
	/**
	 * 近3个月
	 */
	P3M(Period.ofMonths(3)),
	/**
	 * 近6月
	 */
	P6M(Period.ofMonths(6)),
	/**
	 * 近1年
	 */
	P1Y(Period.ofYears(1)),
	/**
	 * 近2年
	 */
	P2Y(Period.ofYears(2)),
	/**
	 * 近5年
	 */
	P5Y(Period.ofYears(5)),
	/**
	 * 近10年
	 */
	P10Y(Period.ofYears(10));

	public final TemporalAmount period;

	RelativeTime(TemporalAmount period) {
		this.period = period;
	}

	public DateTimeInterval toInterval() {
		return toInterval(LocalDateTime.now());
	}

	public DateTimeInterval toInterval(LocalDateTime occur) {
		return new DateTimeInterval(period, occur);
	}

	public DateTimeInterval toInterval(LocalDate date) {
		//截至时间为24:00
		return new DateTimeInterval(period, JavaTimeUtils.toLocalDateTime(date.plusDays(1)));
	}
}
