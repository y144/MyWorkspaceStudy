package com.yangtingjia.es.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;

/**
 * 杨廷甲
 * 2023-02-26
 */
public class EsTEST_Doc_Query1 {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));


        //1.组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 15));
//
//        builder.query(boolQueryBuilder);
//        request.source(builder);
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

        //7.范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//        rangeQueryBuilder.gte(30);
//        rangeQueryBuilder.lte(50);
//
//        builder.query(rangeQueryBuilder);
//        request.source(builder);
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

        //8.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzziness = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE);
//
//
//        builder.query(fuzziness);
//        request.source(builder);
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


        //9.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<front color='red'>");
//        highlightBuilder.postTags("</front>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termQueryBuilder);
//
//        request.source(builder);
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

        //10聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("customer");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("ageAge").field("age");
//
//        builder.aggregation(maxAggregationBuilder);
//
//        request.source(builder);
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

        //分组查询
        SearchRequest request = new SearchRequest();
        request.indices("customer");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");

        builder.aggregation(termsAggregationBuilder);

        request.source(builder);
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
