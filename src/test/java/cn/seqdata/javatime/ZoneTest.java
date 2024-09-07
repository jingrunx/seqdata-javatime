package cn.seqdata.javatime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TimeZone;

public class ZoneTest {
	public static void main(String[] args) {
		ZoneId local = ZoneId.of("US/Central");
		ZoneId gmt = ZoneId.of("GMT");
		TimeZone.setDefault(TimeZone.getTimeZone(local));

		DateTimeInterval interval = DateTimeInterval.from(LocalDate.of(2014, 10, 1));
		System.out.println(interval);
		System.out.println(interval
			.toInstantInterval()
			.toDateTimeInterval(gmt));
		System.out.println(interval
			.toInstantInterval(gmt)
			.toDateTimeInterval());
	}
}
