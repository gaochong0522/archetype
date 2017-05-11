package com.gcgame.oa.web.controller.base;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.gcgame.oa.common.util.web.MyThreadLocalUtils;
import com.zmtech.common.page.imp.Page;
import com.zmtech.common.util.ZmNumberUtils;
import com.zmtech.common.util.ZmStringUtils;
import com.zmtech.common.util.ZmThreadLocalUtils;
import com.zmtech.common.util.web.RequestUtils;
import com.zmtech.common.web.controller.ZmController;

public abstract class BaseController extends ZmController {
	public static SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	protected static SimpleDateFormat dateSeconds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected static SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
	protected static SimpleDateFormat monthFormat =  new SimpleDateFormat("yyyy-MM");
	
	protected static final String VIEW_TYPE_MOBILE = "mobile"; 

	@InitBinder
	public void InitBinder(WebDataBinder dataBinder, HttpServletRequest request) {
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (ZmStringUtils.isBlank(value)) {
						setValue(null);
					} else {
						if(NumberUtils.isNumber(value)){
							setValue(new Date(Long.parseLong(value)));
						}else{
							if(value.indexOf(":")>=0){
								try {
									setValue(dateTime.parse(value));
								} catch (Exception e) {
									setValue(dateSeconds.parse(value));
								}
							}else{
								setValue(dateFormat.parse(value));
							}
						}
					}
				} catch (ParseException e) {
						setValue(value);
				}
			}

		});
		dataBinder.registerCustomEditor(Boolean.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (ZmStringUtils.isNotBlank(value)) {
					if ("true".equalsIgnoreCase(value) || (ZmNumberUtils.isDigits(value) && ZmNumberUtils.toLong(value) > 0)) {
						setValue(true);
					} else {
						setValue(false);
					}
				}
			}

		});
		dataBinder.registerCustomEditor(Number.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (ZmStringUtils.isNotBlank(value)) {
					if ((ZmNumberUtils.isNumber(value))) {
						setValue(value);
					} else {
						setValue(null);
					}
				}
			}

		});
	}

	/**
	 * 保存查询条件到 model　中
	 * 
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	protected void saveQueryParamToModel(Model model) {
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			if (name.startsWith("query")) {
				String value = ZmStringUtils.trim(request.getParameter(name));
				if (ZmStringUtils.isNotBlank(value)) {
					model.addAttribute(name, value);
				}

			}
		}
	}

	/**
	 * 页面采用grid 时，保存数据到页面对象中
	 * 
	 * @param data
	 */
	public void setPagerData(List<?> data) {
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		Page page = Page.threadLocal.get();
		page.setData(data);
		request.setAttribute("page", page);
	}

	public static String getViewType() {
		return RequestUtils.getLookupPathExtension(ZmThreadLocalUtils.getRequest());
	}

	public static boolean isValidType(String contentType) {
		return true;
		//return (contentType.equalsIgnoreCase("image/bmp") || contentType.equalsIgnoreCase("image/x-windows-bmp") || contentType.equalsIgnoreCase("image/jpg") || contentType.equalsIgnoreCase("image/png") || contentType.equalsIgnoreCase("image/x-png") || contentType.equalsIgnoreCase("image/gif") || contentType.equalsIgnoreCase("image/jpeg") || contentType.equalsIgnoreCase("image/pjpeg"));
	}
	/*public static boolean isValidAudio(String contentType) {
	}*/

	public static synchronized String createtFileName(String extension) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 转换为字符串
		String formatDate = fmt.format(new Date());
		// 随机生成文件编号
		int random = new Random().nextInt(10000);
		return new StringBuffer().append(formatDate).append(random).append(extension).toString();
	}
	
	/**
	 * 从request中获取Long类型查询参数,0或空返回null
	 * @author ztb
	 * 2014-8-31 上午11:43:12
	 * @param paramName
	 * @return
	 */
	protected Long getLongQueryParamFromReq(String paramName){
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		String _val = request.getParameter(paramName);
		Long val = null;
		if(NumberUtils.isNumber(_val) && !"0".equals(_val)){
			val = Long.parseLong(_val);
		}
		return val;
	}
	
	protected Integer getIntegerQueryParamFromReq(String paramName){
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		String _val = request.getParameter(paramName);
		Integer val = null;
		if(NumberUtils.isNumber(_val) && !"0".equals(_val)){
			val = Integer.parseInt(_val);
		}
		return val;
	}
	
	protected String getStringQueryParamFromReq(String paramName){
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		String val = request.getParameter(paramName);
		return StringUtils.isBlank(val) ? null : val;
	}
}
