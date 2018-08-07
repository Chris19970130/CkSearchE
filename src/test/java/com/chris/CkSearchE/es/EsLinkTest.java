package com.chris.CkSearchE.es;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

public class EsLinkTest {
	@Test
	public void test(){
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost("localhost", 9200, "http")
		                ));
		
		GetRequest getRequest = new GetRequest(
		        "bank", 
		        "_doc",  
		        "1");
		
		try {
			GetResponse response = client.get(getRequest);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
