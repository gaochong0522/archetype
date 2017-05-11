package com.gcgame.oa.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class ExcelUtils {

	public static String getCellVal(HSSFCell hssfCell) {
		if(hssfCell == null){
			return null;
		}
		String val = null;
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            val = String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
        	double doubleValue = hssfCell.getNumericCellValue();
        	long longValue = Double.valueOf(doubleValue).longValue();
        	if(doubleValue == longValue){
        		//是整数
        		val = String.valueOf(longValue);
        	}else{
        		val = String.valueOf(doubleValue);
        	}
        } else {
            // 返回字符串类型的值
            val = String.valueOf(hssfCell.getStringCellValue());
        }
        return val.trim();
    }
	
	public static String getCellValAndReplaceSpace(HSSFCell hssfCell) {
		return StringUtils.replace(getCellVal(hssfCell), " ", "");
	}

}
