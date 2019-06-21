
Link https://mp.weixin.qq.com/s/rkHbxuiClzNJNl6ZzXJLFA

[Redis江南一点雨](https://mp.weixin.qq.com/s/0Bukv4bFGMWosG8SWWoDDw)

#### Java 客户端

1. [Jedis](https://mp.weixin.qq.com/s/4ghSyd8BIq01LYhhjToXrg)  不需要配置文件
```
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
        </dependency>
```

2. [Spring-Data-Redis](https://mp.weixin.qq.com/s/LcQNcVbSRmx19YgqvGtjzQ) 
 [点击查看更多](https://blog.csdn.net/qq_26545305/article/details/80559902)
 [更多](https://juejin.im/post/5ad6acb4f265da239e4e9906)
 [RedisTemplate的使用来存储Map集合](https://blog.51cto.com/13501268/2312854)
 ````
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-redis</artifactId>
            <version>RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
            <version>RELEASE</version>
        </dependency>
````
在resources目录下创建redis.properties文件作为redis的配置文件:
```
redis.host=192.168.0.178
redis.port=6379
redis.maxIdle=300
redis.maxTotal=600
redis.maxWait=1000
redis.testOnBorrow=true

```

#### SpringDataRedis使用说明 
```
stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
stringRedisTemplate.boundValueOps("test").increment(1);//val +1
stringRedisTemplate.getExpire("test")//根据key获取过期时间
stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
stringRedisTemplate.delete("test");//根据key删除缓存
stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合

```

#### SpringBoot Cach缓存使用
存储在java虚拟机中，方法简单，方法较少
1. 在application启动类上加注解 @EnableCathing
2. 在使用的方法上加上@Cacheable (value="gathering",key="#id") value代表一个大集合，可以存很多key,key="#id",代表将id存入里面gathering里面 //这种写法代表以后优先从缓存中取