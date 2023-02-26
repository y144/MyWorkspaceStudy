package com.yangtingjia.es.test.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangtingjia.es.dto.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Do_Update {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

       //插入数据
        UpdateRequest request = new UpdateRequest();
        request.index("customer").id("1001");
        request.doc(XContentType.JSON,"sex","女");

        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();
        System.out.println(result);

        //关闭es客户端
        esClient.close();

    }
}
