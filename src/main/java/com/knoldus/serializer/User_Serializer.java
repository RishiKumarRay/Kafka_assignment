package com.knoldus.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.knoldus.model.User_Input;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class User_Serializer implements Serializer<User_Input> {

    @Override public void configure(Map<String, ?> map, boolean b) {

    }

    @Override public byte[] serialize(String arg0, User_Input arg1) {
        byte[] val = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            val = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    @Override public void close() {

    }

}
