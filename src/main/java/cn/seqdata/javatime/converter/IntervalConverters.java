package cn.seqdata.javatime.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

public abstract class IntervalConverters {

	public static Collection<Converter<?, ?>> getConvertersToRegister() {
		List<Converter<?, ?>> converters = new ArrayList<>();

		converters.add(InstantIntervalConverter.INSTANCE);
		converters.add(DateTimeIntervalConverter.INSTANCE);
		converters.add(DateIntervalConverter.INSTANCE);
		converters.add(TimeIntervalConverter.INSTANCE);

		return converters;
	}
}
