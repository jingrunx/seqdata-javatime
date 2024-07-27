package cn.seqdata.javatime.converter;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import cn.seqdata.javatime.DateInterval;

public class DateIntervalConverter implements Converter<String, DateInterval> {
	public static final DateIntervalConverter INSTANCE = new DateIntervalConverter(null);
	private final DateTimeFormatter formatter;

	public DateIntervalConverter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public DateInterval convert(@NonNull String source) {
		return Objects.isNull(formatter) ? DateInterval.parse(source) : DateInterval.parse(source, formatter);
	}
}
