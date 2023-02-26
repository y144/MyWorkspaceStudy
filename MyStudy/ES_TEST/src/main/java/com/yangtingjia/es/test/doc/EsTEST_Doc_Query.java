package com.yangtingjia.es.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;
import javax.swing.*;
import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Doc_Query {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        //1.查询数据
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits responseHits = response.getHits();
//        System.out.println(responseHits);
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit responseHit : responseHits) {
//            System.out.println(responseHit.getSourceAsString());
//        }

        //2.条件查询 termQuery
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30));
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits responseHits = response.getHits();
//        System.out.println(responseHits);
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit responseHit : responseHits) {
//            System.out.println(responseHit.getSourceAsString());
//        }

        //3.分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        query.from(2); //（当前页面-1）* 每页显示的条数
//        query.size(2);
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits responseHits = response.getHits();
//        System.out.println(responseHits);
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit responseHit : responseHits) {
//            System.out.println(responseHit.getSourceAsString());
//        }

        //4.排序
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        query.sort("age", SortOrder.DESC);
//        request.source(query);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits responseHits = response.getHits();
//        System.out.println(responseHits);
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit responseHit : responseHits) {
//            System.out.println(responseHit.getSourceAsString());
//        }

        //5.过滤字段
        SearchRequest request = new SearchRequest();
        request.indices("customer");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] inClude = {"name"}; //包含的字段
        String[] exClude = {}; //不包含的字段
        query.fetchSource(inClude,exClude);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits responseHits = response.getHits();
        System.out.println(responseHits);
        System.out.println(responseHits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit responseHit : responseHits) {
            System.out.println(responseHit.getSourceAsString());
        }


        //关闭es客户端
        esClient.close();

    }
}
