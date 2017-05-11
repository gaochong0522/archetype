package archetype.common.pojo;

import java.util.Map;

import org.apache.commons.fileupload.FileItem;

/**
 * for commons fileupload
 * @author ztb
 * 2016-2-22 下午6:03:49
 */
public class MultipartData {
	
	private Map<String, FileItem> fileFields = null;
	private Map<String, String> dataFields = null;
	
	public MultipartData(Map<String, FileItem> fileFields, Map<String, String> dataFields){
		this.fileFields = fileFields;
		this.dataFields = dataFields;
	}
	
	public Map<String, FileItem> getFileFields() {
		return fileFields;
	}
	public void setFileFields(Map<String, FileItem> fileFields) {
		this.fileFields = fileFields;
	}
	public Map<String, String> getDataFields() {
		return dataFields;
	}
	public void setDataFields(Map<String, String> dataFields) {
		this.dataFields = dataFields;
	}

}
