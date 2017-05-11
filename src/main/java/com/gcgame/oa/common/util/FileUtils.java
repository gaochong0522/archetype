package com.gcgame.oa.common.util;

public class FileUtils {

	/**
	 * 获取文件大小
	 * @author ztb
	 * 2014年8月12日 下午9:28:20
	 * @param fileSize
	 * @return
	 */
	public static String getFileSize(long fileSize){
		if (fileSize < 1024) {
			return fileSize + "B";
		} else {
			long size = fileSize / 1024;
			if (size < 1024) {
				return size + "KB";
			} else {
				size = size / 1024;
				if(size < 1024){
					return size + "MB";
				}else{
					size = size / 1024;
					return size + "GB";
				}
			}
		}
	}

}
