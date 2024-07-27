package cn.seqdata.javatime.jackson;

import java.time.format.DateTimeFormatter;

import cn.seqdata.javatime.InstantInterval;

public class InstantIntervalSerializer extends AbstractIntervalSerializer<InstantInterval> {
	public static final InstantIntervalSerializer INSTANCE = new InstantIntervalSerializer(null);

	public InstantIntervalSerializer(DateTimeFormatter formatter) {
		super(InstantInterval.class, formatter);
	}
}
