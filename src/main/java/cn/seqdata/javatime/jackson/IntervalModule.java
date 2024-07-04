package cn.seqdata.javatime.jackson;

import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

import cn.seqdata.javatime.DateInterval;
import cn.seqdata.javatime.DateTimeInterval;
import cn.seqdata.javatime.InstantInterval;
import cn.seqdata.javatime.TimeInterval;

public class IntervalModule extends SimpleModule {

	public IntervalModule() {
		super(PackageVersion.VERSION);
	}

	@Override
	public void setupModule(Module.SetupContext context) {
		super.setupModule(context);

		SimpleSerializers serializers = new SimpleSerializers();
		serializers.addSerializer(InstantInterval.class, InstantIntervalSerializer.INSTANCE);
		serializers.addSerializer(DateTimeInterval.class, DateTimeIntervalSerializer.INSTANCE);
		serializers.addSerializer(DateInterval.class, DateIntervalSerializer.INSTANCE);
		serializers.addSerializer(TimeInterval.class, TimeIntervalSerializer.INSTANCE);
		context.addSerializers(serializers);

		SimpleDeserializers deserializers = new SimpleDeserializers();
		deserializers.addDeserializer(InstantInterval.class, InstantIntervalDeserializer.INSTANCE);
		deserializers.addDeserializer(DateTimeInterval.class, DateTimeIntervalDeserializer.INSTANCE);
		deserializers.addDeserializer(DateInterval.class, DateIntervalDeserializer.INSTANCE);
		deserializers.addDeserializer(TimeInterval.class, TimeIntervalDeserializer.INSTANCE);
		context.addDeserializers(deserializers);
	}
}
