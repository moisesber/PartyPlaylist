package br.partyplaylist;

import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class RESTRetreiver {
	
	
	public JsonNode get(String uri, Map<String,String> headers){
		
		//curl -X GET "https://api.spotify.com/v1/users/wizzler/playlists" 
		// -H "Accept: application/json" 
		// -H "Authorization: Bearer BQCs-8m_tDJlu0X7l9gdmiUoyHdljhtDl2nafQIOv7AKEJmDezkrjYrs1IfUKui5B1qfuA9BkA8Q0Ii7rsxXXKk7YLXYWl2d8fe4ULVMBi3TR4osHwY5jbTfZO6yqF4N3uBASaXRad17uk-v"
		
		HttpResponse<JsonNode> response;
		try {
			 response = Unirest.get(uri).headers(headers).asJson();
				
			return response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
//		String jason = Unirest.get(uri)
////		  .queryString("name", "Mark")
//		  .field("last", "Polo")
//		  .asJson();
	}

}
