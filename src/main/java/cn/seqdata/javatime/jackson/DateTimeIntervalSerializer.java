package cn.seqdata.javatime.jackson;

import java.time.format.DateTimeFormatter;

import cn.seqdata.javatime.DateTimeInterval;

public class DateTimeIntervalSerializer extends AbstractIntervalSerializer<DateTimeInterval> {
	public static final DateTimeIntervalSerializer INSTANCE = new DateTimeIntervalSerializer(null);

	public DateTimeIntervalSerializer(DateTimeFormatter formatter) {
		super(DateTimeInterval.class, formatter);
	}
}
