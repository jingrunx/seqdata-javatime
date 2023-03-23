package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

public class TemporalUtilsTest {

	@Test
	public void testDateSize() {
		DateInterval interval = new DateInterval(LocalDate.now(), Period.ofMonths(1));
		System.out.println(TemporalUtils.size(interval, ChronoUnit.DAYS));
	}
}
