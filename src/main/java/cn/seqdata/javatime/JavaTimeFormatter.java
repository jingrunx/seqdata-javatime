package cn.seqdata.javatime;

import java.time.format.DateTimeFormatter;

public interface JavaTimeFormatter {
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String DATE_TIME_PATTERN = DATE_PATTERN + ' ' + TIME_PATTERN;

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
}
