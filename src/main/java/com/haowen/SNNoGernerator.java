package com.haowen;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import com.haowen.snowflake.SnowflakeIdWorker;
import com.haowen.tool.Ten2ThirtySix;
import com.haowen.tool.Varriable;
import com.haowen.uuid.ShortUUID;

 
public class SNNoGernerator {

	
	/**
	 * 19位 a-zA-Z0-9
	 * @author haowen
	 * @time 2018年11月3日上午11:24:02
	 * @Description 
	 * @return
	 */
	public static  String get19In62(){
		 return ShortUUID.uuid();
	}
	
	
	/**
	 *  获得32位16进制
	 * @author haowen
	 * @time 2018年11月3日上午11:34:37
	 * @Description  
	 * @return
	 */
	public static String get32In16(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	/**
	 *获得12位长度的 0-9A-Z
	 * @author haowen
	 * @time 2018年11月3日上午11:34:06
	 * @Description  
	 * @return
	 */
	public static String get12In36(){
		long nextId = SnowflakeIdWorker.getNextId();
        String tenTo36 = Ten2ThirtySix.tenTo36(nextId) ;
        return tenTo36;
	}
	
	/**
	 * 12位的补充，补充4位
	 * @author haowen
	 * @time 2018年11月3日上午11:35:35
	 * @Description  
	 * @return
	 */
	public static String get16In36(){
		long nextId = SnowflakeIdWorker.getNextId();
        String tenTo36 = Ten2ThirtySix.tenTo36(nextId) ;
        StringBuilder sb=new StringBuilder(tenTo36);
        SecureRandom random2=new SecureRandom();
        sb.insert(4, Varriable.X36_CHAR_ARRAY[random2.nextInt(Varriable.X36_CHAR_ARRAY.length)]);
        sb.insert(5, Varriable.X36_CHAR_ARRAY[random2.nextInt(Varriable.X36_CHAR_ARRAY.length)]);
        sb.insert(10, Varriable.X36_CHAR_ARRAY[random2.nextInt(Varriable.X36_CHAR_ARRAY.length)]);
        sb.insert(15, Varriable.X36_CHAR_ARRAY[random2.nextInt(Varriable.X36_CHAR_ARRAY.length)]);
        return sb.toString();
	}

	
}
