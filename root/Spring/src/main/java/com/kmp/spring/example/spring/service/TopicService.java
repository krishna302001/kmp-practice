package com.kmp.spring.example.spring.service;

import com.kmp.spring.example.spring.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Spring", "Spring F", "Srping Desc"),
            new Topic("Java", "Java F", "Java Desc"),
            new Topic("Python", "Py F", "P Desc")));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic createTopic(Topic topic){
        topics.add(topic);
        return topic;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }


    public void updateTopic(Topic topic, String id) {
        Topic topicToUpdate = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        topics.set(topics.indexOf(topicToUpdate), topic);
    }

    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
