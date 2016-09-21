package com.yzxd.framework.ssh.core.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * Date pattern of "yyyyMMdd".
	 */
	public final static String DATE_PATTERN_NOT_YYYYMMDD = "yyyyMMdd";
	/**
     * Date pattern of "yyyy-MM-dd".
     */
	public final static String DATE_PATTERN_DASH_YYYYMMDD = "yyyy-MM-dd";
	/**
	 * Date pattern of "yyyy-MM".
	 */
    public final static String DATE_PATTERN_DASH_YYYYMM = "yyyy-MM";
    /**
     * Date pattern of "MM-dd-yyyy".
     */
    public final static String DATE_PATTERN_DASH_MMDDYYYY = "MM-dd-yyyy";
    /**
     * Date pattern of "dd-MM-yyyy".
     */
    public final static String DATE_PATTERN_DASH_DDMMYYYY = "dd-MM-yyyy";
    /**
     * Date pattern of "yyyy/MM/dd".
     */
    public final static String DATE_PATTERN_SLASH_YYYYMMDD = "yyyy/MM/dd";
    /**
     * Date pattern of "MM/dd/yyyy".
     */
    public final static String DATE_PATTERN_SLASH_MMDDYYYY = "MM/dd/yyyy";
    /**
     * Date pattern of "dd/MM/yyyy".
     */
    public final static String DATE_PATTERN_SLASH_DDMMYYYY = "dd/MM/yyyy";
    
    /**
     * Date pattern of "yyyy��MM��".
     */
    public final static String DATE_PATTERN_FONT_YYYYMM = "yyyy��MM��";

    /**
     * Time pattern of "HH:mm:ss".
     */
    public final static String TIME_PATTERN_COLON_HHMMSS = "HH:mm:ss";
    /**
     * Time pattern of "HHmmss".
     */
    public final static String TIME_PATTERN_NOT_HHMMSS = "HHmmss";
    
    
    private final static ArrayList<SimpleDateFormat> patterns = new ArrayList<SimpleDateFormat>();
    static {
    	patterns.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    	patterns.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
    	patterns.add(new SimpleDateFormat("yyyy-MM-dd"));
    }
    
    public static Date str2date(String source) {
    	if (source != null && !"".equals(source)) {
    		for (int i = 0; i < patterns.size(); i++) {
				try {
					return patterns.get(i).parse(source);
				} catch (Exception e) {
				}
			}
    	}
    	return null;
    }
    
    
    /**
     * Convert date to string.
     *
     * @param source  source date.
     * @param pattern date pattern.
     * @return converted string.
     */
    public static String date2String(Date source, String pattern) {
        if (source == null)
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(source);
    }
    
    /**
     * ����Ŀ�ʼʱ��
     * @return
     */
    public static Date getTodayStartDate(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_DASH_YYYYMMDD);
    	String format = sdf.format(date);
    	try {
    		date = sdf.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }
    
    /**
     * ����Ľ���ʱ��
     * @return
     */
    public static Date getTodayEndDate(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_DASH_YYYYMMDD);
    	String format = sdf.format(date);
    	try {
    		date = sdf.parse(format);
    		date = new Date(date.getTime() + (1000*60*60*24));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }

    /**
     * Convert string to date.
     *
     * @param source  source string.
     * @param pattern date pattern.
     * @return converted date.
     */
    public static Date string2Date(String source, String pattern) {
    	if (source == null || source.equals(""))
    		return null;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	try {
    		return sdf.parse(source);
    		
    	} catch (ParseException pe) {
    		throw new RuntimeException("Error converting string \'" + source + "\' to date with pattern \'" + pattern + "\'", pe);
    	}
    }
    
    /**
     * 
     * @param source
     * @param pattern
     * @return
     */
    public static String string2String(String source, String pattern) {
        if (source == null || source.equals(""))
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
        	Date date = sdf.parse(source);
            return sdf.format(date);
        } catch (ParseException pe) {
            throw new RuntimeException("Error converting string \'" + source + "\' to string with pattern \'" + pattern + "\'", pe);
        }
    }

    /**
     * Get current date.
     *
     * @return current date.
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * Add days to a date.
     *
     * @param originalDate
     * @param amount       Amount of days to add.
     * @return date after add.
     */
    public static Date addDays(Date originalDate, int amount) {
        //add days
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalDate);
        calendar.add(Calendar.DATE, amount);

        return calendar.getTime();
    }

    /**
     * Add months to a date.
     *
     * @param originalDate
     * @param amount       Amount of months to add.
     * @return date after add.
     */
    public static Date addMonths(Date originalDate, int amount) {
        //add months
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalDate);
        calendar.add(Calendar.MONTH, amount);

        return calendar.getTime();
    }
    
    /**
     * Add times to a date.
     * @param originalDate
     * @param time
     * @return
     */
    public static Date addTimes(Date originalDate, int time){
    	return new Date(originalDate.getTime() + time);
    }
    
    /**
     * Add hours to a date.
     */
    public static Date addHours(Date originalDate, int hours){
    	return new Date(originalDate.getTime() + hours * 60 * 60 * 1000);
    }
    
    /**
     * isAfter: whether the first day is after last day(precision: day)
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    public static boolean isAfter(Date firstDate, Date lastDate) {
        if (firstDate.getYear() > lastDate.getYear())
            return true;
        else if (firstDate.getYear() < lastDate.getYear())
            return false;
        else {
            if (firstDate.getMonth() > lastDate.getMonth())
                return true;
            else if (firstDate.getMonth() < lastDate.getMonth())
                return false;
            else {
                if (firstDate.getDate() > lastDate.getDate())
                    return true;
                else
                    return false;
            }
        }
    }

    /**
     * isBefore: whether the first day is before last day(precision: day)
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    public static boolean isBefore(Date firstDate, Date lastDate) {
        if (firstDate.getYear() < lastDate.getYear())
            return true;
        else if (firstDate.getYear() > lastDate.getYear())
            return false;
        else {
            if (firstDate.getMonth() < lastDate.getMonth())
                return true;
            else if (firstDate.getMonth() > lastDate.getMonth())
                return false;
            else {
                if (firstDate.getDate() < lastDate.getDate())
                    return true;
                else
                    return false;
            }
        }
    }

    /**
     * isEqual: whether the first day is equal to last day(precision: day)
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    public static boolean isEqual(Date firstDate, Date lastDate) {
        if (firstDate.getYear() == firstDate.getYear()) {
            if (firstDate.getMonth() == lastDate.getMonth()) {
                if (firstDate.getDate() == lastDate.getDate())
                    return true;
                else
                    return false;
            } else
                return false;
        } else
            return false;
    }

    /**
     * getFirstDayOfYear
     *
     * @param calendar
     * @return the first date of year
     */
    public static Date getFirstDayOfYear(Calendar calendar) {
        Date reVal = null;

        int year = calendar.get(Calendar.YEAR) - 1900;

        reVal = new Date(year, Calendar.JANUARY, 1);
        return reVal;
    }

    /**
     * getLastDayOfYear
     *
     * @param calendar
     * @return the last date of year
     */
    public static Date getLastDayOfYear(Calendar calendar) {
        Date reVal = null;

        int year = calendar.get(Calendar.YEAR) - 1900;

        reVal = new Date(year, Calendar.DECEMBER, 31);
        return reVal;
    }
    
    /**
     * getCurrentMonthLastDayNum
     * @return
     */
    public static Integer getCurrentMonthLastDayNum(){
    	
        Calendar cale = Calendar.getInstance();
		int year = cale.get(Calendar.YEAR);
		int month = cale.get(Calendar.MONTH) + 1;
		int day = 1;
		
		Date date = new Date(year, month, day);
		date = new Date(date.getTime() - 1000);
		
    	return date.getDate();
    }
    
    /**
     * getCurrentMonthLastDayNum
     * @return
     */
    public static Integer getCurrentMonthLastDayNum(Date date){
    	date.setMonth(date.getMonth()+1);
    	date.setDate(1);
    	date = new Date(date.getTime() - 1000);
    	return date.getDate();
    }
    
    public static Integer getCurrentMonthNum(Date date){
    	return date.getMonth()+1;
    }
    
    public static Integer getCurrentYearNum(Date date){
    	return date.getYear();
    }
    
    public static Date getCurrentMonthUp(Date date){
    	date.setDate(1);
    	date.setHours(0);
    	date.setMinutes(0);
    	date.setSeconds(0);
    	date = new Date(date.getTime()-1000);
    	
    	return date;
    }
    
    /**
     * getFirstDayOfMonth
     *
     * @param calendar
     * @return the first date of month
     */
    public static Date getFirstDayOfMonth(Calendar calendar) {
        Date reVal = null;

        int year = calendar.get(Calendar.YEAR) - 1900;
        int month = calendar.get(Calendar.MONTH);

        reVal = new Date(year, month, 1);
        return reVal;
    }

    /**
     * getLastDayOfMonth
     *
     * @param calendar
     * @return the last date of month
     */
    public static Date getLastDayOfMonth(Calendar calendar) {
        Date reVal = null;

        int year = calendar.get(Calendar.YEAR) - 1900;
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = 1;

        reVal = new Date(year, month, date);
        reVal.setDate(reVal.getDate() - 1);
        return reVal;
    }

    /**
     * getFirstDayOfWeek
     *
     * @param calendar
     * @return the first date(Monday) of week
     */
    public static Date getFirstDayOfWeek(Calendar calendar) {
        Date reVal = null;

        int date = calendar.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_WEEK);

        if ((calendar.get(Calendar.DAY_OF_WEEK) == 0) || (calendar.get(Calendar.DAY_OF_WEEK) == 7))
            date = date + 7;

        reVal = new Date(calendar.get(Calendar.YEAR) - 1900, calendar.get(Calendar.MONTH), date);
        return reVal;
    }

    /**
     * getLastDayOfWeek
     *
     * @param calendar
     * @return the last date(Sunday) of week
     */
    public static Date getLastDayOfWeek(Calendar calendar) {
        Date reVal = null;

        int date = calendar.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_WEEK) + 6;

        if ((calendar.get(Calendar.DAY_OF_WEEK) == 0) || (calendar.get(Calendar.DAY_OF_WEEK) == 7))
            date = date + 7;

        reVal = new Date(calendar.get(Calendar.YEAR) - 1900, calendar.get(Calendar.MONTH), date);
        return reVal;
    }

    /**
     * getCurrentYear
     * @return string represents current year
     */
    public static String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(getCurrentDate());
    }

    /**
     * getCurrentMonth
     * @return string represents current month
     */
    public static String getCurrentMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return new Integer(sdf.format(getCurrentDate())).toString();
    }
    
    /**
     * getDateToInt
     * @return string represents int
     */
    public static long getDateToInt(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return new Integer(sdf.format(string2Date(sDate,"yyyy-MM-dd"))).longValue();
    }
    
    public static Date getStrToDate(String str, String format){
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
    		if(str != null && !str.equals("")){
    			return sdf.parse(str);
    		}
    		return null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * getDateToInt
     * @return string represents int
     */
    public static int getDateToInt(Date sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(sDate));
    }
    
    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getDateToStr(Date date, String format){
    	if(date != null){
    		SimpleDateFormat sdf = new SimpleDateFormat(format);
    		return sdf.format(date);
    	}
    	return null;
    }
    
    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static Date getDateToDate(Date date, String format){
    	if(date != null){
    		SimpleDateFormat sdf = new SimpleDateFormat(format);
    		String strdate = sdf.format(date);
			try {
				return sdf.parse(strdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	return null;
    }
	
}
