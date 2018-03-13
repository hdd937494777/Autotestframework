package com.mizlicai.eudemon.mng.utils;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.StringUtils.replace;

/**
 * 
 * 
 * 
 *
 * Created by chars on 2015 下午4:31:12.
 *
 * Copyright © mizhuanglicai
 */
public final class HttpRequest {

	static Log logger = LogFactory.getLog(HttpRequest.class);

	public static HttpClient httpClient = null;

	public static HttpClient getHttpClient() {
		if (httpClient == null)
			httpClient = HttpClients.createDefault();
		return httpClient;
	}

	public static RequestConfig getRequestConfig() {
		return RequestConfig.custom().setConnectTimeout(10000)
				.setSocketTimeout(30000).build();
	}

	public static String httpGet(String url, String encoding) {
		if (!hasText(encoding)) {
			encoding = Utils.UTF_8;
		}
		HttpGet get = new HttpGet(url);
		get.setConfig(getRequestConfig());
		String content = "";
		try {
			HttpResponse response = getHttpClient().execute(get);
			switch (response.getStatusLine().getStatusCode()) {
			case 200:
			case 304:
				content = EntityUtils.toString(response.getEntity(), encoding);
				break;
			default:
				break;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> get(String url, String param,
			String charEncoding) {
		Map<String, Object> result = new HashMap<String, Object>();
		String str = sendGet(url, param, charEncoding);
		str = replace(str, "\r", "");
		str = replace(str, "\n", "");
		str = replace(str, "\t", "");
		try {
			result = JacksonJsonMapper.getInstance().readValue(str, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// @SuppressWarnings("unchecked")
	// public static Map<String, Object> post(String url, String param) {
	// Map<String, Object> result = new HashMap<String, Object>();
	// String str = sendPost(url, param);
	// try {
	// result = JacksonJsonMapper.getInstance().readValue(str, Map.class);
	// } catch (JsonParseException e) {
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

	// public static void main(String[] args) throws Exception {
	// System.out.println(getProvinceFromMobile("18657160700"));
	// }

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param, String charEncoding) {

		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + (param != null ? ("?" + param) : "");
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection
					.setRequestProperty("accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("accept-language",
					"zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			connection.setRequestProperty("accept-encoding", "gzip, deflate");
			connection
					.setRequestProperty(
							"user-agent",
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:32.0) Gecko/20100101 Firefox/32.0");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				logger.debug(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(),
					hasText(charEncoding) ? charEncoding : CharEncoding.UTF_8));
			StringBuilder line = new StringBuilder();
			char[] cbuf = new char[1024];
			int len = 0;
			while ((len = in.read(cbuf)) != -1) {
				line.append(cbuf, 0, len);
			}
			result = line.toString();
			logger.debug("--->" + result);
		} catch (Exception e) {
			logger.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendAixuedaiGet(String url, String param, String charEncoding) {

        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + (param != null ? ("?" + param) : "");
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection
                    .setRequestProperty("accept",
                            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("accept-language",
                    "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
            connection.setRequestProperty("accept-encoding", "gzip, deflate");
            connection
                    .setRequestProperty(
                            "User-Agent", "longhz-sdk-java");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                logger.debug(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),
                    hasText(charEncoding) ? charEncoding : CharEncoding.UTF_8));
            StringBuilder line = new StringBuilder();
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = in.read(cbuf)) != -1) {
                line.append(cbuf, 0, len);
            }
            result = line.toString();
            logger.debug("--->" + result);
        } catch (Exception e) {
            logger.error("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), CharEncoding.UTF_8));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

    /**
     * 向指定 URL 发送POST方法的请求
     * 向资管系统发送请求，使用的 User-Agent 不一样
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendAiXueDaiPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "longhz-sdk-java");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), CharEncoding.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
