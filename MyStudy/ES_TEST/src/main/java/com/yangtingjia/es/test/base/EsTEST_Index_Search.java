package com.yangtingjia.es.test.base;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Index_Search {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //查询索引
        GetIndexRequest request = new GetIndexRequest("customer");
        GetIndexResponse createIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);

        //响应结果
        System.out.println(createIndexResponse.getAliases());
        System.out.println(createIndexResponse.getMappings());
        System.out.println(createIndexResponse.getSettings());


        //关闭es客户端
        esClient.close();

    }
}
