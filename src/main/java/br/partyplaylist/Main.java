package br.partyplaylist;

import java.util.HashMap;
import java.util.Map;

import com.mashape.unirest.http.JsonNode;

public class Main {

	public static void main(String args[]){
		//curl -X GET "https://api.spotify.com/v1/users/wizzler/playlists" 
		// -H "Accept: application/json" 
		// -H "Authorization: Bearer BQCs-8m_tDJlu0X7l9gdmiUoyHdljhtDl2nafQIOv7AKEJmDezkrjYrs1IfUKui5B1qfuA9BkA8Q0Ii7rsxXXKk7YLXYWl2d8fe4ULVMBi3TR4osHwY5jbTfZO6yqF4N3uBASaXRad17uk-v"

		String uri = "https://api.spotify.com/v1/users/1122902400/playlists";
		
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Accept","application/json");
		headers.put("Authorization","Bearer BQCs-8m_tDJlu0X7l9gdmiUoyHdljhtDl2nafQIOv7AKEJmDezkrjYrs1IfUKui5B1qfuA9BkA8Q0Ii7rsxXXKk7YLXYWl2d8fe4ULVMBi3TR4osHwY5jbTfZO6yqF4N3uBASaXRad17uk-v");
		
		RESTRetreiver retreiver = new RESTRetreiver();
		
		JsonNode node = retreiver.get(uri, headers);
		
		System.out.println(node);
	}
}
