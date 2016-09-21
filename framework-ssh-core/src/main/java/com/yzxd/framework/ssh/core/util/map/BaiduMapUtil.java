package com.yzxd.framework.ssh.core.util.map;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class BaiduMapUtil {

	public static String httpGetStr(String url, String charsetName) {
		String result = "";
		try {
			URL surl = new URL(url);
			URLConnection con = surl.openConnection();
			con.setConnectTimeout(20000);
			InputStream is = con.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if (((HttpURLConnection) con).getResponseCode() == 200) {
				int length = 0;
				byte[] bt = new byte[2014];
				while ((length = bis.read(bt)) != -1) {
					baos.write(bt, 0, length);
				}
				result += new String(baos.toByteArray(), (charsetName == null || "".equals(charsetName)) ? "UTF-8" : charsetName);

			}
			bis.close();
			is.close();
		} catch (Exception e) {
		}
		return result;
	}

}
