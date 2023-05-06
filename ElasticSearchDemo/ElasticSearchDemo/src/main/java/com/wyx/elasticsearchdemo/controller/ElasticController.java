package com.wyx.elasticsearchdemo.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.wyx.elasticsearchdemo.entity.Product;
import com.wyx.elasticsearchdemo.search.NestedSearch;
import com.wyx.elasticsearchdemo.search.SingleSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.wyx.elasticsearchdemo.search.CreateClient.create_client;

/**
 * @BelongsProject: ElasticSearchDemo
 * @BelongsPackage: com.wyx.elasticsearchdemo.controller
 * @Author: Origami
 * @Date: 2023/5/6 11:55
 */
@RestController
public class ElasticController {

    @ModelAttribute
    public ElasticsearchClient init() {
        return create_client("localhost", 9200);
    }


    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/single")
    public String test_es_single(ElasticsearchClient client) throws IOException {

        SingleSearch.query(client, Product.class, "products", "name", "bike");
        return "success";
    }

    @GetMapping("/nest")
    public String test_es_nest(ElasticsearchClient client) throws IOException {
        NestedSearch.query(client, Product.class, "products", "name", "bike", 50, 200);
        return "success";
    }

}
