package com.yangtingjia.es.test.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangtingjia.es.dto.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Doc_Insert {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

       //插入数据
        IndexRequest request = new IndexRequest();
        request.index("customer").id("1001");

        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(22);

        //向ES中插入数据，必须将数据转化为json格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();
        System.out.println(result);

        //关闭es客户端
        esClient.close();

    }
}
