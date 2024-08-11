package cn.seqdata.javatime;

import java.time.Duration;
import java.time.Instant;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import cn.seqdata.javatime.jackson.IntervalModule;

public class JacksonTest {
	private static ObjectMapper mapper;

	@BeforeAll
	public static void init() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.registerModule(new IntervalModule());
	}

	@Test
	public void testToString() {
		System.out.println(new InstantInterval(Instant.now(), ChronoUnit.DAYS));
		System.out.println(DateTimeInterval.from(Year.of(2024)));
		System.out.println(DateInterval.from(Year.of(2024)));
		System.out.println(TimeInterval.AM);
		System.out.println(TimeInterval.PM);
		System.out.println(TimeInterval.ALL_DAY);
	}

	@Test
	public void testParse() {
		System.out.println(InstantInterval.parse("2024-07-04T06:00:00Z~2024-07-05T06:00:00Z"));

		System.out.println(DateTimeInterval.parse("2024-07-04T06:00~2024-07-05T06:00"));
		System.out.println(DateTimeInterval.parse("2024-07-04T06:00~"));
		System.out.println(DateTimeInterval.parse("~2024-07-05T06:00"));
		System.out.println(DateTimeInterval.parse("MIN~MAX"));
		System.out.println(DateInterval.parse("2024-07-04~2024-07-05"));
		System.out.println(DateInterval.parse("~2024-07-04"));
		System.out.println(DateInterval.parse("2024-07-04~"));
		System.out.println(DateInterval.parse("~"));
		System.out.println(TimeInterval.parse("06:00~07:00"));
		System.out.println(TimeInterval.parse("06:00~24:00"));
		System.out.println(TimeInterval.parse("NOON~MAX"));
		System.out.println(TimeInterval.parse("~"));
	}

	@Test
	public void testJson() throws JsonProcessingException {
//		Duration duration = mapper.readValue("PT12H", Duration.class);
		System.out.println(mapper.writeValueAsString(Duration.ofHours(12)));
	}
}
