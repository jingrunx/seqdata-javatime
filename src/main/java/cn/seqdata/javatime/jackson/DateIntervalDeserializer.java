package cn.seqdata.javatime.jackson;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import cn.seqdata.javatime.DateInterval;

public class DateIntervalDeserializer extends StdDeserializer<DateInterval> {
	public static final DateIntervalDeserializer INSTANCE = new DateIntervalDeserializer(null);
	private final DateTimeFormatter formatter;

	public DateIntervalDeserializer(DateTimeFormatter formatter) {
		super(DateInterval.class);
		this.formatter = formatter;
	}

	@Override
	public DateInterval deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
		return Objects.isNull(formatter) ? DateInterval.parse(p.getText()) : DateInterval.parse(p.getText(), formatter);
	}
}
