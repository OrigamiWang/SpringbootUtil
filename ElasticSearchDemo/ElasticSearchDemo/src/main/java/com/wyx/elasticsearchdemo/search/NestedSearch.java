package com.wyx.elasticsearchdemo.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.wyx.elasticsearchdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @BelongsProject: ElasticSearchDemo
 * @BelongsPackage: com.wyx.elasticsearchdemo.search
 * @Author: Origami
 * @Date: 2023/5/6 14:51
 */
public class NestedSearch {

    private static <T> void processProduct(T p) {
        System.out.println(p);
    }

    public static <T> void query(ElasticsearchClient client, Class<T> clazz, String index, String fieldName, String key, double between, double and) throws IOException {
        String searchText = key;

// Search by product name
        Query byName = MatchQuery.of(m -> m
                .field(fieldName)
                .query(searchText)
        )._toQuery();

// Search by max price
        Query byMaxPrice = RangeQuery.of(r -> r
                .field(fieldName)
                // less than equal <=
                .lte(JsonData.of(and))
                // greater than equal >=
                .gte(JsonData.of(between))
        )._toQuery();

// Combine name and price queries to search the product index
        SearchResponse<T> response = client.search(s -> s
                        .index(index)
                        .query(q -> q
                                .bool(b -> b
                                        .must(byName)
                                        .must(byMaxPrice)
                                )
                        ),
                clazz
        );

        for (Hit<T> hit : response.hits().hits()) {
            processProduct(hit.source());
        }

    }
}
