package com.bsth.si.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileHepler {
	/**
	 * 删除文件
	 * 
	 * @param path
	 */
	public static void deleFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			boolean b = file.delete();
			if (b) {
				System.out.println("删除成功...");
			}
		}
	}
	
	public static void deleFile(File file) {
		if (file.exists()) {
			boolean b = file.delete();
			if (b) {
				System.out.println("删除成功...");
			}
		}
	}
	
	/**
	 * 写文件到本地
	 * 
	 * @param in
	 * @param fileName
	 * @throws IOException
	 */
	public void copyFile(InputStream in, String fileName) throws IOException {
		FileOutputStream fs = new FileOutputStream(fileName);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = in.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		in.close();
	}
}
