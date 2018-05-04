package com.roh.prac;

import java.awt.im.InputMethodHighlight;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * { 
 * 	"90, google.com",
 * 	"1000, yahoo.com",
 * 	"15, mail.yahoo.com",
 * 	"125, gmail.com",
 * }
 * @author knidhi
 *
 */
public class HitsOnDomainName {
	
	public static Map<String, Integer> findIndividualHits(List<String>  hits)
	{
		if(hits == null || hits.size() == 0)
			return null;
		
		Map<String, Integer> indHits = new HashMap<>();
		String word = "";
		for(String entry : hits) {
			String[] items = entry.split(",");
			int count = Integer.parseInt(items[0]);
			String[] d = items[1].split("\\.");
			List<String> subDomains = Arrays.asList(items[1].split("."));
			
			for(int i = 0; i < subDomains.size(); i++ ) {
				word = String.join(".", subDomains.subList(i, subDomains.size()));
				if(indHits.getOrDefault(word, 0) == 0) {
					indHits.put(word, count);
				} else {
					int counts = indHits.get(word);
					indHits.put(word, counts + count);
				}
			}
				
			
		}
		
		
	
		return indHits;
	}
	 

	public static void main(String[] args) {
		List<String>  hits = new ArrayList<>();
		hits.add("90,google.com");
		hits.add("1000,yahoo.com");
		hits.add("15,mail.yahoo.com");
		hits.add("125,gmail.com");
				 
		
		System.out.println(findIndividualHits(hits));

	}

}
