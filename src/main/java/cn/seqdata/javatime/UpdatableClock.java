package cn.seqdata.javatime;

import java.io.Serializable;
import java.time.*;

public class UpdatableClock extends Clock implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final UpdatableClock GLOBAL = new UpdatableClock();

	private long epochMilli;

	public UpdatableClock() {
	}

	public UpdatableClock(long epochMilli) {
		millis(epochMilli);
	}

	public UpdatableClock(LocalDate date) {
		date(date);
	}

	public UpdatableClock(LocalDateTime datetime) {
		datetime(datetime);
	}

	@Override
	public ZoneId getZone() {
		return ZoneId.systemDefault();
	}

	@Override
	public Clock withZone(ZoneId zone) {
		return this;
	}

	@Override
	public Instant instant() {
		return Instant.ofEpochMilli(epochMilli);
	}

	@Override
	public long millis() {
		return epochMilli;
	}

	public void millis(long epochMilli) {
		this.epochMilli = epochMilli;
	}

	public void date(LocalDate date) {
		this.epochMilli = JavaTimeUtils.toEpochMilli(date);
	}

	public void datetime(LocalDateTime datetime) {
		this.epochMilli = JavaTimeUtils.toEpochMilli(datetime);
	}

	public void roll(long amount) {
		epochMilli += amount;
	}

	public void roll(Duration duration) {
		roll(duration.toMillis());
	}

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(!(object instanceof UpdatableClock)) return false;
		UpdatableClock that = (UpdatableClock) object;
		return epochMilli == that.epochMilli;
	}

	@Override
	public int hashCode() {
		return Long.hashCode(epochMilli);
	}
}
