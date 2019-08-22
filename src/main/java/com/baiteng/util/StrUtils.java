/**
 * 
 */
package com.baiteng.util;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class StrUtils {
	static Logger logger  =  Logger.getLogger(StrUtils.class );
     public static String reverseString(String str){
    	 byte[] inputStrByte=str.getBytes();
    	 for(int i=0;i<inputStrByte.length/2;i++){
    		 byte temp=inputStrByte[i];
    		 inputStrByte[i]=inputStrByte[inputStrByte.length-i-1];
    		 inputStrByte[inputStrByte.length-i-1]=temp;
    	 }
    	 return new String(inputStrByte);
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(StrUtils.reverseString("123456"));
			System.out.println(StrUtils.reverseString("1234567"));
			throw new Exception("000");
		} catch (Exception e) {
			StrUtils.logger.error("erro",e);
			//e.printStackTrace();
		}
	}

	public static boolean isMobile(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
}
