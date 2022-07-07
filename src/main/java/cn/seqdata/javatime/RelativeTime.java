package cn.seqdata.javatime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public enum RelativeTime {
	/**
	 * 最新
	 */
	pt0s(Duration.ZERO) {
		@Override
		public DateTimeInterval toInterval(LocalDateTime occur) {
			return new DateTimeInterval(occur, occur);
		}
	},
	/**
	 * 近1分钟
	 */
	pt1m(ChronoUnit.MINUTES),
	/**
	 * 近5分钟
	 */
	pt5m(Duration.ofMinutes(5)),
	/**
	 * 近15分钟
	 */
	pt15m(Duration.ofHours(15)),
	/**
	 * 近30分钟
	 */
	pt30m(Duration.ofMinutes(30)),
	/**
	 * 近1小时
	 */
	pt1h(ChronoUnit.HOURS),
	/**
	 * 近4小时
	 */
	pt4h(Duration.ofHours(4)),
	/**
	 * 近8小时
	 */
	pt8h(Duration.ofHours(8)),
	/**
	 * 近12小时
	 */
	pt12h(ChronoUnit.HALF_DAYS),
	/**
	 * 近1天
	 */
	p1d(ChronoUnit.DAYS),
	/**
	 * 近3天
	 */
	p3d(Period.ofDays(3)),
	/**
	 * 近1周
	 */
	p1w(ChronoUnit.WEEKS),
	/**
	 * 近2周
	 */
	p2w(Period.ofWeeks(2)),
	/**
	 * 近1个月
	 */
	p1m(ChronoUnit.MONTHS),
	/**
	 * 近3个月
	 */
	p3m(Period.ofMonths(3)),
	/**
	 * 近6月
	 */
	p6m(Period.ofMonths(6)),
	/**
	 * 近1年
	 */
	p1y(ChronoUnit.YEARS),
	/**
	 * 近2年
	 */
	p2y(Period.ofYears(2)),
	/**
	 * 近5年
	 */
	p5y(Period.ofYears(5)),
	/**
	 * 近10年
	 */
	p10y(Period.ofYears(10));

	public final TemporalAmount period;

	RelativeTime(TemporalAmount period) {
		this.period = period;
	}

	RelativeTime(TemporalUnit unit) {
		this.period = unit.getDuration();
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
