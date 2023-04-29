package cn.seqdata.javatime;

import java.time.format.DateTimeFormatter;

public interface JavaTimeFormatter {
	String DATE_PATTERN = "yyyy-MM-dd";
	String TIME_PATTERN = "HH:mm:ss";
	String DATE_TIME_PATTERN = DATE_PATTERN + ' ' + TIME_PATTERN;

	DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
	DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
}
