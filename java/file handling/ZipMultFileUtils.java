package com.carrefour.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipMultFileUtils {

	public static void zipFiles(File[] srcFiles, File zipFile, String baseFilePath) {
		File basePath = new File(baseFilePath);
		// 判断服务器上传文件夹是否存在
		if (!basePath.exists()) {
			basePath.mkdirs();
		}
		// 判断压缩后的文件存在不，不存在则创建
		if (!zipFile.exists()) {
			try {
				zipFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 创建 FileOutputStream 对象
		FileOutputStream fileOutputStream = null;
		// 创建 ZipOutputStream
		ZipOutputStream zipOutputStream = null;
		// 创建 FileInputStream 对象
		FileInputStream fileInputStream = null;

		try {
			// 实例化 FileOutputStream 对象
			fileOutputStream = new FileOutputStream(zipFile);
			// 实例化 ZipOutputStream 对象
			zipOutputStream = new ZipOutputStream(fileOutputStream);
			// 创建 ZipEntry 对象
			ZipEntry zipEntry = null;
			// 遍历源文件数组
			for (int i = 0; i < srcFiles.length; i++) {
				// 将源文件数组中的当前文件读入 FileInputStream 流中
				fileInputStream = new FileInputStream(srcFiles[i]);
				// 实例化 ZipEntry 对象，源文件数组中的当前文件
				zipEntry = new ZipEntry(srcFiles[i].getName());
				zipOutputStream.putNextEntry(zipEntry);
				// 该变量记录每次真正读的字节个数
				int len;
				// 定义每次读取的字节数组
				byte[] buffer = new byte[1024];
				while ((len = fileInputStream.read(buffer)) > 0) {
					zipOutputStream.write(buffer, 0, len);
				}
			}
			zipOutputStream.closeEntry();
			zipOutputStream.close();
			fileInputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
		if (inFile.isDirectory()) {
			File[] files = inFile.listFiles();
			if (files != null && files.length > 0) {
				for (File file : files) {
					String name = inFile.getName();
					if (!"".equals(dir)) {
						name = dir + "/" + name;
					}
					ZipMultFileUtils.doCompress(file, out, name);
				}
			}
		} else {
			ZipMultFileUtils.doZip(inFile, out, dir);
		}
	}

	public static void doCompress(File file, ZipOutputStream out) throws IOException {
		doCompress(file, out, "");
	}

	public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
		doCompress(new File(filelName), out);
	}

	public static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
		String entryName = null;
		if (!"".equals(dir)) {
			entryName = dir + "/" + inFile.getName();
		} else {
			entryName = inFile.getName();
		}
		ZipEntry entry = new ZipEntry(entryName);
		out.putNextEntry(entry);

		int len = 0;
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(inFile);
		while ((len = fis.read(buffer)) > 0) {
			out.write(buffer, 0, len);
			out.flush();
		}
		out.closeEntry();
		fis.close();
	}
}
