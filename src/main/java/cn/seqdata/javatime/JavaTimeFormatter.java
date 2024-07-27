package cn.seqdata.javatime;

import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public abstract class JavaTimeFormatter {
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String HOUR_MINUTE_PATTERN = "HH:mm";
	public static final String DATE_TIME_PATTERN = DATE_PATTERN + ' ' + TIME_PATTERN;

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
	public static final DateTimeFormatter HOUR_MINUTE_FORMATTER = DateTimeFormatter.ofPattern(HOUR_MINUTE_PATTERN);

	private static final String[] ENG_UNITS = {" years ", " months ", " days ", " hours ", " minutes ", " seconds "};
	private static final String[] CHS_UNITS = {"年", "月", "天", "小时", "分钟", "秒"};
	private static final Map<Locale, String[]> UNITS = Map.of(
		Locale.ENGLISH, ENG_UNITS, Locale.SIMPLIFIED_CHINESE, CHS_UNITS);

	public static String formatPeriod(Period period) {
		return formatPeriod(period, Locale.getDefault());
	}

	public static String formatPeriod(Period period, Locale locale) {
		int[] amounts = new int[6];

		amounts[0] = period.getYears();
		amounts[1] = period.getMonths();
		amounts[2] = period.getDays();

		return formatTemporalAmount(amounts, locale);
	}

	public static String formatDuration(Duration duration) {
		return formatDuration(duration, Locale.getDefault());
	}

	public static String formatDuration(Duration duration, Locale locale) {
		int[] amounts = new int[6];

		amounts[2] = (int) duration.toDaysPart();
		amounts[3] = duration.toHoursPart();
		amounts[4] = duration.toMinutesPart();
		amounts[5] = duration.toSecondsPart();

		return formatTemporalAmount(amounts, locale);
	}

	private static String formatTemporalAmount(int[] amounts, Locale locale) {
		StringBuilder builder = new StringBuilder();

		String[] units = UNITS.getOrDefault(locale, ENG_UNITS);
		for(int i = 0; i < amounts.length; i++) {
			if(amounts[i] != 0) {
				builder.append(amounts[i]);
				builder.append(units[i]);
			}
		}

		return builder.toString();
	}
}
