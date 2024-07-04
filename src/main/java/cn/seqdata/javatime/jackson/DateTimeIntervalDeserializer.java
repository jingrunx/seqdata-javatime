package cn.seqdata.javatime.jackson;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import cn.seqdata.javatime.DateInterval;
import cn.seqdata.javatime.DateTimeInterval;

public class DateTimeIntervalDeserializer extends StdDeserializer<DateTimeInterval> {
	public static final DateTimeIntervalDeserializer INSTANCE = new DateTimeIntervalDeserializer(null);
	private final DateTimeFormatter formatter;

	public DateTimeIntervalDeserializer(DateTimeFormatter formatter) {
		super(DateInterval.class);
		this.formatter = formatter;
	}

	@Override
	public DateTimeInterval deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
		return Objects.isNull(formatter) ? DateTimeInterval.parse(p.getText()) : DateTimeInterval.parse(p.getText(), formatter);
	}
}
