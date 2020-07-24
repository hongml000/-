package com.xiaobudian.demo.test;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.xiaobudian.demo.util.SignUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author Lorrain
 * @CreateTime 2019-05-09 14:08
 */
public class MyTest {

    @Test
    public void test1() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://119.147.216.228:8080/storage-api/hello");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null){
            System.out.println(EntityUtils.toString(entity, Charset.forName("UTF-8")));
        }
        EntityUtils.consume(entity);
    }


    String appKey = "eQ8eyDb0IpNyXWkI";
    String appSecret = "RmARiVtFDMQ9LYapfEjbbRjwIbrVV55f";
    String putObjUrl = "http://119.147.216.228:8080/storage-api/storage/object";

    @Test
    public void testPutObj() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(putObjUrl);

        String objectKey = "12345678ABCdef.jpg";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("bucketName", "oss-prod1");
        paramMap.put("objectKey", objectKey);
        paramMap.put("appKey", appKey);
        paramMap.put("cover", "1");
        String timestamp = System.currentTimeMillis() + "";
        paramMap.put("timestamp", timestamp);
        String sign = SignUtils.genSignWithMD5(paramMap, appSecret);

        httpPost.setHeader("appKey", appKey);
        httpPost.setHeader("timestamp", timestamp);
        httpPost.setHeader("sign", sign);

        httpPost.setEntity(getHttpEntity(paramMap, new File("./test.jpg")));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null){
            System.out.println(EntityUtils.toString(entity, Charset.forName("UTF-8")));
        }
        EntityUtils.consume(entity);

    }

    String listObjUrl = "http://119.147.216.228:8080/storage-api/storage/bucket";

    @Test
    public void testListObj() throws Exception{

        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(listObjUrl);

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("bucketName", "oss-prod1");
        paramMap.put("appKey", appKey);
        paramMap.put("pageNo", "1");
        paramMap.put("pageSize", "10");
        String timestamp = System.currentTimeMillis() + "";
        paramMap.put("timestamp", timestamp);
        String sign = SignUtils.genSignWithMD5(paramMap, appSecret);

        uriBuilder.addParameter("bucketName", "oss-prod1");
        uriBuilder.addParameter("pageNo", "1");
        uriBuilder.addParameter("pageSize", "10");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("appKey", appKey);
        httpGet.setHeader("timestamp", timestamp);
        httpGet.setHeader("sign", sign);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null){
            System.out.println(EntityUtils.toString(entity, Charset.forName("UTF-8")));
        }
        EntityUtils.consume(entity);
    }

    @Test
    public void testDownloadObj() throws Exception{
        String url = "http://119.147.216.228:8080/storage-api/storage/object/content/oss-prod1/12345678ABCDEF.JPG?expire=1557471278978&sign=A0A5CF0112BF728565D65676C1B5064B1FD5595485DB1095AE1D1384713FB8E8";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appKey", appKey);
        String timestamp = System.currentTimeMillis() + "";
        paramMap.put("timestamp", timestamp);
        String sign = SignUtils.genSignWithMD5(paramMap, appSecret);
        httpGet.setHeader("appKey", appKey);
        httpGet.setHeader("sign", sign);
        httpGet.setHeader("timestamp", timestamp);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        FileOutputStream stream = new FileOutputStream(new File("D:\\xiaobudian\\download.jpg"));
        entity.writeTo(stream);
        stream.flush();
        EntityUtils.consume(entity);

    }

    @Test
    public void testBucketAcl(){

        String accessKey = "OY5D6FZGW83POLSU294O";
        String secretKey = "Zt2lfSkOK8poxeOTtt03BPnxOaxjtHDMoadMWlVX";
        String endpoint = "119.147.216.228:7480";
        String bucketName = "oss-prod1";

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration configuration = new ClientConfiguration();
        configuration.setProtocol(Protocol.HTTP);
        AmazonS3 amazonS3 = new AmazonS3Client(credentials, configuration);
        amazonS3.setEndpoint(endpoint);
        amazonS3.setBucketAcl(bucketName, CannedAccessControlList.Private);


    }



    private HttpEntity getHttpEntity(Map<String, String> map , File file) throws Exception{
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for (String key : map.keySet()) {
            builder.addPart(key, new StringBody(map.get(key)));
        }

        if (file != null){
            builder.addPart("file", new FileBody(file));
        }

        return builder.build();
    }

}