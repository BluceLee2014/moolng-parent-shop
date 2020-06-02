package com.moolng.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class ElasticSearchAPITest502 {

    private static final String HTTP_HOST = "127.0.0.1";
    private static final String CLUSTER_NAME = "127.0.0.1";
    private static final int PORT = 5100;

    private static final String index = "moolng_01_index";
    private static final String type = "moolng_01_type";


    public static TransportClient client() {


        TransportAddress node = null;
        try {
            node = new InetSocketTransportAddress(InetAddress.getByName(HTTP_HOST), PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Settings settings = Settings.builder()
//                    .put("cluster.name",esConfig.getClusterName())
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }

    public static void main(String[] args) {
        TransportClient client = client();


        // name like '%张%'
        WildcardQueryBuilder matchQueryBuilder = QueryBuilders.wildcardQuery("title", "*java*");
//// score > 90
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("score");
//        rangeQuery.gt(90);
//// level = 'A'
//        TermQueryBuilder termQuery = QueryBuilders.termQuery("level", "A");

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchQueryBuilder); // name like '%张%' and
//        boolBuilder.must(rangeQuery); // score > 90
//        boolBuilder.should(termQuery);// or level = 'A'

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // limit 10 20
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.query(boolBuilder);


        try {
            //查询索引对象
            SearchRequest searchRequest = new SearchRequest(index);
            searchRequest.types(type);
            searchRequest.source(sourceBuilder);
            SearchResponse response = client.search(searchRequest).get();
            System.out.println(response);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("====> end");
    }


}
