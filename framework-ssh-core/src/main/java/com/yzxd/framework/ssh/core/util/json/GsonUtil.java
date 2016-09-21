package com.yzxd.framework.ssh.core.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static <T> String toJson(T t) {
		if (t != null)
			return gson.toJson(t);
		else
			return null;
	}

	/**
	 * Create date format 'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return
	 */
	public static Gson createGson() {
		return gson;
	}

	public static <T> T toEntity(String json, TypeToken<T> typeToken) {
		return gson.fromJson(json, typeToken.getType());
	}

}
