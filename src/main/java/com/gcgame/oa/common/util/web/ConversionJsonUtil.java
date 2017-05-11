package com.gcgame.oa.common.util.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversionJsonUtil {
	
	 private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";  
	 private static final ObjectMapper mapper;
		static {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			mapper = new ObjectMapper();
			mapper.setDateFormat(dateFormat);
		}
	/**
	 * 将json格式的串转换为bean
	 * @param obj
	 * @param bean
	 * @return
	 */
	 public static Object convertJsonToBean(String obj, Class<?> bean) {
	        try {
	            return mapper.readValue(obj, bean);
	        } catch (JsonGenerationException e) {
	            e.printStackTrace();
	        } catch (JsonMappingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
	
	 /**
	  * 将jsonArray转换为beanList
	  * @param clazz
	  * @param jsonData
	  * @return
	  */	
    public static <T> List<T> getJavaCollection(Class<T> clazz, String jsonData) {
        List<T> objs = null;
        JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsonData);
        if (jsonArray != null) {
            objs = new ArrayList<T>();
            @SuppressWarnings("unchecked")
			List<T> list = (List<T>) JSONSerializer.toJava(jsonArray);
            for (Object o : list) {
                JSONObject jsonObject = JSONObject.fromObject(o);
                @SuppressWarnings("unchecked")
				T obj = (T) JSONObject.toBean(jsonObject, clazz);
                objs.add(obj);
            }
        }
        return objs;
    }	 
}
