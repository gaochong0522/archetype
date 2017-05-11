package com.gcgame.oa.common.util;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * httpclient
 * @author ztb
 * 2014-9-3 上午3:10:29
 */
public class HttpClientUtils {
	
	private static Logger log = Logger.getLogger(HttpClientUtils.class);
	
	private static final String DEFAULT_CHARSET = "GBK";

	public static String get(String url){
//		try {
//			return Request.Get(url).execute().returnContent().asString();
//		} catch (Exception e) {
//			log.error("get faild, url:" + url, e);
//			return null;
//		}
		CloseableHttpClient httpclient = getHttpClient();
        try {
            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(getRequestConfig());
            if(log.isDebugEnabled()){
            	log.debug("Executing get request " + httpget.getRequestLine());
            }
            return httpclient.execute(httpget, getStringResponseHandler());
        } catch (Exception e) {
        	log.error("get faild, url:" + url, e);
		} finally {
            IOUtils.closeQuietly(httpclient);
        }
		return null;
	}
	
	/**
	 * 连接超时3�?
	 * @author ztb
	 * 2014-9-3 上午3:10:59
	 * @return
	 */
	private static RequestConfig getRequestConfig(){
		return RequestConfig.custom().setConnectTimeout(3000).build();
	}
	
	private static ResponseHandler<String> getStringResponseHandler(){
		return new ResponseHandler<String>() {
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
//                    throw new ClientProtocolException("Unexpected response status: " + status);
                	return null;
                }
            }
        };
	}
	
	/**
	 * 路局项目为GBK,因此修改默认编码
	 * @author ztb
	 * 2014-9-3 上午3:12:53
	 * @return
	 */
	private static CloseableHttpClient getHttpClient(){
		return getHttpClient(DEFAULT_CHARSET);
	}
	
	/**
	 * 获取httpclient,socket超时3�?
	 * @author ztb
	 * 2014-9-3 上午3:12:30
	 * @param charset
	 * @return
	 */
	private static CloseableHttpClient getHttpClient(String charset){
		BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager();
		ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName(charset)).build();
		connManager.setConnectionConfig(connConfig);
		SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(3000).build();
		connManager.setSocketConfig(socketConfig);
		return HttpClients.custom().setConnectionManager(connManager)
				.setDefaultConnectionConfig(connConfig)
				.setDefaultSocketConfig(socketConfig)
				.build();
	}
	
	public static String post(String url){
		return post(url, null);
	}
	
	public static String post(String url, Map<String, String> params){
		CloseableHttpClient httpclient = getHttpClient();
        try {
            HttpPost httppost = new HttpPost(url);
            httppost.setConfig(getRequestConfig());
            if(log.isDebugEnabled()){
            	log.debug("Executing post request " + httppost.getRequestLine());
            }

            if(params != null && !params.isEmpty()){
            	
            	List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
            	
            	Set<String> keySet = params.keySet();  
            	for(String key : keySet) {  
            		nvps.add(new BasicNameValuePair(key, params.get(key)));  
            	}
            	
            	try {
            		httppost.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
            	} catch (UnsupportedEncodingException e) {
            		log.error("faild to set entity", e);
            	}
            }
            return httpclient.execute(httppost, getStringResponseHandler());
        } catch (Exception e) {
        	log.error("post faild, url:" + url, e);
		} finally {
            IOUtils.closeQuietly(httpclient);
        }
		return null;
	}
//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("loginName", "张桐搏");
//		map.put("password", "e10adc3949ba59abbe56e057f20f883e");
//		String msg = HttpClientUtils.post("http://localhost:8080/oa/login.json", map);
//		System.out.println("msg:"+msg);
//	}
	
//	public static void main(String[] ares) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("token", "7FDDCC2DB0672BBD4AFEEFA9F109FA53");
//		map.put("newPassword", "84D9CF6F7519484C386C6F3852E3BA46");
//		map.put("password", "055DC3606385FD4A5153811D1EE91EB6");
//		String msg = HttpClientUtils.post("http://localhost:8080/oa/user/editPassword.json", map);
//		System.out.println("msg:"+msg);
//	}
	
//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("token", "CD1463E322C4A7CE67A6F50443860567");
//		map.put("userId", "100001");
////		map.put("status","1");
////		map.put("name", "名称"); /equipment/delAttachment/id.json
////		map.put("key", "名称");
////		map.put("id", "55");
////		map.put("checkUser", "1");
////		map.put("equipmentUnit", "设备单位111");
////		map.put("repairStartTime", "1414598400000");
////		map.put("repairEndTime", "1414598400000");
////		map.put("repairDescription", "666666");
////		map.put("status", "3");
//		String msg = HttpClientUtils.post("http://v.cc-railway.xzh-soft.com:8083/equipmentRepair/repairList.json",map);
//		System.out.println("msg:"+msg);
//	}
	
	
	public static void main(String[] args) {
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	            HttpPost httppost = new HttpPost("http://211.137.14.52:8080/AnyChat/upload");
	 
	            FileBody data = new FileBody(new File("E:\\key.txt"));
	 
	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("data", data)
	                    .build();
	 
	            httppost.setEntity(reqEntity);
	 
	            System.out.println("executing request " + httppost.getRequestLine());
	            CloseableHttpResponse response = null;
	            try {
	            	response = httpclient.execute(httppost);
	                System.out.println("----------------------------------------");
	                System.out.println(response.getStatusLine());
	                HttpEntity resEntity = response.getEntity();
	                String msg = EntityUtils.toString(resEntity, "UTF-8");
	                EntityUtils.consume(resEntity);
	                System.out.println("return:" + msg);
	            } catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					IOUtils.closeQuietly(response);
	            }
	        } finally {
	        	IOUtils.closeQuietly(httpclient);
	        }
	}
}
