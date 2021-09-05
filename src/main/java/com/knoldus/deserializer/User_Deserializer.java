package com.knoldus.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.model.User_Input;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class User_Deserializer implements Deserializer<User_Input> {
    @Override public void close() {
    }
    @Override public void configure(Map<String, ?> arg0, boolean arg1) {
    }
    @Override
    public User_Input deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        User_Input userInput = null;
        try {
            userInput = mapper.readValue(arg1, User_Input.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInput;
    }
}