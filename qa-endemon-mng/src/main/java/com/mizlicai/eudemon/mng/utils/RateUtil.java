package com.mizlicai.eudemon.mng.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import static org.apache.commons.lang3.time.DateFormatUtils.ISO_DATE_FORMAT;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import static org.apache.commons.lang3.time.DateUtils.isSameDay;

/**
 * 里面存放计算利率、利息等的工具类
 * 
 * 
 * 
 *
 * Created by chars on 2015 下午4:29:48.
 *
 * Copyright © mizhuanglicai
 */
public class RateUtil {

	protected final static Log logger = LogFactory.getLog(RateUtil.class);

	public static final String DEFAULT_DATE = ISO_DATE_FORMAT.format(new Date(0));
	public static final String DEFAULT_DATE_STR = "购买成功后即日开始计算收益";

	/**
	 * 计算利息，精确到分
	 * 
	 * @param amout
	 * @param rate
	 * @param term
	 * @return
	 */
	public static BigDecimal calculateInterestPerDiem(BigDecimal amount, BigDecimal rate, Integer cycleDays, Integer days) {
		double interestPerDiem = 0;
		if (amount != null && rate != null && cycleDays != null && days != null) {
			interestPerDiem = amount.doubleValue() * rate.doubleValue() / cycleDays * days;
		}
		return new BigDecimal(interestPerDiem).setScale(2, RoundingMode.UP);
	}

	public static Date calculateSettlementDate(Date valueDate, Integer term) {
		if (valueDate != null && term != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(valueDate);
			int day = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, day + term);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			return calendar.getTime();
		}
		return null;
	}

	public static int calculateDate(Date date1, Date date2) {
		int count = 0;
		if (date1 != null && date2 != null && !isSameDay(date1, date2)) {
			if (date1.getTime() < date2.getTime()) {
				while (!isSameDay(addDays(date1, count), date2)) {
					count++;
					// logger.info("count:" + count);
				}
			} else {
				while (!isSameDay(addDays(date1, count), date2)) {
					count--;
					// logger.info("count" + count);
				}
			}
		}
		return count;
	}

	/**
	 * 计算起息日
	 * @param date
	 * @return
	 */
	public static Date calculateValueDate(Date date) {
		Date now = new Date();
		return date != null ? (ISO_DATE_FORMAT.format(now).compareTo(ISO_DATE_FORMAT.format(date)) >= 0 ? now : date) : now;
	}

	public static String calculateValueDateStr(Date date) {
		Date now = new Date();
		return date != null ? (ISO_DATE_FORMAT.format(now).compareTo(ISO_DATE_FORMAT.format(date)) >= 0 ? DEFAULT_DATE_STR : ISO_DATE_FORMAT.format(date)) : DEFAULT_DATE_STR;
	}

	public static Date getDate() {
		return DateUtils.setMilliseconds(new Date(), 0);
	}
}
