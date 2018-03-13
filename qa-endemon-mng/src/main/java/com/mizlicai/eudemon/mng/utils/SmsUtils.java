package com.mizlicai.eudemon.mng.utils;

import com.esms.PostMsg;
import com.esms.common.entity.Account;
import com.esms.common.entity.AccountInfo;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SmsUtils
{

	// 爱学贷
	public final static String axdPwd = "hangzxf713";
	public final static String axdQueryUrl = "http://182.254.141.209:8888/Modules/Interface/http/Iservices.aspx";
	public final static String axdUserid = "hangzxf";


	// 梦网科技
	public final static String mwkjPassword = "582223";
	public final static String mwkjQueryUrl = "http://61.130.7.220:8023/mwgate/wmgw.asmx/MongateQueryBalance";
	public final static String mwkjUserId = "J50673";


	public final static int TIMEOUT = 10000;
	
	public static String queryBalance(String channelName){
		if("梦网".equals(channelName)){
			return mengWangQueryBalance();
		}else if("爱学贷".equals(channelName)){
			return axdQueryBalance();
		}else if("玄武".equals(channelName)){
			return xuanWuQueryBlance();
		}else{
			return null;
		}
	}
	
	/**
	 *	查询梦网通道可发送条数
	 */
	public static String mengWangQueryBalance(){
		try {
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			
			final StringBuffer buffer = new StringBuffer(mwkjQueryUrl);
			buffer.append("?userId=" + mwkjUserId + "&password="
					+ mwkjPassword );
	
			final HttpGet httpGet = new HttpGet(buffer.toString());
	
			final RequestConfig config = RequestConfig.custom()
					.setConnectionRequestTimeout(TIMEOUT)
					.setConnectTimeout(TIMEOUT)
					.setSocketTimeout(TIMEOUT).build();
			httpGet.setConfig(config);
	
			final CloseableHttpResponse response1 = httpclient.execute(httpGet);
			final HttpEntity entity1 = response1.getEntity();
			if (entity1 != null) {
				final String response = EntityUtils.toString(entity1, "UTF-8");
				
				Document doc = null;
				doc = DocumentHelper.parseText(response);
				final Element rootElt = doc.getRootElement();
				final String result = rootElt.getData().toString();
				
				return result ;//单位条数
			}
			return null;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String axdQueryBalance(){
		try {
			final CloseableHttpClient httpclient = HttpClients.createDefault();

			final HttpPost httpPost = new HttpPost(axdQueryUrl);
			final RequestConfig config = RequestConfig.custom()
					.setConnectionRequestTimeout(TIMEOUT)
					.setConnectTimeout(TIMEOUT)
					.setSocketTimeout(TIMEOUT).build();
			httpPost.setConfig(config);
			final List<NameValuePair> parameters = new ArrayList<NameValuePair>();

			parameters.add(new BasicNameValuePair("flag", "sblance"));
			parameters.add(new BasicNameValuePair("loginname",axdUserid));
			parameters.add(new BasicNameValuePair("password",axdPwd));

			final HttpEntity he = new UrlEncodedFormEntity(parameters,
					StandardCharsets.UTF_8);
			httpPost.setEntity(he);
			final CloseableHttpResponse response1 = httpclient
					.execute(httpPost);
			final HttpEntity entity1 = response1.getEntity();
			if (entity1 != null) {
				//0#短信条数#包月条数  
				final String response = EntityUtils.toString(entity1, "UTF-8");
				return response.split("#")[1];//单位条数
			}
			return null;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询玄武接口
	 * @return
	 */
	public static String xuanWuQueryBlance(){
		final Account ac = new Account("hzxfzc@hzxfzc", "6wz7u7zf");
		final PostMsg pm = new PostMsg();
		pm.getCmHost().setHost("211.147.239.62", 8450);
		pm.getWsHost().setHost("211.147.239.62", 8460);
		try
		{
			AccountInfo accountInfo = pm.getAccountInfo(ac);
			return accountInfo.getBalance()/100+""; // 元为单位
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static void main(String args[]){
		//SmsUtils.queryBalance("梦网");
//		System.out.println(SmsUtils.queryBalance("爱学贷"));
		System.out.println(SmsUtils.queryBalance("玄武"));
	}
}
