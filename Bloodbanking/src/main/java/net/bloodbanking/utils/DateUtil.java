package net.bloodbanking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	
	private DateUtil() {
	}

	public static final String DATE_FORMAT_dd_MM_yyyy_SEP_HIPHEN = "dd-MM-yyyy";
	
	public static final String DATE_FORMAT_dd_MMM_yyyy_SEP_HIPHEN = "dd-MMM-yyyy";

	public static final String DATE_FORMAT_dd_MM_yyyy_SEP_SLASH = "dd/MM/yyyy";

	public static final String DATE_FORMAT_yyyy_MM_dd_SEP_HIPHEN = "yyyy-MM-dd";

	public static final String DATE_FORMAT_HH_mm_ss = "HH:mm:ss";

	public static final String DATE_FORMAT_yy = "yy";

	public static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_ss_SEP_HIPHEN = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMAT_dd_MM_yyyy_HH_mm_ss_SEP_HIPHEN = "dd-MM-yyyy HH:mm:ss";

	public static final String DATE_FORMAT_dd_MM_yyyy_HH_mm_ss_SEP_SLASH = "dd/MM/yy-HH:mm:ss";
	
	public static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_SEP_HIPHEN = "dd-MM-yyyy HHmm";

	public static final String DATE_FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static final String DATE_FORMAT_ddMMyyyy = "ddMMyyyy";
	
	public static final String TIME_HH_MM = "HH:mm";
	
	public static final String DATE_FORMAT_MM_dd_YY_SEP_HIPHEN = "MM-dd-yy";
	
	public static final String DATE_FORMAT_dd_MM_yyyy_HH_mm_am_pm = "dd-MM-yyyy HH:mm a";
	
	public static final String DATE_FORMAT_PATTERN_dd_MM_yyyy_SEP_SLASH = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	
	public static final String DATE_FORMAT_PATTERN_dd_MM_yyyy_SEP_HIPHEN = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";

	public static Date calculateToDate( final Date date, final int tenure ) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		calendar.add( Calendar.DATE, tenure );
		return calendar.getTime();
	}
	
	public static Date addDate( final Date date, final int calendarField,  final int amount ) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add( calendarField, amount );
		return calendar.getTime();

	}

	public static Date convertDateStrToDate( final String dateStr, final String dateFormatStr ) {
		Date date = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat( dateFormatStr );
			date = dateFormat.parse( dateStr );
		} catch ( ParseException e ) {
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDateToDateStr( final Date date, final String dateFormatStr ) {
		SimpleDateFormat sdFormatter = new SimpleDateFormat( dateFormatStr );
		return sdFormatter.format( date );
	}

	public static String changeDateFormat( final String date, final String fromDateFormat,
			final String toDateFormat ) {
		String dateStr = "";
		try {
			Date formattedDate = convertDateStrToDate( date, fromDateFormat );
			dateStr = convertDateToDateStr( formattedDate, toDateFormat );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return dateStr;
	}

	public static int dateDiffInDays( final Date fromDate, final Date toDate ) {
		long numberOfDays = 0L;
		try {
			Long diff = toDate.getTime() - fromDate.getTime();
			numberOfDays = diff / ( 1000 * 60 * 60 * 24 );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return (int) numberOfDays;
	}
	
	public static Long dateDiffInMillis( final Date fromDate, final Date toDate ) {
		Long diff = toDate.getTime() - fromDate.getTime();
		return diff;
	}

	public static String julianDateyyddd( final Date date ) {
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime( date );
		return convertDateToDateStr( date, DATE_FORMAT_yy )
				+ String.format( "%03d", ca1.get( Calendar.DAY_OF_YEAR ) );
	}

	public static boolean compareDates( final String fromDate, final String toDate,
			final String dateFormat ) {
		Date date1 = convertDateStrToDate( fromDate, dateFormat );
		Date date2 = convertDateStrToDate( toDate, dateFormat );
		if ( date1.compareTo( date2 ) <= 0 ) {
			return true;
		}
		return false;
	}
	
	public static boolean isFirstDateIsGreaterThanLastDate(Date firstDate, Date lastDate) {

		boolean isFirstDateIsGreater = false;
		if(firstDate.compareTo(lastDate)>0){
			isFirstDateIsGreater = true;
		}
		return isFirstDateIsGreater;
	}
	
	public static boolean isFirstDateIsGreaterThanLastDate(final String firstDate, final String lastDate,
			final String dateFormat) {

		Date date1 = convertDateStrToDate( firstDate, dateFormat );
		Date date2 = convertDateStrToDate( lastDate, dateFormat );
		
		boolean isFirstDateIsGreater = false;
		if(date1.compareTo(date2)>=0){
			isFirstDateIsGreater = true;
		}
		return isFirstDateIsGreater;
	}
	
	public static boolean isFirstDateIsSameAsLastDate(final String firstDate, final String lastDate,
			final String dateFormat) {

		Date date1 = convertDateStrToDate( firstDate, dateFormat );
		Date date2 = convertDateStrToDate( lastDate, dateFormat );
		
		boolean isFirstDateIsGreater = false;
		if(date1.compareTo(date2) == 0){
			isFirstDateIsGreater = true;
		}
		return isFirstDateIsGreater;
	}

	public static Date convertAgeToDob( final int age ) {
		int currentYear = Calendar.getInstance().get( Calendar.YEAR );
		int ageYear = currentYear - age;
		Calendar cal = Calendar.getInstance();
		cal.set( Calendar.YEAR, ageYear );
		cal.set( Calendar.MONTH, Calendar.JANUARY );
		cal.set( Calendar.DATE, 1 );
		return cal.getTime();
	}

	public static Integer convertDobToAge(final Date dateOfBirth) {

		if (dateOfBirth != null) {
			Calendar now = Calendar.getInstance();
			Calendar dob = Calendar.getInstance();
			dob.setTime(dateOfBirth);
			//Calculate the age based on year
			int yearNow = now.get(Calendar.YEAR);
			int yearDob = dob.get(Calendar.YEAR);
			int age = yearNow - yearDob;
			//ReCalculate the month based on month
			int monthNow = now.get(Calendar.MONTH);
			int monthDob = dob.get(Calendar.MONTH);
			if (monthDob > monthNow) {
				age--;
			} else if (monthNow == monthDob) {
				//ReCalculate the month based on day
				int dayNow = now.get(Calendar.DAY_OF_MONTH);
				int dayDob = dob.get(Calendar.DAY_OF_MONTH);
				if (dayDob > dayNow) {
					age--;
				}
			}
			return age;
		}
		return null;
	}

	public static Integer dayFromDate(Date date){
		Calendar cal=Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}
	
	public static boolean isThisDateValid(String dateToValidate, String dateFromat){
		 
		if(dateToValidate == null){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (ParseException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static  int getLastDayOfMonth (Date date){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		System.out.println("Last Day of Month: " + calendar.get(Calendar.DATE));
		
		return calendar.get(Calendar.DATE);

	}
	
	public static Date addSubtractMonthFromDate(Date refDate,int monthToAddRSub) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(refDate); 
		c.add(Calendar.MONTH, monthToAddRSub);
		return c.getTime();
	}
	
	public static Date otpExpiryDate(){
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 4); // adds one hour
		return cal.getTime();
	}
	
	public static int getMonthsBetweenTwoDates(Date startDate,Date endDate){
		Calendar sDate = Calendar.getInstance();
		Calendar eDate = Calendar.getInstance();
		sDate.setTime(startDate);
		eDate.setTime(endDate);
		return sDate.get(Calendar.MONTH) - eDate.get(Calendar.MONTH);
	}

	public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
	
}
