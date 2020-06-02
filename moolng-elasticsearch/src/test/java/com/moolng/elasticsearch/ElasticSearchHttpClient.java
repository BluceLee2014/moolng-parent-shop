package com.moolng.elasticsearch;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.lucene.queryparser.xml.builders.SpanOrTermsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElasticSearchHttpClient {

    private static final String URL = "http://115.29.34.243:55601/api/console/proxy?uri=%2Fsyp%2FbbsInfo%2F_search";

    public static void main(String[] args) {
//        String params = "{\"query\":{\"bool\":{\"should\":[{\"bool\":{\"filter\":{\"script\":{\"script\":{\"inline\":\"((doc['oldPrice'].length == 0) || (doc['oldPrice'].value - doc['bbsprice'].value == 0)) && (doc['discountPutawayState'].value == 0) && (doc['soldstate'].value == 0)\",\"lang\":\"painless\"}}}}}],\"must\":[{\"term\":{\"userid\":1038111610}},{\"range\":{\"createtime\":{\"lte\":\"2020-05-22 15:42:14\"}}}]}},\"from\":0,\"size\":20}";
//        String post = doPost(URL, null, params);
//        System.out.println(post);
        try {
            login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setHeader(HttpPost httpPost) {
        httpPost.setHeader("host", "www.oschina.net");
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
        httpPost.setHeader("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpPost.setHeader("Accept-Language",
                "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        // httpPost.setHeader("Referer", "https://www.oschina.net/home/login");
        httpPost.setHeader("Connection", "keep-alive");
    }

        // http://115.29.34.243:55601/api/security/v1/login
    public static void login() throws IOException {
        String url = "http://115.29.34.243:55601/api/security/v1/login";
        // 初始化 httpclient
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.addHeader("kbn-version", "5.0.2");
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        // {"username":"elastic","password":"superzsh123"}
        String params = "{\"username\":\"elastic\",\"password\":\"superzsh123\"}";
        httpPost.setEntity(new StringEntity(params, Charset.forName("UTF-8")));

        CloseableHttpResponse response = closeableHttpClient.execute(httpPost);

        HttpPost p2 = new HttpPost("http://115.29.34.243:55601/api/console/proxy?uri=%2Fsyp%2FbbsInfo%2F_search");
        p2.addHeader("Content-type", "application/json; charset=utf-8");
        p2.addHeader("kbn-version", "5.0.2");
        String requestStr2 = "{\"query\":{\"bool\":{\"should\":[{\"bool\":{\"filter\":{\"script\":{\"script\":{\"inline\":\"((doc['oldPrice'].value == 0) || (doc['oldPrice'].value - doc['bbsprice'].value == 0)) && (doc['discountPutawayState'].value == 0) && (doc['soldstate'].value == 0)\",\"lang\":\"painless\"}}},\"must\":[{\"term\":{\"userid\":{\"value\":\"1038111610\"}}},{\"range\":{\"createtime\":{\"lte\":\"2018-08-20 15:42:14\"}}}]}}]}},\"from\":0,\"size\":200}";
        p2.setEntity(new StringEntity(requestStr2, Charset.forName("UTF-8")));
        HttpResponse r3 = closeableHttpClient.execute(p2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        r3.getEntity().writeTo(baos);
        baos.flush();

//        HttpGet httpGet = new HttpGet(
//                "http://115.29.34.243:55601/app/kibana#/dev_tools/console?_g=()");
//        HttpResponse response2 = closeableHttpClient.execute(httpGet);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        response2.getEntity().writeTo(baos);
//        baos.flush();
        // 打印http://my.oschina.net/u/1167421/admin/profile的html代码
        System.out.println(baos.toString("utf-8"));
        // 打印响应头
        Header[] headers = response.getAllHeaders();
        for (Header h : headers) {
            System.out.println(h.getName() + "=" + h.getValue());
        }
    }

    public static String doPost(String url, Header[] headers, String params) {
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        //设置请求头
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        try {
            httpPost.setEntity(new StringEntity(params, Charset.forName("UTF-8")));
//            httpPost.setHeaders(headers);
//            List<NameValuePair> pairList = new ArrayList<>();
//            for (Map.Entry<String, Object> entry : paramMaps.entrySet()) {
//                String key = entry.getKey();
//                String value = (String) entry.getValue();
//                pairList.add(new BasicNameValuePair(key, value));
//            }
//            UrlEncodedFormEntity urlEntity = new UrlEncodedFormEntity(pairList, "UTF-8");
//            httpPost.setEntity(urlEntity);
            HttpResponse resp = closeableHttpClient.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(resp.getEntity(), "UTF-8").trim();
            }
        } catch (Exception e) {
            throw new RuntimeException("HTTP post failed.", e);
        } finally {
            httpPost.abort();
            try {
                closeableHttpClient.close();
            } catch (Exception e2) {
                throw new RuntimeException("Close CloseableHttpClient failed.", e2);
            }
        }

        return result;
    }


    // 使用代理服务器IP 请求出去
    /*public static String doHttpsPost(String url, Header[] headers, Map<String, Object> paramMaps) {
        // 设置代理
        HttpHost proxy = new HttpHost(代理IP, 端口号, "http");
        RequestConfig defaultRequestConfig = RequestConfig.custom().setProxy(proxy).build();

        String result = null;
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setHeaders(headers);
            httpPost.setEntity(httpEntity);
            httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
            HttpResponse resp = httpClient.execute(httpPost);
            result = EntityUtils.toString(resp.getEntity(), "UTF-8").trim();
        } catch (Exception e) {
            throw new RuntimeException("HTTP Post failed.", e);
        } finally {
            httpPost.abort();
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException("Close CoseabledHttpClient failed.", e);
            }
        }
        return result;
    }*/
}
