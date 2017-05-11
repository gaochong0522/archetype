package com.gcgame.oa.common.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtils {

	public static void main(String[] args) {
		QRCodeUtils zxingTest = new QRCodeUtils();
		zxingTest.genQRCode("equip://rail/ccz/KY-ZJ-001", "E:/qrcode.png");
	}

	private static BitMatrix getBitMatrix(String content) {
		int width = 200;
		int height = 200;
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 0);
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			return bitMatrix;
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 写到流,最后别忘关闭
	 * 
	 * @author ztb 2017-2-28 上午11:04:24
	 * @param content
	 * @param os
	 */
	public static void genQRCode(String content, OutputStream os) {
		try {
			BitMatrix bitMatrix = getBitMatrix(content);
			if (bitMatrix != null) {
				MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写到文件
	 * 
	 * @author ztb 2017-2-28 上午11:04:32
	 * @param content
	 * @param outputFile
	 */
	public static void genQRCode(String content, String outputFile) {
		try {
			BitMatrix bitMatrix = getBitMatrix(content);
			if (bitMatrix != null) {
				Path path = new File(outputFile).toPath();
				MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
