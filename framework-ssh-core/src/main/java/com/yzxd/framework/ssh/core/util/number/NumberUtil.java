package com.yzxd.framework.ssh.core.util.number;

import java.math.BigDecimal;

/**
 * 
 * @author ShenXiaoqiang
 * @date 2014-9-29
 * 
 */
public class NumberUtil {

	public static final String getStr2Scale(Double num) {

		if (num != null) {
			return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}

		return null;

	}

	public static final String getStr2Scale2(Double num) {
		if (num < 0) {
			num = 0d;
		}
		if (num != null) {
			return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}

		return null;

	}

	public static final BigDecimal getBig2Scale(Double num) {

		if (num != null)
			return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP);

		return null;

	}

	public static final Double getNum2Scale(Double num) {

		if (num != null)
			return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		return null;

	}

	/**
	 * 
	 * @param num
	 * @param length
	 * @return
	 */
	public static final String getStringFillNumber(Integer num, Integer length) {
		if (num != null) {
			String strNum = String.valueOf(num);
			if (strNum.length() <= length) {
				for (int i = 0; i < String.valueOf(num).length(); i++) {
					strNum = "0" + strNum;
				}
			} else {
				return strNum;
			}

			return strNum;
		}
		return null;
	}

	/**
	 * String to double
	 * 
	 * @param num
	 * @return
	 */
	public static final Double strToDoule(String num) {
		if (num != null && !num.trim().equals("")) {
			try {
				return Double.parseDouble(num.trim());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static final Short strToShort(String num) {
		if (num != null && !num.trim().equals("")) {
			try {
				return Short.parseShort(num.trim());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static final Long strToLong(String num) {
		if (num != null && !num.trim().equals("")) {
			try {
				return Long.parseLong(num.trim());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static final Integer strToInteger(String num) {
		if (num != null && !num.trim().equals("")) {
			try {
				return Integer.parseInt(num.trim());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getStr2Scale(1243532423434.346));
		System.out.println(getNum2Scale(15234243d));
	}
}
