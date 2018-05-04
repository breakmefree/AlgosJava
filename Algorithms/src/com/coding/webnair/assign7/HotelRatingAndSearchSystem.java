package com.coding.webnair.assign7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

/**
 * Problem statements:
 * (1) Given a Hotel rating and search system. Users put rating out of 10 for a hotel. We need to write a method (lets say: hotelSearch(String fileName, double score)) to consume a file with these ratings and return all hotels whose rating is more than a given score.
 * Example file: <user, hotel id, rating>
 * u1,1,10
 * u2,1,10
 * u3,1,9
 * u1,2,6
 * u2,2,7
 * u3,2,6
 * u1,3,9
 * u2,3,9
 * u3,3,8
 * 
 * So in this case hotelSearch(file, 8.0) returns => 1, 3
 * @author Kshama Nidhi
 */
public class HotelRatingAndSearchSystem 
{
	private static ArrayList<String> searchHotel(TreeMap<Double, ArrayList<String>> scoreToHotelListMap, double score){
		ArrayList<String> list = new ArrayList<>();
		double movingScore = score;
		double keyScore = 0.0;

        // BST: scoreToHotelListMap

        while(scoreToHotelListMap.ceilingKey(movingScore) != null){
			keyScore = scoreToHotelListMap.ceilingKey(movingScore);
			list.addAll(scoreToHotelListMap.get(keyScore));
			movingScore = keyScore + 0.0001;
		}
		return list;
	}

	//TreeMap is BST implementation in Java
	private static TreeMap<Double, ArrayList<String>> constructScoreToHotelListMap(HashMap<String, Score> idToAvgScoreObjMap){
		TreeMap<Double, ArrayList<String>> scoreToHotelListMap = new TreeMap<>();
		for (Map.Entry<String, Score> entry: idToAvgScoreObjMap.entrySet()){
			ArrayList<String> hotelList = new ArrayList<>();

			double avgScore = entry.getValue().avgScore;
			if(scoreToHotelListMap.containsKey(avgScore)){
				hotelList = scoreToHotelListMap.get(avgScore);
			}
			hotelList.add(entry.getKey());
			scoreToHotelListMap.put(avgScore, hotelList);
		}
        System.out.println("scoreToHotelListMap :"+scoreToHotelListMap);
		return scoreToHotelListMap;
	}

	// produces hotel id -> Score object
	private static HashMap<String, Score> readAndProcessData(String fileName){
		HashMap<String, Score> idToAvgScoreObjMap = new HashMap<>();
		String line ="";
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while((line = reader.readLine())!=null)
			{
				String[] splits = line.split(",");
				String hotelId = splits[1];
				double score = Double.valueOf(splits[2]);

				Score newSObj = new Score(score, 1.0, score);
				if(idToAvgScoreObjMap.containsKey(hotelId))
				{
					Score sObj = idToAvgScoreObjMap.get(hotelId);
					newSObj = new Score(sObj.tScore + score,  sObj.num + 1, (sObj.tScore + score)/(sObj.num +1));
				}
				idToAvgScoreObjMap.remove(hotelId);
				idToAvgScoreObjMap.put(hotelId, newSObj);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return idToAvgScoreObjMap;
	}

    public static void main(String[] args) {
        String fileName = "/Users/knidhi/eclipse-workspace/Algorithms/src/com/coding/webnair/assign7/hotelrating.txt";
        
        HashMap<String, Score> hotelToScoreObjMap = readAndProcessData(fileName);
        TreeMap<Double, ArrayList<String>> scoreToHotelListMap = constructScoreToHotelListMap(hotelToScoreObjMap);

        System.out.println("All Hotels: "+ hotelToScoreObjMap.keySet());
        System.out.println("hotelToScoreObjMap: "+ hotelToScoreObjMap);

        double score = 7.0;
        ArrayList<String> list = searchHotel(scoreToHotelListMap, score);
        System.out.println("Hotels with avg score > "+ score + ": "+list);

        score = 4.0;
        list = searchHotel(scoreToHotelListMap, score);
        System.out.println("Hotels with avg score > "+ score + ": "+list);

        score = 9.0;
        list = searchHotel(scoreToHotelListMap, score);
        System.out.println("Hotels with avg score > "+ score + ": "+list);

        score = 9.9;
        list = searchHotel(scoreToHotelListMap, score);
        System.out.println("Hotels with avg score > "+ score + ": "+list);
    }
}

class Score {
	double tScore;
	double num;
	double avgScore;

	public Score (){
		this.tScore =0.0;
		this.num = 0.0;
		this.avgScore= 0.0;
	}

	public Score(double totalScore, double num, double avgScore){
		this.tScore =totalScore;
		this.num = num;
		this.avgScore= avgScore;
	}

    @Override
    public String toString() {
        String str = "tScore: "+ tScore + ", num: "+ num +", avgScore"+ avgScore;
        return str;
    }
}
