package io.jb.spbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "spring fW", "spring desc"),
			new Topic("java", "java fW", "java desc"),
			new Topic("java script", "java script fW", "java script desc")
			));


	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic)
	{
		topics.add(topic);
	}

	public Topic updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++)
		{
			if(topics.get(i).getId().equals(id))
			{
				topics.set(i, topic);
			}
		}
		return topic;
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
	
		
}
