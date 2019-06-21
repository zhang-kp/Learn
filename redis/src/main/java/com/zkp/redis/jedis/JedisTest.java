package com.zkp.redis.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {


    public static void main(String[] args) {


        Jedis jedis = new Jedis("192.168.0.108",6379);

        String ping = jedis.ping();

        System.out.println(ping);


    }

}
