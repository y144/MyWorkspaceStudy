package com.yangtingjia.es.test.base;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Client {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //关闭es客户端
        esClient.close();

    }
}
