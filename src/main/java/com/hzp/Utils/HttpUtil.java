package com.hzp.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtil {
	
	/*
	 * 发送GET请求
	 */
		public static String  sendGet(String url,String ...params) {
			if (params!=null&&params.length>0) {
				url = url +"?"+params[0];
			}
			String result = null;
			/*
			 * 生成url
			 * 连接对象
			 */
			try {
				URL sendurl = new URL(url);
				URLConnection conn  = sendurl.openConnection();
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
				conn.setRequestProperty("Accept-Charset", "utf-8");
				conn.setRequestProperty("contentType", "utf-8");
				
				conn.connect();
				result = getResult(conn);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * 发送post请求
		 */
		public static String sendPost(String url,String...params) {
			/*
			 * 生成url
			 * 连接对象
			 */
			String result = null;
			try {
				URL sendUrl = new URL(url);
				URLConnection conn = sendUrl.openConnection();
//			设置连接头信息
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
				conn.setDoInput(true);
				conn.setDoOutput(true);
				
				if(params!=null&&params.length>0) {
					PrintWriter pw = new PrintWriter(conn.getOutputStream());
					URLEncoder.encode(params[0],"UTF-8");
					pw.println(params[0]);
					pw.flush();
				}
				result = getResult(conn);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		private static String  getResult(URLConnection conn) {
			String result = null;
			BufferedReader bReader = null;
			Map<String, List<String>> headers = conn.getHeaderFields();
			headers.forEach((k,v)->{
				v.stream().forEach((value)->{
					System.out.println(k+":"+value);
				});
			});
			try {
				bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				result = bReader.lines().collect(Collectors.joining(System.lineSeparator()));
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				if (bReader!=null) {
					try {
						bReader.close();
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			return result;
			}
}
