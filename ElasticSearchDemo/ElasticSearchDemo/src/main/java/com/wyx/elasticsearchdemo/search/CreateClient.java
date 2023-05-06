package com.wyx.elasticsearchdemo.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

/**
 * @BelongsProject: ElasticSearchDemo
 * @BelongsPackage: com.wyx.elasticsearchdemo.search
 * @Author: Origami
 * @Date: 2023/5/6 14:26
 */
public class CreateClient {
    public static ElasticsearchClient create_client(String ip, int port) {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                new HttpHost(ip, port)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        return new ElasticsearchClient(transport);
    }


}
