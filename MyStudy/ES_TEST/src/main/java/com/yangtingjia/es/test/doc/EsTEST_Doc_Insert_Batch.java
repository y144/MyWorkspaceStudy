package com.yangtingjia.es.test.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangtingjia.es.dto.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //批量插入数据
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("customer").id("1001").source(XContentType.JSON,"name","zhangsan","age",30,"sex","男"));
        request.add(new IndexRequest().index("customer").id("1002").source(XContentType.JSON,"name","list","age",31,"sex","女"));
        request.add(new IndexRequest().index("customer").id("1003").source(XContentType.JSON,"name","wangwu","age",20,"sex","男"));
        request.add(new IndexRequest().index("customer").id("1004").source(XContentType.JSON,"name","wangwu1","age",22,"sex","女"));
        request.add(new IndexRequest().index("customer").id("1005").source(XContentType.JSON,"name","wangwu2","age",15,"sex","男"));
        request.add(new IndexRequest().index("customer").id("1006").source(XContentType.JSON,"name","wangwu3","age",36,"sex","女"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());

        //关闭es客户端
        esClient.close();

    }
}
