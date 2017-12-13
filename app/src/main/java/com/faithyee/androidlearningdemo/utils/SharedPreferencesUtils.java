package com.faithyee.androidlearningdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences管理类
 */
public class SharedPreferencesUtils {

	/**
	 * 存储String
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveString(Context context, String key,
			String value) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		sp.edit().putString(key, value).commit();
	}

	/**
	 * 获取String
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(Context context, String key,
			String defValue) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		return sp.getString(key, defValue);
	}

	/**
	 * 存储Boolean
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setBoolean(Context context, String key,
			boolean value) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	/**
	 * 获取Boolean
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(Context context, String key,
			boolean defValue) {
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);
		return sp.getBoolean(key, defValue);
	}





}
