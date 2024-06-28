package org.example;

import redis.clients.jedis.Jedis;

public class RedisCrudExample {

    public static void main(String[] args) {
        // Connect to Redis cluster nodes

        try (Jedis jedis1 = new Jedis("localhost", 6361); Jedis jedis2 = new Jedis("localhost", 6362); Jedis jedis3 = new Jedis("localhost", 6363)) {
            // Perform put operation (SET)
            jedis1.set("key1", "value1");
            jedis2.set("key2", "value2");
            jedis3.set("key3", "value3");

            // Perform get operation (GET)
            String value1 = jedis1.get("key1");
            String value2 = jedis2.get("key2");
            String value3 = jedis3.get("key3");

            // Print retrieved values
            System.out.println("Retrieved values:");
            System.out.println("key1: " + value1);
            System.out.println("key2: " + value2);
            System.out.println("key3: " + value3);

        }
        // Close connections
    }
}
