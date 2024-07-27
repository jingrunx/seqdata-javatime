package cn.seqdata.javatime.jackson;

import java.time.format.DateTimeFormatter;

import cn.seqdata.javatime.TimeInterval;

public class TimeIntervalSerializer extends AbstractIntervalSerializer<TimeInterval> {
	public static final TimeIntervalSerializer INSTANCE = new TimeIntervalSerializer(null);

	public TimeIntervalSerializer(DateTimeFormatter formatter) {
		super(TimeInterval.class, formatter);
	}
}
