package cn.seqdata.javatime.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import cn.seqdata.javatime.InstantInterval;

public class InstantIntervalConverter implements Converter<String, InstantInterval> {
	public static final InstantIntervalConverter INSTANCE = new InstantIntervalConverter();

	@Override
	public InstantInterval convert(@NonNull String source) {
		return InstantInterval.parse(source);
	}
}
