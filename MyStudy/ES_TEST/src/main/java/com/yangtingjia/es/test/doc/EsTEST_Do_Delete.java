package com.yangtingjia.es.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Do_Delete {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //删除数据
        DeleteRequest request = new DeleteRequest();
        request.index("customer").id("1001");

        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        //关闭es客户端
        esClient.close();

    }
}
