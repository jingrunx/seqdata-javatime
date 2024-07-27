package cn.seqdata.javatime.converter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class IntervalFormatterRegistrar implements FormatterRegistrar {

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addConverter(InstantIntervalConverter.INSTANCE);
		registry.addConverter(DateTimeIntervalConverter.INSTANCE);
		registry.addConverter(DateIntervalConverter.INSTANCE);
		registry.addConverter(TimeIntervalConverter.INSTANCE);
	}
}
