package cn.seqdata.javatime.jackson;

import java.time.format.DateTimeFormatter;

import cn.seqdata.javatime.DateInterval;

public class DateIntervalSerializer extends AbstractIntervalSerializer<DateInterval> {
	public static final DateIntervalSerializer INSTANCE = new DateIntervalSerializer(null);

	public DateIntervalSerializer(DateTimeFormatter formatter) {
		super(DateInterval.class, formatter);
	}
}
