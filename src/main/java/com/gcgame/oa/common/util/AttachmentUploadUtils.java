package com.gcgame.oa.common.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gcgame.oa.common.util.web.MyThreadLocalUtils;
import com.zmtech.common.util.ZmFileUtils;

public class AttachmentUploadUtils {

	/**
	 * 附件处理：附件类型-图片
	 */
	public static final String ATTACHMENT_IMAGE = "img";

	/**
	 * 附件处理：附件类型-文件
	 */
	public static final String ATTACHMENT_FILE = "WEB-INF/attachment";

	/**
	 * 附件上传
	 * 
	 * 说明：<br>
	 * 返回参数类型为Map，其中返回 <br>
	 * 文件全名：fullFileName <br>
	 * 文件名：fileName <br>
	 * 文件扩展名：suffix <br>
	 * 文件路径：uRI<br>
	 * 
	 * @param request
	 *            request对象
	 * @param rootDir
	 *            根目录:例如-WEB-INF/attachment/rulemanage/techrule（路径前后不需要加/）
	 * @param folder
	 *            folder：根目录rootDir下子目录（路径前后不需要加/）<br>
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 *             Map<String,String>
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月16日下午5:03:53
	 */
//	public static Map<String, String> uploadAttachment(MultipartHttpServletRequest request, String rootDir,
//			String folder) throws IllegalStateException, IOException {
//		Map<String, MultipartFile> MultipartFiles =  request.getFileMap();
//		if(MultipartFiles.size() <= 0){
//			return null;
//		}
//		MultipartFile data = MultipartFiles.values().iterator().next();
//		AuthorizedUser user = MyThreadLocalUtils.currentUser();
//		//第一个判断在特殊情况下会被越过
//		if(data == null || StringUtils.isBlank(data.getOriginalFilename())){
//			return null;
//		}
//		// 文件信息获取
//		String suffix = ZmFileUtils.getFileNameExtension(data.getOriginalFilename()).toLowerCase();
//		String fullFileName = data.getOriginalFilename();
//		String fileName = (StringUtils.isNotBlank(fullFileName) ? fullFileName.split("\\.")[0] : "");
//
//		// 路径合成
//		StringBuilder uRI = new StringBuilder();
//		uRI.append("/");
//		uRI.append(rootDir);
//		uRI.append("/");
//		uRI.append(folder);
//		uRI.append("/");
//		if (user != null) {
//			uRI.append(user.getId());
//		}
//		uRI.append(ZmFileUtils.createtFileByDate(suffix));
//
//		File f = new File(request.getSession().getServletContext().getRealPath("/") + uRI.toString());
//		if (!f.getParentFile().exists()) {
//			f.getParentFile().mkdirs();
//		}
//
//		data.transferTo(f);
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("fullFileName", fullFileName);
//		param.put("fileName", fileName);
//		param.put("suffix", suffix);
//		param.put("uRI", uRI.toString());
//
//		return param;
//	}

	/**
	 * 附件删除
	 * 
	 * @param url
	 *            相对路径
	 * @return boolean
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月16日下午5:04:21
	 */
//	public static boolean deleteAttachment(String url) {
//		return FileUtils.deleteQuietly(getFile(url));
//	}

	/**
	 * 获取File对象
	 * 
	 * @param url
	 *            相对路径
	 * @return File
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月16日下午5:04:32
	 */
//	public static File getFile(String url) {
//		HttpServletRequest request = MyThreadLocalUtils.getRequest();
//		return new File(request.getSession().getServletContext().getRealPath("/") + url);
//	}
}
