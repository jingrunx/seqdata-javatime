package cn.seqdata.javatime;

import java.time.Duration;
import java.time.Period;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class JavaTimeFormatterTest {

	@Test
	public void testPeriodOf() {
		for(int year = 0; year < 3; year++) {
			for(int month = 0; month < 3; month++) {
				for(int day = 0; day < 3; day++) {
					Period period = Period.of(year, month, day);
					System.out.printf("%s\t%s\t%s%n", period,
						JavaTimeFormatter.formatPeriod(period),
						JavaTimeFormatter.formatPeriod(period, Locale.US));
				}
			}
		}
	}

	@Test
	public void testPeriod() {
		for(int i = 1; i <= 10000; i *= 10) {
			Period period = Period.ofDays(i);
			System.out.printf("%s\t%s\t%s%n", period,
				JavaTimeFormatter.formatPeriod(period),
				JavaTimeFormatter.formatPeriod(period, Locale.US));
		}
	}

	@Test
	public void testDuration() {
		for(int i = 1; i <= 10000000; i *= 10) {
			Duration duration = Duration.ofSeconds(i);
			System.out.printf("%s\t%s\t%s%n", duration,
				JavaTimeFormatter.formatDuration(duration),
				JavaTimeFormatter.formatDuration(duration, Locale.US));
		}
	}
}
