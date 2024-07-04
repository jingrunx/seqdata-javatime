package cn.seqdata.javatime.converter;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import cn.seqdata.javatime.DateTimeInterval;

public class DateTimeIntervalConverter implements Converter<String, DateTimeInterval> {
	public static final DateTimeIntervalConverter INSTANCE = new DateTimeIntervalConverter(null);
	private final DateTimeFormatter formatter;

	public DateTimeIntervalConverter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public DateTimeInterval convert(@NonNull String source) {
		return Objects.isNull(formatter) ? DateTimeInterval.parse(source) : DateTimeInterval.parse(source, formatter);
	}
}
