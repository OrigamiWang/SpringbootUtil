package com.wyx.elasticsearchdemo.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;

import java.io.IOException;

/**
 * @BelongsProject: ElasticSearchDemo
 * @BelongsPackage: com.wyx.elasticsearchdemo.search
 * @Author: Origami
 * @Date: 2023/5/6 14:25
 */
public class SingleSearch {
    private static <T> void processProduct(T p) {
        System.out.println(p);
    }

    public static <T> void query(ElasticsearchClient client, Class<T> clazz, String index, String fieldName, String key) throws IOException {
        SearchResponse<T> response = client.search(s -> s
                        .index(index)
                        .query(q -> q
                                .term(t -> t
                                        .field(fieldName)
                                        .value(v -> v.stringValue(key))
                                )),
                clazz);

        for (Hit<T> hit : response.hits().hits()) {
            processProduct(hit.source());
        }


    }
}
