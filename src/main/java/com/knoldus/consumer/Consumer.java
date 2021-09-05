package com.knoldus.consumer;

import com.knoldus.model.User_Input;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {
        ConsumerListener c = new ConsumerListener();
        Thread thread = new Thread(c);
        thread.start();
    }
    public static void consumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "com.knoldus.deserializer.User_Deserializer");
        properties.put("group.id", "test-group");

        KafkaConsumer<String, User_Input> kafkaConsumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        topics.add("user");
        kafkaConsumer.subscribe(topics);
        try{
            // Message1
            while (true){
                ConsumerRecords<String, User_Input> records = kafkaConsumer.poll(10000);
                for (ConsumerRecord<String, User_Input> record: records){
                    System.out.println(record.value());

                    BufferedWriter buffer = new BufferedWriter(new FileWriter("record_output.txt", true));
                    buffer.write(record.value()+"\n"); // this will write the user records in record_output.txt file.
                    buffer.close();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            kafkaConsumer.close();
        }
    }
}

class ConsumerListener implements Runnable {


    @Override
    public void run() {
        Consumer.consumer();
    }
}