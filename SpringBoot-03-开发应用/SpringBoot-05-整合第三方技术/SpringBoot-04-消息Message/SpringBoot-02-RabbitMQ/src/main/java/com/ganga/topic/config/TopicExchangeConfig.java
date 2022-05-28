package com.ganga.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

    @Bean
    public Queue queueTopic(){
        return new Queue("topic_queue_uid");
    }

    @Bean
    public Queue queueTopic2(){
        return new Queue("topic_queue2_uid");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding topicBinding(){
        return BindingBuilder.bind(queueTopic()).to(topicExchange()).with("topic.user.*");
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(queueTopic2()).to(topicExchange()).with("#.uid");
    }


}
