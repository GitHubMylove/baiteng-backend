package com.baiteng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BCD8421Operater {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");

	/**
	 * BCD字节数组===>String
	 * 
	 * @param bytes
	 * @return 十进制字符串
	 */
	public static String bcd2String(byte[] bytes) {
		StringBuilder temp = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			// 高四位
			temp.append((bytes[i] & 0xf0) >>> 4);
			// 低四位
			temp.append(bytes[i] & 0x0f);
		}
		return temp.toString();
	}

	/**
	 * 字符串==>BCD字节数组
	 * 
	 * @param str
	 * @return BCD字节数组
	 */
	public static byte[] string2Bcd(String str) {
		//System.out.println("++++++====== string2Bcd: "+str);
		// 奇数,前补零
		if ((str.length() & 0x1) == 1) {
			str = "0" + str;
		}
		byte ret[] = new byte[str.length() / 2];
		byte bs[] = str.getBytes();
		for (int i = 0; i < ret.length; i++) {
			byte high = ascII2Bcd(bs[2 * i]);
			byte low = ascII2Bcd(bs[2 * i + 1]);
			// 只遮罩BCD低四位?
			ret[i] = (byte) ((high << 4) | low);
		}
		return ret;
	}

	/**
	 * 时间BCD[6] -> long
	 * 
	 * @param bytes
	 *            时间BCD[6] -> long
	 * @return
	 */
	public static long bcdTime2Long(byte[] bytes) {
		String dateString = bcd2String(bytes);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}

	/**
	 * 时间BCD[6] => time_t byte[8]
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] bcdTime2Bytes(byte[] bytes) {
		long time = bcdTime2Long(bytes);
		return BitOperator.longToBytes(time);
	}

	private static byte ascII2Bcd(byte asc) {
		if ((asc >= '0') && (asc <= '9'))
			return (byte) (asc - '0');
		else if ((asc >= 'A') && (asc <= 'F'))
			return (byte) (asc - 'A' + 10);
		else if ((asc >= 'a') && (asc <= 'f'))
			return (byte) (asc - 'a' + 10);
		else
			return (byte) (asc - 48);
	}

}
