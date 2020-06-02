package com.moolng.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

public class ElasticSearchAPITest688 {

    private static final String HTTP_HOST = "127.0.0.1";
    private static final int PORT = 5100;

    private RestClientBuilder builder;
    private RestClient restClient;
    private RestHighLevelClient restHighLevelClient;

//    @Before
    public void initConfig(){
        HttpHost host = new HttpHost(HTTP_HOST, PORT);
        builder = RestClient.builder(host);
        restClient = builder.build();
        restHighLevelClient = new RestHighLevelClient(builder);
        System.out.println("===> before");
    }

    @Test
    public void search(){
        initConfig();
//        System.out.println("===> test");
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("wxNo", "wx_hfo8q7sr0k");
        boolBuilder.must(matchQueryBuilder);


        boolBuilder.should()

        sourceBuilder.query(boolBuilder); //设置查询，可以是任何类型的QueryBuilder。
        sourceBuilder.from(0); //设置确定结果要从哪个索引开始搜索的from选项，默认为0
        sourceBuilder.size(100);

        SearchRequest searchRequest = new SearchRequest("moolng_01_nearby");
        searchRequest.types("wechat");
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();  //SearchHits提供有关所有匹配的全局信息，例如总命中数或最高分数：
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {
                System.out.println(hit.getSourceAsString());
            }
            Arrays.toString(searchHits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
