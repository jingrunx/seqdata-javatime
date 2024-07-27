package cn.seqdata.javatime.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import cn.seqdata.javatime.InstantInterval;

public class InstantIntervalDeserializer extends StdDeserializer<InstantInterval> {
	public static final InstantIntervalDeserializer INSTANCE = new InstantIntervalDeserializer();

	public InstantIntervalDeserializer() {
		super(InstantInterval.class);
	}

	@Override
	public InstantInterval deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
		return InstantInterval.parse(p.getText());
	}
}
