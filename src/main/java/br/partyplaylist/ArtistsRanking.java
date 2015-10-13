package br.partyplaylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

public class ArtistsRanking {
	
	
	private int n;

	public ArtistsRanking(int n){
		this.n = n;
	}
	
	public List<String> getTopArtistsIds(List<JsonNode> playListTracks){
		List<String> topArtistsId = new ArrayList<String>();
		Map<String,Integer> counter = new HashMap<String, Integer>();
		
		System.out.println("---------------");
		for (JsonNode jsonNode : playListTracks) {
			JSONArray items = jsonNode.getObject().getJSONArray("items");
			
			
			for (int i = 0; i < items.length(); i++) {
				JSONObject obj = (JSONObject) items.get(i);
				JSONArray artists = obj.getJSONObject("track").getJSONArray("artists");
				
				
//				System.out.println(obj);
//				System.out.println(obj.getJSONObject("track"));
//				System.out.println(artists);
				
				for (int j = 0; j < artists.length(); j++) {
					JSONObject artist = (JSONObject) artists.get(j);
					String artistId = artist.getString("id");
					
//					System.out.println(artistId);
					int count = 0;
					if(counter.containsKey(artistId)){
						count = counter.get(artistId);
					}
					count += 1;
					counter.put(artistId, count);
				}
				
//				JSONArray items = jsonNode.getObject().getJSONArray("items");
				
				
				
//				String artistId = artistIds.getString(i);
				
			}
		}

		if(counter.size() < this.n){
			return new ArrayList<String>(counter.keySet());
		}
		
		SortedSet<ArtistCount> sortedCounts = new TreeSet<ArtistsRanking.ArtistCount>();
		
		Set<String> ids = counter.keySet();
		
		for (String key : ids) {
			ArtistCount aCount = new ArtistCount();
			aCount.count = counter.get(key);
			aCount.id = key;
			
			System.out.println("Adding artist count id = "+aCount.id+" count ="+aCount.count);
			sortedCounts.add(aCount);
		}
		
		Iterator<ArtistCount> it = sortedCounts.iterator();
		int addedCount = 0;
		
		while(it.hasNext() && addedCount < this.n){
			topArtistsId.add(it.next().id);
			
			addedCount++;
		}
		
		return topArtistsId;
	}
	
	class ArtistCount implements Comparable<ArtistCount>{
		String id;
		int count;
		
		
		public int compareTo(ArtistCount o) {
			return (new Integer(count)).compareTo(o.count);
		}
		
	}

}
