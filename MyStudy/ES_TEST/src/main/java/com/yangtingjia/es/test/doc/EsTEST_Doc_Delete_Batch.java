package com.yangtingjia.es.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Doc_Delete_Batch {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //批量插入数据
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("customer").id("1001"));
        request.add(new DeleteRequest().index("customer").id("1002"));
        request.add(new DeleteRequest().index("customer").id("1003"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());

        //关闭es客户端
        esClient.close();

    }
}
