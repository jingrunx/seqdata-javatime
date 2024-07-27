package cn.seqdata.javatime.jackson;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import cn.seqdata.javatime.DateInterval;
import cn.seqdata.javatime.TimeInterval;

public class TimeIntervalDeserializer extends StdDeserializer<TimeInterval> {
	public static final TimeIntervalDeserializer INSTANCE = new TimeIntervalDeserializer(null);
	private final DateTimeFormatter formatter;

	public TimeIntervalDeserializer(DateTimeFormatter formatter) {
		super(DateInterval.class);
		this.formatter = formatter;
	}

	@Override
	public TimeInterval deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
		return Objects.isNull(formatter) ? TimeInterval.parse(p.getText()) : TimeInterval.parse(p.getText(), formatter);
	}
}
