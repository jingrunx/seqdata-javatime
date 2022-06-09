package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public enum DateUnit {
	DAYS("Days", ChronoUnit.DAYS) {
		@Override
		public DateInterval toInterval(LocalDate date) {
			return new DateInterval(date, Period.ofDays(1));
		}
	},

	WEEKS("Weeks", ChronoUnit.WEEKS) {
		@Override
		public DateInterval toInterval(LocalDate date) {
			return new DateInterval(DateUtils.startOfWeek(date), Period.ofWeeks(1));
		}
	},

	MONTHS("Months", ChronoUnit.MONTHS) {
		@Override
		public DateInterval toInterval(LocalDate date) {
			return new DateInterval(DateUtils.startOfMonth(date), Period.ofMonths(1));
		}
	},

	YEARS("Years", ChronoUnit.YEARS) {
		@Override
		public DateInterval toInterval(LocalDate date) {
			return new DateInterval(DateUtils.startOfYear(date), Period.ofYears(1));
		}
	};

	public final String name;
	public final ChronoUnit unit;

	DateUnit(String name, ChronoUnit unit) {
		this.name = name;
		this.unit = unit;
	}

	public abstract DateInterval toInterval(LocalDate date);

	public static DateUnit valueOf(ChronoUnit unit) {
		for(DateUnit value : values()) {
			if(unit == value.unit) {
				return value;
			}
		}

		return null;
	}
}
