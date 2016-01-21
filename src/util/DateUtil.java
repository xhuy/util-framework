package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Class with funciotns to convert from one type of date object to other
 * 
 * @author jesus.herrera
 *
 */
public class DateUtil {

	/**
	 * Number of seconds per day
	 */
	public static final long MILLISECONDS_PER_DAY = 86400000l;

	/**
	 * Function that creates an object Date and sets the actual date from the
	 * inputs
	 * 
	 * @param format
	 *            <code>String</code> with format for a date (EX. HH:mm:dd)
	 * @param dateString
	 *            <code>String</code> that represents a date
	 * @return object <code>Date</code> with the same date from the input
	 */
	public static Date fromStringToDate(String format, String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = new Date(sdf.parse(dateString).toInstant().getEpochSecond() * 1000);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * Function that return a <code>String</code> from the date param and with
	 * the format espicified
	 * 
	 * @param format
	 *            <code>String</code> with format for a date (EX. HH:mm:dd)
	 * @param date
	 *            <code>Date</code> from which is going to be extracted and
	 *            created the <code>String</code>
	 * @return object <code>Date</code> with the same date from the input
	 */
	public static String fromDateToString(String format, Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String dateO = null;
			dateO = sdf.format(date);
			return dateO;
		} else
			return "";
	}

	/**
	 * Creates a <code>LocalDate</code> from a <code>String</code> date with a
	 * <code>String</code> format (Ex. HH:dd:mm.ss)
	 * 
	 * @param format
	 *            <code>String</code> with format for a date (EX. HH:mm:dd)
	 * @param date
	 *            <code>String</code> that represents a date
	 * @return A <code>LocalDate</code> object setted with the input date
	 */
	public static LocalDate fromStringToLocalDate(String format, String date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.fromStringToDate(format, date));
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		return LocalDate.of(year, month, dayOfMonth);
	}

	/**
	 * Converts a <code>LocalDate</code> to an object <code>Date</code>
	 * preserving the date data
	 * 
	 * @param localDate
	 *            date to be used
	 * @return <code>Date</code> with the same date from LocalDate
	 */
	public static Date fromLocalDateToDate(LocalDate localDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth(), 0, 0, 0);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * Get actual date from the system in a <code>Date</code> object
	 * 
	 * @return object <code>Date</code>
	 */
	public static Date getActualDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

}