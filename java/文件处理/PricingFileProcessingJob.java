package com.carrefour.app.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.carrefour.pric.entity.PricTaskDetailEntity;
import com.carrefour.pric.service.PricTaskDetailService;

/**
 * @author sunl
 */
@Component
@Configurable
@EnableScheduling
public class PricingFileProcessingJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private PricTaskDetailService pricTaskDetailService;
	
	@Value("${yun.filepath}")
	private String filepath; 
  
	// 每天的0点、13点、18点、21点都执行一次
	//文件分类并压缩
	@Scheduled(cron = "0 0 0,13,18,21 * * ?")
	public void pricSuccessfulFileJob() throws Exception {
		logger.info("start pricSuccessfulFileJob"+new Date());
		List<PricTaskDetailEntity> pricTaskDetailList =  pricTaskDetailService.pricSuccessfulFile();
		File imageUrlArray[] = new File[pricTaskDetailList.size()];
		for (int i = 0; i < imageUrlArray.length; i++) {
			imageUrlArray[i] = new File(filepath+File.separator+pricTaskDetailList.get(i).getScanImages());
		}
		String baseFilePath = filepath+File.separator+"successdata";
		File zipFile = new File(baseFilePath+File.separator+"successFile.zip");
		
		// 调用创建文件夹并压缩方法
		this.zipFiles(imageUrlArray, zipFile,baseFilePath);
		logger.info("end pricSuccessfulFileJob"+new Date());
	}
	
	
	public void zipFiles(File[] srcFiles, File zipFile,String baseFilePath) {
		File basePath = new File(baseFilePath);
		 //判断服务器上传文件夹是否存在
		if(!basePath.exists()){
			basePath.mkdirs();
			logger.info("folder mkdirs success");
		}
		// 判断压缩后的文件存在不，不存在则创建
		if (!zipFile.exists()) {
			try {
				zipFile.createNewFile();
				logger.info("zipFile created success");
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
}
