package com.yangtingjia.es.test.base;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Index_Create {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("customer");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);

        //响应结果
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("创建索引的响应结果：" + acknowledged);


        //关闭es客户端
        esClient.close();

    }
}
