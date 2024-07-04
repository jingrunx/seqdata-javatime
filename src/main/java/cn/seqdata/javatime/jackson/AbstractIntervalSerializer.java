package cn.seqdata.javatime.jackson;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import cn.seqdata.javatime.ReadableInterval;

public class AbstractIntervalSerializer<T extends ReadableInterval<?>> extends StdSerializer<T> {
	protected final DateTimeFormatter formatter;

	protected AbstractIntervalSerializer(Class<T> clazz, DateTimeFormatter formatter) {
		super(clazz);
		this.formatter = formatter;
	}

	@Override
	public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if(Objects.nonNull(value)) {
			if(Objects.isNull(formatter)) {
				gen.writeString(value.toString());
			} else {
				gen.writeString(value.toString(formatter));
			}
		} else {
			gen.writeNull();
		}
	}
}
