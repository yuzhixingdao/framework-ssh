package com.yzxd.framework.ssh.core.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class StreamUtil {

	/**
	 * 压缩
	 * 
	 * @param is
	 * @param os
	 */
	public static void compress(InputStream is, OutputStream os) {

		GZIPOutputStream gos = null;

		try {

			gos = new GZIPOutputStream(os);

			int count;
			byte data[] = new byte[500];
			while ((count = is.read(data, 0, 500)) != -1) {
				gos.write(data, 0, count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (gos != null) {
				try {
					gos.finish();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					gos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					gos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 解压
	 * 
	 * @param is
	 * @param os
	 * @throws Exception
	 */
	public static void decompress(InputStream is, OutputStream os) {

		GZIPInputStream gis = null;
		try {
			gis = new GZIPInputStream(is);
			int count;
			byte data[] = new byte[500];
			while ((count = gis.read(data, 0, 500)) != -1) {
				os.write(data, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gis != null) {
				try {
					gis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 数据压缩
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] byteCompress(byte[] data) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// 压缩
		compress(bais, baos);

		byte[] output = baos.toByteArray();

		baos.flush();
		baos.close();

		bais.close();

		return output;
	}

	/**
	 * 数据解压缩
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] byteDecompress(byte[] data) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// 解压缩
		decompress(bais, baos);

		data = baos.toByteArray();

		baos.flush();
		baos.close();

		bais.close();

		return data;
	}

}
