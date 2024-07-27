package cn.seqdata.javatime;

public final class DateTimeConstants {
	public static final int MILLIS_PER_SECOND = 1000;

	/**
	 * Seconds in one minute (60) (ISO)
	 */
	public static final int SECONDS_PER_MINUTE = 60;
	/**
	 * Milliseconds in one minute (ISO)
	 */
	public static final int MILLIS_PER_MINUTE = MILLIS_PER_SECOND * SECONDS_PER_MINUTE;

	/**
	 * Minutes in one hour (ISO)
	 */
	public static final int MINUTES_PER_HOUR = 60;
	/**
	 * Seconds in one hour (ISO)
	 */
	public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	/**
	 * Milliseconds in one hour (ISO)
	 */
	public static final int MILLIS_PER_HOUR = MILLIS_PER_MINUTE * MINUTES_PER_HOUR;

	/**
	 * Hours in a typical day (24) (ISO). Due to time zone offset changes, the
	 * number of hours per day can vary.
	 */
	public static final int HOURS_PER_DAY = 24;
	/**
	 * Minutes in a typical day (ISO). Due to time zone offset changes, the number
	 * of minutes per day can vary.
	 */
	public static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;
	/**
	 * Seconds in a typical day (ISO). Due to time zone offset changes, the number
	 * of seconds per day can vary.
	 */
	public static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
	/**
	 * Milliseconds in a typical day (ISO). Due to time zone offset changes, the
	 * number of milliseconds per day can vary.
	 */
	public static final int MILLIS_PER_DAY = MILLIS_PER_HOUR * HOURS_PER_DAY;

	/**
	 * Days in one week (7) (ISO)
	 */
	public static final int DAYS_PER_WEEK = 7;
	/**
	 * Hours in a typical week. Due to time zone offset changes, the number of
	 * hours per week can vary.
	 */
	public static final int HOURS_PER_WEEK = HOURS_PER_DAY * DAYS_PER_WEEK;
	/**
	 * Minutes in a typical week (ISO). Due to time zone offset changes, the number
	 * of minutes per week can vary.
	 */
	public static final int MINUTES_PER_WEEK = MINUTES_PER_DAY * DAYS_PER_WEEK;
	/**
	 * Seconds in a typical week (ISO). Due to time zone offset changes, the number
	 * of seconds per week can vary.
	 */
	public static final int SECONDS_PER_WEEK = SECONDS_PER_DAY * DAYS_PER_WEEK;
	/**
	 * Milliseconds in a typical week (ISO). Due to time zone offset changes, the
	 * number of milliseconds per week can vary.
	 */
	public static final int MILLIS_PER_WEEK = MILLIS_PER_DAY * DAYS_PER_WEEK;

	public static final int DAYS_PER_MONTH = 31;
	public static final int DAYS_PER_YEAR = 366;
	public static final int MONTHS_PER_YEAR = 12;

	public static final int DAYS_1900_1970 = 25569;

	private DateTimeConstants() {
	}
}
