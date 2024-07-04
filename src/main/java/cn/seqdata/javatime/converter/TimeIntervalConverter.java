package cn.seqdata.javatime.converter;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import cn.seqdata.javatime.TimeInterval;

public class TimeIntervalConverter implements Converter<String, TimeInterval> {
	public static final TimeIntervalConverter INSTANCE = new TimeIntervalConverter(null);
	private final DateTimeFormatter formatter;

	public TimeIntervalConverter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public TimeInterval convert(@NonNull String source) {
		return Objects.isNull(formatter) ? TimeInterval.parse(source) : TimeInterval.parse(source, formatter);
	}
}
