package com.knoldus.producer;

import com.knoldus.model.User_Input;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args){


        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.knoldus.serializer.User_Serializer");

        int age=24;

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try{
            {
                User_Input user = new User_Input(1," RISHI KUMAR RAY",age,"B.Tech");
                System.out.println(user);
                kafkaProducer.send(new ProducerRecord("user", user));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
    }
}